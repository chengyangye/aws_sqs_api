
package amazonaws.sqs.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import amazonaws.sqs.generated.QueueServicePortType;
import amazonaws.sqs.generated.QueueServicePortType;

/**
 * This class was generated by the CXF 2.0-incubator
 * Wed Dec 19 16:11:11 PST 2007
 * Generated source version: 2.0-incubator
 * 
 */

@WebServiceClient(name = "QueueService", targetNamespace = "http://queue.amazonaws.com/doc/2012-11-05/", wsdlLocation = "file:/tmp/20080101/QueueService_20080101.wsdl")
public class QueueService extends Service {

    private final static URL WSDL_LOCATION;
    private final static QName SERVICE = new QName("http://queue.amazonaws.com/doc/2012-11-05/", "QueueService");
    private final static QName QueueServicePort = new QName("http://queue.amazonaws.com/doc/2012-11-05/", "QueueServicePort");
    private final static QName QueueServiceHttpsPort = new QName("http://queue.amazonaws.com/doc/2012-11-05/", "QueueServiceHttpsPort");
    static {
        URL url = null;
        try {
            url = new URL("http://aws-sqs2-fe-gamma.amazon.com/doc/2012-11-05/QueueService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://aws-sqs2-fe-gamma.amazon.com/doc/2012-11-05/QueueService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public QueueService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QueueService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns QueueServicePort
     */
    @WebEndpoint(name = "QueueServicePort")
    public QueueServicePortType getQueueServicePort() {
        return (QueueServicePortType)super.getPort(QueueServicePort, QueueServicePortType.class);
    }
    /**
     * 
     * @return
     *     returns QueueServiceHttpsPort
     */
    @WebEndpoint(name = "QueueServiceHttpsPort")
    public QueueServicePortType getQueueServiceHttpsPort() {
        return (QueueServicePortType)super.getPort(QueueServiceHttpsPort, QueueServicePortType.class);
    }

}
