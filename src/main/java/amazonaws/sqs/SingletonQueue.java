package amazonaws.sqs;

import amazonaws.sqs.model.TestPara;
import amazonaws.sqs.util.QueueException;

public class SingletonQueue {
	
    private static Queue testQueue = null;  
    
    private SingletonQueue() {  
       // Exists only to defeat instantiation.  
    } 
    
    private static synchronized void syncInit() throws Exception {  
	    boolean retry = false;
	    do {
	        retry = false;
	        try {
	            testQueue = Queue.createQueue(TestPara.queueName);
	            System.out.println("Queue created: " + testQueue.getQueueEndpoint());              
	        } catch (QueueException e) {
	            System.out.println("CreateQueue failed with error: " + e.getErrorCode());
	            if (e.getErrorCode().equals("AWS.SimpleQueueService.QueueDeletedRecently")) {
	                System.out.println("Recently Deleted Queue, wait 60 seconds");
	                Thread.sleep(60 * 1000);
	                retry = true;
	            } else {
	                throw e;
	            }
	        }
	    } while (retry);
      }  
    
      public static Queue getInstance() throws Exception{  
        if (testQueue == null) {
        	syncInit();
        }  
        return testQueue;  
      }
}
