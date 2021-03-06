/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.model.repo.api;

import com.google.common.annotations.Beta;
import java.util.Objects;
import java.util.Optional;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.opendaylight.yangtools.yang.common.Revision;

/**
 * YANG Schema revision source identifier.
 *
 * <p>
 * Simple transfer object represents revision identifier of source for YANG schema (module or submodule), which consists
 * of
 * <ul>
 * <li>YANG schema name ({@link #getName()}
 * <li>Module revision (optional) ({link {@link #getRevision()})
 * </ul>
 *
 * <p>
 * Revision source identifier is designated to be carry only necessary information to look-up YANG model source
 * and to be used by various SchemaSourceProviders.
 *
 * <p>
 * <b>Note:</b>On source retrieval layer it is impossible to distinguish between YANG module and/or submodule unless
 * source is present.
 *
 * <p>
 * (For further reference see: http://tools.ietf.org/html/rfc6020#section-5.2
 * and http://tools.ietf.org/html/rfc6022#section-3.1 ).
 */
@Beta
public final class RevisionSourceIdentifier extends SourceIdentifier {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new YANG Schema revision source identifier for sources without a revision.
     *
     * @param name Name of schema
     */
    RevisionSourceIdentifier(final String name) {
        super(name);
    }

    /**
     * Creates new YANG Schema revision source identifier.
     *
     * @param name Name of schema
     * @param revision Revision of source, may be null
     */
    RevisionSourceIdentifier(final String name, final @Nullable Revision revision) {
        super(name, revision);
    }

    /**
     * Creates new YANG Schema revision source identifier.
     *
     * @param name Name of schema
     * @param formattedRevision Revision of source, potentially not present
     */
    private RevisionSourceIdentifier(final String name, final Optional<Revision> revision) {
        super(name, revision);
    }

    /**
     * Creates new YANG Schema revision source identifier.
     *
     * @param moduleName Name of schema
     * @param revision Revision of source in format YYYY-mm-dd. If not present, default value will be used.
     * @return A RevisionSourceIdentifier
     */
    public static @NonNull RevisionSourceIdentifier create(final String moduleName, final Optional<Revision> revision) {
        return new RevisionSourceIdentifier(moduleName, revision);
    }

    /**
     * Creates new YANG Schema revision source identifier.
     *
     * @param moduleName Name of schema
     * @param revision Revision of source, may be null
     * @return A RevisionSourceIdentifier
     */
    public static @NonNull RevisionSourceIdentifier create(final String moduleName, final @Nullable Revision revision) {
        return new RevisionSourceIdentifier(moduleName, revision);
    }

    /**
     * Creates new YANG Schema revision source identifier for sources without
     * a revision.
     *
     * @param moduleName Name of schema
     * @return A RevisionSourceIdentifier
     */
    public static @NonNull RevisionSourceIdentifier create(final String moduleName) {
        return new RevisionSourceIdentifier(moduleName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(getName());
        result = prime * result + Objects.hashCode(getRevision());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RevisionSourceIdentifier)) {
            return false;
        }
        final RevisionSourceIdentifier other = (RevisionSourceIdentifier) obj;
        return Objects.equals(getName(), other.getName()) && Objects.equals(getRevision(), other.getRevision());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RevisionSourceIdentifier [name=");
        sb.append(getName());

        final Optional<Revision> rev = getRevision();
        if (rev.isPresent()) {
            sb.append('@').append(rev.get());
        }
        return sb.append(']').toString();
    }
}
