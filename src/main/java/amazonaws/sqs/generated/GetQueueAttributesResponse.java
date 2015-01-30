
package amazonaws.sqs.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetQueueAttributesResponse element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="GetQueueAttributesResponse">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}GetQueueAttributesResult"/>
 *           &lt;element ref="{http://queue.amazonaws.com/doc/2012-11-05/}ResponseMetadata"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQueueAttributesResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetQueueAttributesResponse")
public class GetQueueAttributesResponse {

    @XmlElement(name = "GetQueueAttributesResult", namespace = "http://queue.amazonaws.com/doc/2012-11-05/", required = true)
    protected GetQueueAttributesResult getQueueAttributesResult;
    @XmlElement(name = "ResponseMetadata", namespace = "http://queue.amazonaws.com/doc/2012-11-05/", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Gets the value of the getQueueAttributesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetQueueAttributesResult }
     *     
     */
    public GetQueueAttributesResult getGetQueueAttributesResult() {
        return getQueueAttributesResult;
    }

    /**
     * Sets the value of the getQueueAttributesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQueueAttributesResult }
     *     
     */
    public void setGetQueueAttributesResult(GetQueueAttributesResult value) {
        this.getQueueAttributesResult = value;
    }

    /**
     * Gets the value of the responseMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMetadata }
     *     
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * Sets the value of the responseMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMetadata }
     *     
     */
    public void setResponseMetadata(ResponseMetadata value) {
        this.responseMetadata = value;
    }

}