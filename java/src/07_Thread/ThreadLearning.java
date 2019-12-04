import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**  005 线程的状态与操作方法
 *      状态 ： 就绪，运行，堵塞，终止
 * 
 *  线程的命名 Thread
 *      构造函数 public Thread(Runnable target,String name);
 *      设置名字 public final void setName(String name);
 *      获取名字 public final String getName();
 */

public class ThreadLearning{

    public static void main(String args[]){

        // ----------------------------------------------------------
        MyThread objThread1 = new MyThread("AAAAAAAAAA");
        MyThread objThread2 = new MyThread("BBBBBBBBBB");
        MyThread objThread3 = new MyThread("CCCCCCCCCC");

        /** 007 设置优先级 
         * public static final int MAX_PRIORITY; // NORM_PRIORITY // MIN_PRIORITY
         * public final void setPriority(int newPriority);
         * public final void getPriority();
        */
        objThread1.setPriority(Thread.MIN_PRIORITY);
        objThread2.setPriority(Thread.MAX_PRIORITY);
        objThread3.setPriority(Thread.NORM_PRIORITY);

        // 多次调用start，会抛出异常         IllegalThreadStateException
        try{
                
            objThread1.start();
            objThread1.start();// 将抛出异常IllegalThreadStateException
            objThread2.start();
            objThread3.start();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }//*/

        // -------------------------------------------------------------
        MyRunnable objMyRunnable1 = new MyRunnable("R1");
        MyRunnable objMyRunnable2 = new MyRunnable("R2");
        MyRunnable objMyRunnable3 = new MyRunnable("R3");
        

        new Thread(objMyRunnable1,"r1").start();
        new Thread(objMyRunnable2,"r2").start();
        new Thread(objMyRunnable3,"r3").start();

        // -------------------------------------------------------------
        new Thread(
            
                ()->{
                    for(int x = 0; x < 20; x++){
                        System.out.println(Thread.currentThread().getName()+ " : TEST LAMBDA" + " " + x);
                        
                    }
                }

        ).start();

        // ------------------------------------------------------------
        MyCallable objMyCallable1 = new MyCallable();

        FutureTask<String > task1 = new FutureTask<String>(objMyCallable1);
        FutureTask<String > task2 = new FutureTask<String>(objMyCallable1);
        FutureTask<String > task3 = new FutureTask<String>(objMyCallable1);
        FutureTask<String > task4 = new FutureTask<String>(objMyCallable1);
        FutureTask<String > task5 = new FutureTask<String>(objMyCallable1);

        new Thread(task1,"task1").start();
        new Thread(task2,"task2").start();
        new Thread(task3,"task3").start();
        new Thread(task4,"task4").start();
        new Thread(task5,"task5").start();

        try{
            System.out.println(task1.get());
        }catch(Exception exp){
            exp.printStackTrace();
        }

        //Thread objCurThread  =  Thread.currentThread();

        System.out.println("Main Thread : " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority()
            + "/" + Thread.MIN_PRIORITY
            + "/" + Thread.NORM_PRIORITY
            + "/" + Thread.MAX_PRIORITY    
        );

    }   

}

/** 001 Thread类继承
 * 
 */
class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name = name;
        // 设置线程名
        super.setName(name);
    }

    @Override
    public void run() {
        for(int x = 0; x < 2; x++){
            System.out.println(Thread.currentThread().getName()+ " : "+this.name + " " + x);
            try {
                Thread.sleep(100);
            }
            catch (Exception exp){
                exp.printStackTrace();
            }
        }
    }
}

/** 002 实现Runnable接口
 * 相对于Thread，可规避单继承问题
 * 
 */
/*
@FunctionalInterface
public interface Runnable{
    public void run();
}//*/
class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name = name;

    }
    @Override
    public void run() {
        for(int x = 0; x < 2; x++){
            System.out.println(Thread.currentThread().getName()+ " : "+this.name + " " + x);
            try{
                /** 006 睡眠 */
                Thread.sleep(100);
            }catch(Exception exp){
                exp.printStackTrace();
            }
            
        }
    }
}
/** 003 Runnable是一个函数式接口，因此可用lambda表达式创建线程
 *  ()->{
        for(int x = 0; x < 200; x++){
            System.out.println(this.name + " " + x);
            
        }
 * 
 * Runnable
 *  -> Thread
 */

 /** 004 利用Callable接口实现多线程
  * 
  * 主要是为了解决Runnable不能返回操作结果的问题   JDK1.5+

  * Thread 不能接受返回值，所以需要新的类来容纳此返回值
        Runnable
        Future
            RunnableFuture
                FutureTask
                    + public FutureTask(Callable<V> callable)
                    + public FutureTask(Runnable runnable,V result)
                    + public V get() throws Interrupted Exception,Execution Exception


  */
  /*
@FunctionalInterface
public interface Callable<V>{
    public V call() throws Exception;
}
//*/

 class MyCallable implements Callable<String>{
     private int ticket = 10;

     @Override
     public String call() throws Exception{
        for(int x = 0; x < 100; x++){
            

            Thread.sleep(10);
            /** 009 同步操作
             *  synchronized 可以确保代码块在同一时间段内，只有一个在运行
             *  可以用来定义函数，或者代码块
             *      synchronized (obj){code block;}
             *  修饰函数
             *      public synchronized void func(){}
             * 
             * 同步要考虑死锁的情况
             */
            synchronized(this){
                if(this.ticket > 0){
                    System.out.println(Thread.currentThread().getName()+ " : Sale ticket :" + this.ticket--);
                }
                else{
                    break;
                }
            }

            sale();
        }
        return "no ticket";
     }

     public synchronized void sale(){
        if(this.ticket > 0){
            System.out.println(Thread.currentThread().getName()+ " : Sale ticket :" + this.ticket--);
        }
     }

 }

 /** 010 进程的等待与唤醒
  *
  * Object      
        -> THread

    Object 的方法 
        wait() 等待； 必须等待notify或notifyALl唤醒
        notify()唤醒第一个等待的线程； notifyAll唤醒全部等待的线程；

    Thread 的方法sleep表示线程休眠，将执行机会给打其他线程，但是监控状态继续，会自动恢复。


    Thread还有一些过期的方法：
        suspend 暂时挂起线程
        resume  恢复挂起线程
        stop    停止线程

  */
