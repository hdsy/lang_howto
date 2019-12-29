package ThreadLearning;

public class HelloWorldThread extends Thread {
	
	private int m_int;
	
	public HelloWorldThread(int inInt) {
		super();
		this.m_int = inInt;
	}
	
	
	synchronized public void dumpInfo() {
		for(m_int=0;m_int<10;m_int++) {
			int t = (int) (Math.random() * 1000);
			
			try {
				Thread.sleep(t);
				System.out.println(this.isAlive() + " :" +Thread.currentThread().getId() + " " + Thread.currentThread().getName());
				
			}catch(Exception exp) {
				exp.printStackTrace();
			}
			
		}
		
	}
	public void dumpInfo2() {
		
		
		for(m_int=0;m_int<10;m_int++) {
			int t = (int) (Math.random() * 1000);
			
			try {
				Thread.sleep(t);
				
				synchronized (this) { // Á£¶È¸üÏ¸
					System.out.println(this.isAlive() + " :" +Thread.currentThread().getId() + " " + Thread.currentThread().getName());
				}
				
			}catch(Exception exp) {
				exp.printStackTrace();
			}
			
		}
		
	}
	
	@Override
	public void run() {

		dumpInfo();
		//super.run();
	}

}
