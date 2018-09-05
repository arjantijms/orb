/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package pi.clientrequestinfo;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.ORBPackage.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAPackage.*;
import org.omg.PortableInterceptor.*;
import corba.framework.*;
import com.sun.corba.ee.spi.misc.ORBConstants;
import com.sun.corba.ee.impl.interceptors.*;

import java.util.*;
import java.io.*;

import ClientRequestInfo.*; // hello interface

public class POALocalServer {
    // Set from run()
    private PrintStream out;
    
    private static final String ROOT_POA = "RootPOA";
    
    private POA rootPOA;
    
    private com.sun.corba.ee.spi.orb.ORB orb;

    public void run( com.sun.corba.ee.spi.orb.ORB orb, java.lang.Object syncObject, 
                     Properties environment, String args[], PrintStream out, 
                     PrintStream err, Hashtable extra) 
        throws Exception
    {
        this.out = out;
        this.orb = orb;

        // Get the root POA:
        rootPOA = null;
        out.println( "Obtaining handle to root POA and activating..." );
        try {
            rootPOA = (POA)orb.resolve_initial_references( ROOT_POA );
        }
        catch( InvalidName e ) {
            err.println( ROOT_POA + " is an invalid name." );
            throw e;
        }
        rootPOA.the_POAManager().activate();
        
        // Set up hello object and helloForward object for POA remote case:
        createAndBind( "Hello1" );
        createAndBind( "Hello1Forward" );
        
        // no handshake required here.
        //out.println("Server is ready.");
        //out.flush();

        // notify client to wake up:
        synchronized( syncObject ) {
            syncObject.notifyAll();
        }

        // wait for invocations from clients
        java.lang.Object sync = new java.lang.Object();
        synchronized (sync) {
            sync.wait();
        }

    }
    
    /**
     * Implementation borrowed from corba.socket.HelloServer test
     */
    public void createAndBind (String name)
        throws Exception
    {
        // create servant and register it with the ORB
        helloServant helloRef = new helloServant( out );
      
        byte[] id = rootPOA.activate_object(helloRef);
        org.omg.CORBA.Object ref = rootPOA.id_to_reference(id);
      
        // get the root naming context
        org.omg.CORBA.Object objRef = 
            orb.resolve_initial_references("NameService");
        NamingContext ncRef = NamingContextHelper.narrow(objRef);
      
        // bind the Object Reference in Naming
        NameComponent nc = new NameComponent(name, "");
        NameComponent path[] = {nc};
            
        ncRef.rebind(path, ref);
    }

}