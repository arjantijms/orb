/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.glassfish.rmic.asm;

import org.glassfish.rmic.tools.java.ClassDefinitionFactoryTest;
import org.junit.Test;
import org.objectweb.asm.Opcodes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AsmClassFactoryTest extends ClassDefinitionFactoryTest {

    public AsmClassFactoryTest() {
        super(new AsmClassFactory());
    }

    @Test
    public void canRetrieveLatestAsmVersion() {
        assertThat(AsmClassFactory.getLatestVersion(), equalTo(Opcodes.ASM6));
    }
}
