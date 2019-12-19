/** System 
 *  数组复制操作    public static void arraycopy(Object src,int srcpos,Object desPos,int len)
 *  取系统的日期    public static long currentTimeMillis()
 *  垃圾收集启动    public static void gc()   <=>  Runtime.getRuntime().gc()
 * 
 */
public class SystemLearning{
    public static void main(String args[]) throws Exception{
        System.out.println("SystemLearning::main :");

        long start = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer("abc");

        for (int i =0 ;i<100;i++){
            sb.append(i);

        }

        long end = System.currentTimeMillis();

        System.out.println("time exhaused : " + start + "," + end + "," + (end-start));

        {
            TimeCounter objTimeCounter = new TimeCounter();

            Thread.sleep(1000);

            /**
             * 如果没有置成null，没有做回收，finalize不会执行
             */
            //objTimeCounter = null;

            //System.gc();
        }
        /**
         * 这里也不会触发objTimeCounter的finalize
         */
        System.gc();


        // clone
        Book bk1 = new Book("java",123.2);
        Book bk2 = bk1;
        Book bk3 = (Book)bk1.clone();


        bk2.setTitle("java 2.0");

        bk3.setTitle("java 3.0");

        System.out.println("bk1 : " + bk1.toString());
        System.out.println("bk2 : " + bk2.toString());
        System.out.println("bk3 : " + bk3.toString());
    }
}

class TimeCounter{
    long start;
    long end;

    public TimeCounter(){
        start = System.currentTimeMillis();
        end = start;
    }

    /**
     *  final       表示终结器，用于定义不能被继承的父类，不能被覆写的方法与常量
     *  finally     异常处理的入口
     *  finalize    是Object的方法，用于执行对象回收前的收尾操作
     */

    @Override
    protected void finalize() throws Throwable{
        end = System.currentTimeMillis();
        
        System.out.println("time exhaused : "+getInterval());
    }

    public long getInterval (){
        return end-start;
    }

}

/** CLone
 * java 默认都是引用，对类的对象。 如果需要复制，则需要使用Object的clone方法
 * 
 * 支持clone的类必须实现CLoneable
 */

 class Book implements Cloneable{
     private String title;
     private double price;

     public Book(String t,double p){
        this.title =t ;
        this.price = p;
     }

     public void setTitle(String t){
         this.title =t;
     }
     @Override
     public String toString(){
         return "title:"+title+",price:"+price;

     }

     @Override
     public Object clone() throws CloneNotSupportedException{
         return super.clone();
     }
 }