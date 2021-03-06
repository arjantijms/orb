/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package corba.strm2;

import java.rmi.*;
import java.io.*;

public interface Tester extends Remote {

    String getDescription() throws RemoteException;

    Testable verify(Testable input) throws RemoteException;

}

