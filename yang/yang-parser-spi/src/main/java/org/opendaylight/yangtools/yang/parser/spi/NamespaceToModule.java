/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.parser.spi;

import org.eclipse.jdt.annotation.NonNull;
import org.opendaylight.yangtools.yang.common.QNameModule;
import org.opendaylight.yangtools.yang.model.api.stmt.ModuleEffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.stmt.ModuleStatement;
import org.opendaylight.yangtools.yang.parser.spi.meta.NamespaceBehaviour;
import org.opendaylight.yangtools.yang.parser.spi.meta.StatementNamespace;
import org.opendaylight.yangtools.yang.parser.spi.meta.StmtContext;

/**
 * A derived namespace allowing lookup of modules based on their {@link QNameModule}.
 */
public interface NamespaceToModule extends StatementNamespace<QNameModule, ModuleStatement, ModuleEffectiveStatement> {
    NamespaceBehaviour<QNameModule, StmtContext<?, ModuleStatement, ModuleEffectiveStatement>,
            @NonNull NamespaceToModule> BEHAVIOUR = NamespaceBehaviour.global(NamespaceToModule.class);
}
