package amazonaws.sqs;

import java.util.List;

import amazonaws.sqs.util.QMessage;
import amazonaws.sqs.util.QueueException;


public class SampleDriver {

/*    static public String accessKeyId = "";
    static public String secretAccessKey = "";
    static public String QueueServiceURL = "http://queue.amazonaws.com/";
    static private String queueName = "SQS-Test-Queue-Java";*/
	
//    static public String accessKeyId = "AKIAJY46QUWJSN2MY2VQ";//dpocket
//    static public String secretAccessKey = "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";//dpocket
//	static public String accessKeyId = "AKIAIAW5VMQIIDF2ASHQ";//ice
//    static public String secretAccessKey = "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";//ice
	static public String accessKeyId = "AKIAJQRSTGJJXEG3Z2FA";//ycy
    static public String secretAccessKey = "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";//ycy

    static public String QueueServiceURL = "https://sqs.ap-southeast-1.amazonaws.com";
    static private String queueName = "YCY-SQS-Test-Queue-Java";
//    static private String queueName = "test_sqs_youja_cn_ice";
    
    static private String testMessage = "This is a test message.";

    public static void main(String[] args) throws Exception {
        System.out.println("Amazon Sample SQS Java application");
        System.out.println("  - SQS WSDL 2012-11-05");
        System.out.println("For demonstration purposes only");
        System.out.println("--------------------------------------");

        // Before running this sample, you need to paste in your own accessKeyId
        // and your own accessKey
        if (accessKeyId.equals("") || secretAccessKey.equals("")) {
            System.out
            .println("Please paste the values for your accessKey and your accessKeyId into the program before running the sample.");
            System.exit(1);
        }

        Queue testQueue = null;

        // try out queue operations
        // create a queue
        boolean retry = false;
        do {
            retry = false;
            try {
                testQueue = Queue.createQueue(queueName);
                System.out.println("Queue created: " + testQueue.getQueueEndpoint());              
            } catch (QueueException e) {
                System.out.println("CreateQueue failed with error: " + e.getErrorCode());
                if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueDeletedRecently")) {
                    // let's wait 60 seconds before re-creating the queue
                    System.out.println("Recently Deleted Queue, wait 60 seconds");
                    Thread.sleep(60 * 1000); // wait 60 seconds
                    retry = true;
                } else {
                    // some other exception, rethrow
                    throw e;
                }
            }
        } while (retry);
        
        // list all my queues, verify our queue exists
        do {
            retry = true;
            List<Queue> queues = Queue.listQueues(queueName);
            System.out.println("Looking for queue " + testQueue.getQueueEndpoint());
            
            for(Queue queue : queues) {
                if(queue.getQueueEndpoint().equals(testQueue.getQueueEndpoint())) {
                    System.out.println("Queue found");
                    retry = false; 
                }
            }
            if(retry == true) {
                // If we didn't find the queue, give SQS a chance to
                // propagate...
                System.out.println("Queue not available yet - keep polling\r");
                Thread.sleep(10 * 1000);    // wait 10 seconds
            }
        } while(retry);
        
//        long a=System.currentTimeMillis();
        for(int i =0; i<5; i++){
            // send a message
        	String msgId = testQueue.sendMessage(/*testMessage+*/String.valueOf(i)).getId();
//            System.out.println("Message sent, message id: " + msgId);
        }
//        System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");

        // Get Approximate Queue Count...
        // Since SQS is a distributed system, the count may not be accurate.
        String qCount = testQueue.getApproximateNumberOfMessages();
        System.out.println("Approximate Number of Messages: " + qCount);

        // now receive a message
        // because SQS is a distributed system, we need to poll until we get
        // the message
/*        List<QMessage> messages = testQueue.receiveMessage(1);
        do {
            Thread.sleep(1000);  // wait for a second
            messages = testQueue.receiveMessage(1);
        } while (messages.size() == 0);


        QMessage message = messages.get(0);

        System.out.println("\nMessage received");
        System.out.println("  message id:     " + message.getId());
        System.out.println("  receipt handle: " + message.getReceiptHandle());
        System.out.println(" message content: " + message.getContent());

        testQueue.deleteMessage(message.getReceiptHandle());
        System.out.println("Deleted the message.");*/

//        List<QMessage> messages = testQueue.receiveMessage(1);
        do {
//            Thread.sleep(1000);  // wait for a second
        	List<QMessage> messages = testQueue.receiveMessage(1);
        	if(0 == messages.size()){
        		System.out.println("sleep");
        		Thread.sleep(1000);
        		continue;
        	}
            QMessage message = messages.get(0);
            System.out.println("\nMessage received");
//            System.out.println("  message id:     " + message.getId());
//            System.out.println("  receipt handle: " + message.getReceiptHandle());
            System.out.println(" message content: " + message.getContent());
            testQueue.deleteMessage(message.getReceiptHandle());
        } while (true);
//        testQueue.getApproximateNumberOfMessages();
/*        for(int j=0;j<10;j++){
            QMessage message = messages.get(j);
            testQueue.deleteMessage(message.getReceiptHandle());
//            System.out.println("Deleted the message.");
        }*/
    }
}
