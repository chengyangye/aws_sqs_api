
package amazonaws.sqs.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendMessageResult element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="SendMessageResult">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="MD5OfMessageBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "messageId",
    "md5OfMessageBody"
})
@XmlRootElement(name = "SendMessageResult")
public class SendMessageResult {

    @XmlElement(name = "MessageId", namespace = "http://queue.amazonaws.com/doc/2012-11-05/", required = true)
    protected String messageId;
    @XmlElement(name = "MD5OfMessageBody", namespace = "http://queue.amazonaws.com/doc/2012-11-05/", required = true)
    protected String md5OfMessageBody;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the md5OfMessageBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMD5OfMessageBody() {
        return md5OfMessageBody;
    }

    /**
     * Sets the value of the md5OfMessageBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMD5OfMessageBody(String value) {
        this.md5OfMessageBody = value;
    }

}
