/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.stmt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import org.junit.Test;
import org.opendaylight.yangtools.yang.model.api.Deviation;
import org.opendaylight.yangtools.yang.model.api.Module;
import org.opendaylight.yangtools.yang.model.api.SchemaContext;
import org.opendaylight.yangtools.yang.parser.spi.meta.ReactorException;
import org.opendaylight.yangtools.yang.parser.spi.source.SourceException;

public class Bug4933Test {

    @Test
    public void test() throws Exception {
        SchemaContext context = StmtTestUtils.parseYangSources("/bugs/bug4933/correct");
        assertNotNull(context);

        final Module foo = context.findModules("foo").iterator().next();
        Collection<? extends Deviation> deviations = foo.getDeviations();
        assertEquals(4, deviations.size());
    }

    @Test
    public void incorrectKeywordTest() throws Exception {
        try {
            StmtTestUtils.parseYangSources("/bugs/bug4933/incorrect");
            fail("ReactorException should be thrown.");
        } catch (ReactorException e) {
            final Throwable cause = e.getCause();
            assertThat(cause, isA(SourceException.class));
            assertTrue(cause.getMessage().startsWith("String 'not_supported' is not valid deviate argument"));
        }
    }
}
