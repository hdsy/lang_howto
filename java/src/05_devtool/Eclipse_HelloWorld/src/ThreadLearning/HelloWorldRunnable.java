package ThreadLearning;

public class HelloWorldRunnable implements Runnable {
	
	private int m_int;
	
	synchronized public void dumpInfo() {
		for(m_int=0;m_int<10;m_int++) {
			int t = (int) (Math.random() * 100);
			
			try {
				Thread.sleep(t);
				System.out.println(m_int + " :" +Thread.currentThread().getId() + " " + Thread.currentThread().getName());
				
			}catch(Exception exp) {
				exp.printStackTrace();
			}
			
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dumpInfo();
	}

}
