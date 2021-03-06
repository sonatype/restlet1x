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
package org.restlet.ext.jaxrs.internal.todo;

/**
 * Here are notices for the implementation.
 * 
 * @author Stephan Koops
 */
public class Notices {

    // TESTEN do not decode @FormParam, @MatrixParam, @QueryParam
    // TESTEN do not encode keys of Form entity

    // TESTEN what happens, if ".." or "." in @Path?

    // run tests again Jersey.

    // TODO test, if the URIs are normaized, see spec, sect. 3.7.1 "Request
    // Preprocessing"

    // TESTEN *ExceptionWriter, see JSR311-dev-mail 1225
    // https://jsr311.dev.java.net/servlets/ReadMsg?list=dev&msgNo=1225

    // NICE Provider for File-Upload by a browser (multipart/form-data)

    // NICE warn if primitve on @*Param: perhaps null?

    // NICE look for warnings in tests and put them away.

    // NICE When writing responses, implementations SHOULD respect
    // application-supplied character set metadata and SHOULD use UTF-8 if a
    // character set is not specified by the application or if the application
    // specifies a character set that is unsupported.

    // NICE JaxRsComponent
    // http://restlet.tigris.org/issues/show_bug.cgi?id=464#desc17
    // http://restlet.tigris.org/issues/show_bug.cgi?id=464#desc19

    // NICE Entity-Provider for org.restlet.data.Representation
    // NICE ResourceException-ExceptionMapper as WebAppExcMapper ?
}