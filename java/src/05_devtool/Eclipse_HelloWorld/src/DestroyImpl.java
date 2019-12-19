/**
 * 自动执行close函数
 * try (DestroyImpl objDestroyImpl = new DestroyImpl()){			
			objDestroyImpl.toString();
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
 * @author Administrator
 *
 */
public class DestroyImpl implements AutoCloseable {

	private long start = 0;
	private long end = 0;
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"Destroy fin. @" + end + " exhaust time : " + (end- start));
		
		
		
	}
	
	DestroyImpl(){
		start = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+"Constructor init. @" + start);
	}

}
