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

/**
 * Indicates, that the JAX-RS implementation observed, that it contains an error
 * in itself. An example is, if a default provider could not be loaded.
 * 
 * @author Stephan Koops
 */
public class ImplementationException extends JaxRsRuntimeException {

    private static final long serialVersionUID = 5635188228961655076L;

    /**
     * @param message
     */
    public ImplementationException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public ImplementationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public ImplementationException(Throwable cause) {
        super(cause);
    }
}