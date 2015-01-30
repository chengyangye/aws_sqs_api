package amazonaws.sqs;

import java.util.List;
import amazonaws.sqs.util.QMessage;


public class SqsTestGet1Task implements Runnable {
    Queue testQueue = null;

	public SqsTestGet1Task() {
		
	}

	public SqsTestGet1Task init() throws Exception {
		testQueue = SingletonQueue.getInstance();
		return this;
	}

	@Override
	public void run() {
//      long a=System.currentTimeMillis();
        try {
			do {
			List<QMessage> messages = testQueue.receiveMessage(10);
			if(0 == messages.size()){
				System.out.println("Thread1 sleep");
				Thread.sleep(1000);
				continue;
			}
			for(QMessage message : messages){
				  System.out.println("Thread1 message content: " + message.getContent());
				  testQueue.deleteMessage(message.getReceiptHandle());
			}

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

