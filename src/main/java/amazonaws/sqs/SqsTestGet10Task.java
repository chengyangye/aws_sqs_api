package amazonaws.sqs;

import java.util.ArrayList;
import java.util.List;
import amazonaws.sqs.util.QMessage;


public class SqsTestGet10Task implements Runnable {
    Queue testQueue = null;

	public SqsTestGet10Task() {
		
	}

	public SqsTestGet10Task init() throws Exception {
		testQueue = SingletonQueue.getInstance();
		return this;
	}

	@Override
	public void run() {
//      long a=System.currentTimeMillis();
        try {
			do {
	        String qCount = testQueue.getApproximateNumberOfMessages();
	        System.out.println("Approximate Number of Messages: " + qCount);	
			List<QMessage> messages = testQueue.receiveMessage(10);
			if(0 == messages.size()){
				System.out.println("Thread2 sleep");
				Thread.sleep(1000);
				continue;
			}
			qCount = testQueue.getApproximateNumberOfMessages();
	        System.out.println("Approximate Number of Messages: " + qCount);
			List<String> list = new ArrayList<String>();
			for(QMessage message : messages){
				  System.out.println("Thread2 message content: " + message.getContent());
				  list.add(message.getReceiptHandle());
//				  testQueue.deleteMessage(message.getReceiptHandle());
			}
			testQueue.deleteMessageList(list);
			qCount = testQueue.getApproximateNumberOfMessages();
	        System.out.println("Approximate Number of Messages: " + qCount);
     } while (true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//      System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
	}	
}

