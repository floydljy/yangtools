/*
 * Copyright (c) 2015 Pantheon Technologies s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.model.util.type;

import org.eclipse.jdt.annotation.NonNull;
import org.opendaylight.yangtools.yang.model.api.type.Int8TypeDefinition;
import org.opendaylight.yangtools.yang.model.util.BaseTypes;

final class BaseInt8Type extends AbstractRangeRestrictedBaseType<Int8TypeDefinition, Byte>
        implements Int8TypeDefinition {
    static final @NonNull BaseInt8Type INSTANCE = new BaseInt8Type();

    private BaseInt8Type() {
        super(BaseTypes.INT8_QNAME, Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    @Override
    public int hashCode() {
        return Int8TypeDefinition.hashCode(this);
    }

    @Override
    public boolean equals(final Object obj) {
        return Int8TypeDefinition.equals(this, obj);
    }

    @Override
    public String toString() {
        return Int8TypeDefinition.toString(this);
    }
}
