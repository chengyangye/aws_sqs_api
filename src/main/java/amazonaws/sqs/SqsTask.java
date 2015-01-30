package amazonaws.sqs;

public class SqsTask {
	
	public static void main(String args[]) throws Exception{
		new Thread(new SqsTestSet1Task().init()).start();
		new Thread(new SqsTestSet10Task().init()).start();
		new Thread(new SqsTestGet1Task().init()).start();
		new Thread(new SqsTestGet10Task().init()).start();
	}
}
