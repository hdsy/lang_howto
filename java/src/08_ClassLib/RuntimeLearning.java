/** Runtime 运行时的操作类的对象，单例
 *      public static Runtime getRuntime()  获取Runtime类的实例化对象
 *      public long maxMemory()     获取最大可用内存大小
 *      public long totalMemory()   获取所有可用内存大小
 *      public long freeMemory()    获取所有空闲内存大小
 *      public void gc()            执行垃圾回收操作
 *      public Process exec(String cmd) throws Exception    创建新的进程
 * 
 * java运行程序是可通过参数指定初始、最大、年轻代数据
 *      -Xms    初始内存，默认大小为1/64的物理内存大小，小于1G
 *      -Xmx    最大内存，默认大小为1/4的物理内存大小，小于1G
 *      -Xmn    年轻代堆内存
 * 
 *  lg ：  java -Xmx5M RuntimeLearning
 */
public class RuntimeLearning{
    public static void main(String args[]) throws Exception{
        System.out.println("RuntimeLearning::main :");

        Runtime rt = Runtime.getRuntime();
        System.out.println("+----------------------------------------------------------------------- -+");
        System.out.println("|" + rt.maxMemory() + "\t" + rt.totalMemory() + "\t" + rt.freeMemory() + "|");
        rt.gc();
        System.out.println("|" + rt.maxMemory() + "\t" + rt.totalMemory() + "\t" + rt.freeMemory() + "|");
        System.out.println("+----------------------------------------------------------------------- -+");
        
        /** new 触发的内存分配流程
         * 
         * 1. Eden ->
         *      1.1 回收不活跃对象 Minior GC
         *      1.2 Eden -> 
         *          1.2.1 survivor 空间充足 -> 将eden部分活跃对象保存到这里
         *              1.2.1.1 Tenured空间充足 -> 将survivor部分活跃对象保存到这里 -> 
         *              1.2.1.1 Full GC
         * 
         * 
         */

         Process objProcess = rt.exec("notepad");

        Thread.sleep(2000);

         objProcess.destroy();

    }
}