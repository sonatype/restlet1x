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

import java.lang.reflect.InvocationTargetException;

/**
 * Indicates, that an invoke of a resource method was not possible. If the
 * invoked method throws a Throwable, the {@link InvocationTargetException} must
 * be used.
 * 
 * @author Stephan Koops
 */
public class MethodInvokeException extends JaxRsException {

    private static final long serialVersionUID = 1766085431784085073L;

    /**
     * @param message
     */
    public MethodInvokeException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public MethodInvokeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public MethodInvokeException(Throwable cause) {
        super(cause);
    }
}