/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

//
// Created       : 2005 Jun 13 (Mon) 11:04:09 by Harold Carr.
// Last Modified : 2005 Sep 23 (Fri) 13:17:38 by Harold Carr.
//

package corba.folb;

import java.rmi.RemoteException;
import javax.rmi.PortableRemoteObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.corba.ee.spi.orb.ORB;

import com.sun.corba.ee.impl.misc.ORBUtility;

import corba.hcks.U;

/**
 * @author Harold Carr
 */
public class GroupInfoServiceTestServant
    extends PortableRemoteObject
    implements GroupInfoServiceTest
{
    private ORB orb;
    private GroupInfoServiceImpl gis;

    public GroupInfoServiceTestServant(ORB orb, GroupInfoServiceImpl gis)
        throws RemoteException
    {
        this.orb = orb;
        this.gis = gis;
    }

    public boolean addInstance(final String x)
        throws RemoteException
    {
        dprint(".add->: " + x);
        // Must be done on a different thread so requests can drain.
        new Thread() {
            public void run()
            {
                gis.add(x);
            }
        }.start();
        dprint(".add<-: " + x);
        return true;
    }

    public boolean removeInstance(final String x)
        throws RemoteException
    {
        dprint(".remove->: " + x);
        // Must be done on a different thread so requests can drain.
        new Thread() {
            public void run()
            {
                gis.remove(x);
            }
        }.start();
        dprint(".remove<-: " + x);
        return true;
    }

    public boolean addAcceptor(String x) 
        throws RemoteException
    {
        dprint(".add->: " + x);
        boolean result = 
            U.registerAcceptor(
                x, 
                ((Integer)corba.folb_8_1.Common.socketTypeToPort.get(x)).intValue(), 
                orb);
        dprint(".add<-: " + x + " " + result);
        return result;
    }

    public boolean removeAcceptorAndConnections(String x)
        throws RemoteException
    {
        dprint(".remove->: " + x);
        boolean result = U.unregisterAcceptorAndCloseConnections(x, orb);
        dprint(".remove<-: " + x + " " + result);
        return result;
    }

    public void doThreadDump()
        throws RemoteException
    {
        try {
            dprint(".doThreadDump->:\n");
            StringBuffer buf = new StringBuffer();
            for (Map.Entry<Thread, StackTraceElement[]> entry :
                     Thread.getAllStackTraces().entrySet())
            {
                buf.append("\n");
                buf.append(entry.getKey().toString() + "\n");
                for (StackTraceElement element : entry.getValue()) {
                    buf.append(element.toString() + "\n");
                }
            }
            dprint(".doThreadDump: " + buf);
        } finally {
            dprint(".doThreadDump<-:");
        }
    }

    ////////////////////////////////////////////////////
    //
    // Implementation
    //

    private static void dprint(String msg)
    {
        ORBUtility.dprint("GroupInfoServiceTestServant", msg);
    }
}

// End of file.
