/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 1998-1999 IBM Corp. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.omg.stub.java.rmi;

import java.rmi.Remote;
import javax.rmi.CORBA.Stub;

/**
 * This class provides the Stub for the Remote Type.  The class is generated
 * by the rmic compiler, and is still under works at OMG.  It's contents are
 * subject to change without notice as the specification evolves.
 */
public final class _Remote_Stub extends Stub implements Remote {

    private static final String _type_ids[] = {
        ""
    };
    
    /**
     * Returns an array of repository ids that an object implements.
     * The string at index zero represents the most derived interface.  The last id,
     * for the generic CORBA object is (i.e., IDL:omg.org/CORBA/Object:1.0") is
     * implied and not present.
     * @return an array of repository ids that an object implements.
     */
    public String[] _ids() {
        return (String[]) _type_ids.clone();
    } 
}