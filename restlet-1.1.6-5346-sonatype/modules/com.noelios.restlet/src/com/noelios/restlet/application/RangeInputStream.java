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

package com.noelios.restlet.application;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.restlet.data.Range;
import org.restlet.resource.Representation;

/**
 * Filters an input stream to expose only a given range.
 * 
 * @author Jerome Louvel
 */
public class RangeInputStream extends FilterInputStream {

    /** The current position. */
    private long position;

    /** The range to satisfy. */
    private Range range;

    /** The total size of the source stream. */
    private long totalSize;

    /** The start index inside the source stream. */
    private final long startIndex;

    /** The end index inside the source stream. */
    private final long endIndex;

    /**
     * Constructs a stream exposing only a range of a given source stream.
     * 
     * @param in
     *            The source input stream.
     * @param totalSize
     *            The total size of the source stream.
     * @param range
     *            The range to satisfy.
     */
    protected RangeInputStream(InputStream in, long totalSize, Range range) {
        super(in);
        this.range = range;
        this.position = 0;
        this.totalSize = totalSize;
        if (totalSize == Representation.UNKNOWN_SIZE) {
            if (range.getIndex() == Range.INDEX_LAST) {
                if (range.getSize() == Range.SIZE_MAX) {
                    // Read the whole stream
                    this.startIndex = -1;
                    this.endIndex = -1;
                } else {
                    throw new IllegalArgumentException(
                            "Can't determine the start and end index.");
                }
            } else {
                if (range.getSize() == Range.SIZE_MAX) {
                    this.startIndex = range.getIndex();
                    this.endIndex = -1;
                } else {
                    this.startIndex = range.getIndex();
                    this.endIndex = range.getIndex() + range.getSize() - 1;
                }
            }
        } else {
            if (range.getIndex() == Range.INDEX_LAST) {
                if (range.getSize() == Range.SIZE_MAX) {
                    this.startIndex = -1;
                    this.endIndex = -1;
                } else {
                    this.startIndex = totalSize - range.getSize();
                    this.endIndex = -1;
                }
            } else {
                if (range.getSize() == Range.SIZE_MAX) {
                    this.startIndex = range.getIndex();
                    this.endIndex = -1;
                } else {
                    this.startIndex = range.getIndex();
                    this.endIndex = range.getIndex() + range.getSize() - 1;
                }
            }
        }
    }

    @Override
    public int available() throws IOException {
        // Might need a smarter logic to restrict available bytes to the
        // range
        return super.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        if (range.getIndex() == Range.INDEX_LAST) {
            super.mark(readlimit + (int) (totalSize - range.getSize()));
        } else {
            super.mark(readlimit + (int) range.getIndex());
        }
    }

    @Override
    public int read() throws IOException {
        int result = super.read();

        while ((result != -1) && !this.range.isIncluded(position++, totalSize)) {
            result = super.read();
        }

        return result;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        // Reach the start index.
        while (!(position >= startIndex)) {
            long skipped = skip(startIndex - position);
            if (skipped <= 0) {
                throw new IOException("Cannot skip ahead in FilterInputStream");
            }
            position += skipped;
        }

        int n = -1;
        if (endIndex != -1) {
            // Read up until the end index
            if (position > endIndex) {
                // The end index is reached.
                n = -1;
            } else {
                // Take care to read the right number of octets according to the
                // end index and the buffer size.
                n = super.read(b, off,
                        ((position + len) > endIndex) ? (int) (endIndex
                                - position + 1) : len);
            }
        } else {
            // Read normally up until the end of the stream.
            n = super.read(b, off, len);
        }

        if (n > 0) {
            // Move the cursor.
            position += n;
        }

        return n;
    }
}
