//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.0.5-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2008.03.12 at 05:42:04 PM CET
//

package org.restlet.example.book.restlet.ch7.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Customer complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;Customer&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;attribute name=&quot;city&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;phone&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;state&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;street&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;zip&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer")
@XmlRootElement(name = "Customer")
public class Customer {

    @XmlAttribute
    protected String city;

    @XmlAttribute
    protected String phone;

    @XmlAttribute
    protected String state;

    @XmlAttribute
    protected String street;

    @XmlAttribute
    protected Integer zip;

    /**
     * Gets the value of the city property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getState() {
        return this.state;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getZip() {
        return this.zip;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setZip(Integer value) {
        this.zip = value;
    }

}
