package amazonaws.sqs;


public class SqsTestSet1Task implements Runnable {
    Queue testQueue = null;

	public SqsTestSet1Task() {
		
	}

	public SqsTestSet1Task init() throws Exception {
		testQueue = SingletonQueue.getInstance();
		return this;
	}

	@Override
	public void run() {
//      long a=System.currentTimeMillis();
      for(int i =0; i<100; i++){
          // send a message
      	try {
			String msgId = testQueue.sendMessage("测试消息"+String.valueOf(i)).getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      String qCount;
	try {
		qCount = testQueue.getApproximateNumberOfMessages();
	    System.out.println("Approximate Number of Messages: " + qCount);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//      System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
	}	
}

