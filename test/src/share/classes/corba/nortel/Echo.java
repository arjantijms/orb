/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package corba.nortel;

import java.rmi.Remote ;
import java.rmi.RemoteException ;

import java.util.Collection ;

public interface Echo extends Remote {
    Echo say( Echo obj ) throws RemoteException ;

    String name() throws RemoteException ;

    Collection methodCollectionUserInfo( String str, UserInfo ui ) throws RemoteException ;

    Collection methodCollectionObject( String str, Object ui ) throws RemoteException ;
}


