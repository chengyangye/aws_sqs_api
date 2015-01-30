package amazonaws.sqs;

import java.util.ArrayList;
import java.util.List;


public class SqsTestSet10Task implements Runnable {
    Queue testQueue = null;

	public SqsTestSet10Task() {
		
	}

	public SqsTestSet10Task init() throws Exception {
		testQueue = SingletonQueue.getInstance();
		return this;
	}

	@Override
	public void run() {
//      long a=System.currentTimeMillis();
	for(int j=0; j<10; j++){
		List<String> list = new ArrayList<String>();
		for(int i=0; i<10; i++){
			list.add("测试消息"+String.valueOf(j)+String.valueOf(i));
		}
		try {
			testQueue.sendMessageList(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue;
		}
	}

//      System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
	}	
}

