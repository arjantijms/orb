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

package alpha.bravo;

public class Warthog implements java.io.Serializable {
    int shoeSize;

    void eat( int arg ) throws java.rmi.RemoteException {}
    void drink( int arg ) throws java.lang.RuntimeException {}
    void slurp( int arg ) throws java.lang.ArithmeticException {}

    int getFoo() throws java.rmi.RemoteException { return 1; }
    void setFoo( int arg ) throws java.rmi.RemoteException {}

    private void test() throws java.rmi.RemoteException {}
    public void test( int x ) throws java.rmi.RemoteException {}

}
