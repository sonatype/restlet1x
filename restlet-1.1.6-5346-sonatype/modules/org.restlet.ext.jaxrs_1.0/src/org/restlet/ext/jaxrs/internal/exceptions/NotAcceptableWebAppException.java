/**
 * Copyright 2005-2008 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of the following open
 * source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.gnu.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.sun.com/cddl/cddl.html
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royaltee free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */
package org.restlet.ext.jaxrs.internal.exceptions;

import java.util.Collection;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Variant;
import javax.ws.rs.core.Response.Status;

/**
 * The resource identified by the request is only capable of generating response
 * entities which have content characteristics not acceptable according to the
 * accept headers sent in the request.
 * 
 * @author Stephan Koops
 * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.7">RFC 2616,
 *      Section 10.4.7, "406 Not Acceptable"</a>
 */
public class NotAcceptableWebAppException extends WebApplicationException {

    private static final long serialVersionUID = 6895779829973209211L;

    private final Collection<Variant> supported;

    /**
     * @param supported
     *            the supported variants, selectable by the accept headers.
     */
    public NotAcceptableWebAppException(Collection<Variant> supported) {
        super(Status.NOT_ACCEPTABLE);
        if (supported == null) {
            throw new IllegalArgumentException(
                    "The allowed variants must not be null");
        }
        this.supported = supported;
    }

    /**
     * Returns the supported {@link Variant}s.
     * 
     * @return the supported variants.
     */
    public Collection<Variant> getSupported() {
        return this.supported;
    }
}