/**
 * GC 的工作与内存的分配密切相关。
 *  1. 引用计数 ： 计算对象的引用计数
 *  2. 跟踪收集 ： 遍历对象的引用路径
 *  3. 分代收集 ： 
 *      3.1 分代增量收集
 *           新生代 ： eden survivor1 survivor2
 *           年老代 ： 
 *           持久区 ： 存放类信息，如果满了会报OutOFMemory
 *      3.2 累计增量收集
 */

public class ObjectLearning{
    /**
     * 具有public类和main函数的地方，构造函数不会执行
     */
    ObjectLearning(){
        System.out.println("ObjectLearning generator code block. ");
    }
    /**
     * 在main函数前执行
     */
    static {
        System.out.println("ObjectLearning static code block .");
    }
    public static void main(final String arg[]) {

        final Book bk = new Book();

        bk.price = 18.8;
        bk.title = "Java 第一行代码";

        bk.getInfo();

        final Book bk1 = new Book("Java多线程编程核心技术", 123.0, "1234");
        bk1.getInfo();

        // 匿名对象
        new Book().getInfo();

        ArrayDemo();


        // String
        final StringLearning sl = new StringLearning();
        sl.ContStrTest();

        // Static
        StaticLearning objStaticLearning = new StaticLearning();
        StaticLearning.DumpStaticVal();
        for(int i=0;i<1;i++)
        { // {}内部的属于局部变量
            
             StaticLearning objStaticLearning1 = new StaticLearning();

            objStaticLearning1.DumpVal();
        }
        objStaticLearning.DumpStaticVal();

        // 内部类的实例化
        outer.inner outer_inner = new outer().new inner();
        outer_inner.DumpInfo();
        outer.static_inner o_i_static = new outer.static_inner();
        o_i_static.DumpInfo();

    }

    private static void DumpInfo(final int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    private static void DumpInfo(final int arr[][]) {

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            DumpInfo(arr[i]);
        }
    }

    private static void ArrayDemo() {
        // 创建一个长度为3的整形数组，arrInt在栈，具体数据在堆；数据引用下标从0开始
        final int arrInt[] = new int[3];
        arrInt[0] = 100;
        arrInt[1] = 200;
        arrInt[2] = 300;

        System.out.println("arrInt :");
        for (int i = 0; i < 3; i++) {
            System.out.print(arrInt[i] + "\t");
        }

        // 数组引用
        final int arrTemp[] = arrInt;

        arrTemp[2] += 100;

        System.out.println("\narrInt :");
        for (int i = 0; i < 3; i++) {
            System.out.print(arrInt[i] + "\t");
        }
        // 赋值初始化简化形式
        final int arrInt2[] = { 1, 2, 3 };
        // 赋值初始化完整形式
        final int arrInt3[] = new int[] { 1, 2, 3, 4 };

        DumpInfo(arrInt2);
        DumpInfo(arrInt3);

        final int arrArrInt[][] = new int[2][3];
        final int arrArrInt2[][] = new int[][] { { 1, 2, 3 }, { 10, 20, 30 } };
        DumpInfo(arrArrInt);
        DumpInfo(arrArrInt2);

        /**
         * 数组的常用操作 System.arraycopy java.util.Arrays.sort
         * 
         */
        DumpInfo(arrInt2);
        System.arraycopy(arrInt, 0, arrInt2, 0, 1);
        DumpInfo(arrInt2);
        java.util.Arrays.sort(arrInt2);
        DumpInfo(arrInt2);

        /**
         * 数组对象 class object[] = new class[3]; class object[] = new class[]{new
         * class(),new class(),...}
         */

        final Book bk[] = new Book[] { new Book(), new Book("a", 1.2, "abc") };
        bk[0].getInfo();
        bk[1].getInfo();

        final StringLearning objStringLearning = new StringLearning();
        objStringLearning.Test();

    }
}

/**
 * 堆内存，栈内存
 * 
 * 栈内存存放变量，堆内存存放具体数据； 栈->堆
 * 
 * Book bk = new Book(); bk 栈 new 堆
 * 
 * Book bk1 = null; bk1 空指针，不能够用来赋值，所以此时bk1.title = "abd";
 * 将抛出java.lang.NullPointerException
 * 
 * bk1 = bk ;则是让bk1 与 bk 指向同一片数据
 * 
 * Book bk2 = new Book(); 如此bk2,bk分别指向不同的数据
 * 
 * bk2 = bk; 则将bk2指向了bk；bk2的数据区就成为了“垃圾”
 */
class Book {
    String title;
    double price;

    /**
     * 构造方法 ： 默认都有一个，什么事情不做，无参数无输出，名字与类名一致
     */
    public Book() {
    }

    /**
     * new 时可触发调用之
     * 
     * @param t
     * @param p
     * @param i
     */
    public Book(final String t, final double p, final String i) {
        title = t;
        price = p;
        isbn = i;
    }

    /**
     * 封装 : 让外部不能染指
     */
    private String isbn;

    /**
     * 以此控制val的范围，避免isbn被赋予不合适的值
     * 
     * @param val
     */
    public void setIsbn(final String val) {
        isbn = val;
    }

    public String getIsbn() {
        return isbn;
    }

    public void getInfo() {
        System.out.println("图书名称：" + title + "，价格：" + price + ",ISBN:" + isbn);
    }
}

/**
 * 简单java类的定义： 1. 类名称 ：有含义 2. 属性必须private定义，并提供setter，getter方法 3.
 * 可存在多个构造函数，但是必须保留无参数构造函数 4. 无输出语句 5. 有统一的完整信息获取方法，例如getInfo
 */

class StringLearning {
    String title;
    double price;

    public StringLearning() {
        price = 0.0;
    }

    public StringLearning(String title, double price) {
        // 调用本类的构造函数（无参数）
        this(); // 只能放在构造函数的第一行

        // 下列代表的都是函数入参，并未起到赋值给类属性的作用
        title = title;
        price = price;

        // 正确的做法如下
        this.price = price;
        this.title = title;

        // 调用本类的方法
        this.Test();

    }

    void Test() {
        final String str = new String("Maven 实战");
        final String str1 = "Maven  shizhan";

        // 字符串比较
        System.out.println(str == str1);
        System.out.println(str.equals(str1));

        // 字符串的常量，就是String的匿名对象
        System.out.println("abc".equals(str1));

        // this代表当前对象
        System.out.println("this = " + this);

    }

    /**
     * 字符串一旦定义就不能修改,会不停的在内存中创建
     */
    void ContStrTest() {
        final String s1 = "Hello";
        final String s2 = "Hello";
        System.out.println(s1 + " " + s2);

        final char arrc[] = s2.toCharArray();
        arrc[0] = 'h';

        System.out.println(s1 + " " + s2);
        System.out.println(new String(arrc));

        s2.replaceAll("l", "L");

        System.out.println(s2.replaceAll("l", "L") + " " +s1 + " " + s2);
    }
}

/**
 * java 函数中用参数用类时，传递的是引用，这个与C++有不同，他是默认的，使用中要特别注意
 * 
 * static 定义的属性，在类中保持唯一。即是说这个类定义出来的所有实例都只有这一个属性。
 * static 定义的属性，可以不用实例化，直接用类名引用
 */
class StaticLearning{
    private static int count =0;
    private static String pub = "abcd";
    public static String pri = "efgh";

    private String pri_sim;
    public String pub_sim;

    StaticLearning(){
        count++;
    }
    
    { //构造块： 优先于构造函数运行
        
        DumpVal();
    }
    /**
     * 静态代码块，只执行一次
     */
    static {
        System.out.println("**********************static code block");
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        count--;

        DumpVal();
    }

    public static void DumpStaticVal()
    {
        System.out.println("pub= "+pub + "; pri=" + pri);
    }

    public void DumpVal()
    {
        pri_sim = "sim efgh";
        pub_sim = "sim abcd";
        System.out.println("c:"+count+";pub_sim= "+pub_sim + "; pri_sim=" + pri_sim);
        System.out.println("pub= "+pub + "; pri=" + pri);
    }
}

/**
 * 内部类，
 * 
 */
class outer{
    static private int outer_pri_s_val = 100;
    private int outer_pri_val;

    public void DumpInfo(){

        inner objInner = new inner();

        // 外部类可以访问内部类对象的私有变量
        outer_pri_val = objInner.inner_pri_val;

        /**
         * 函数内可以定义类，并可以使用函数内定义的变量与参数（1.8前都需要用final说明，1.8后后面考虑到Lambda的表达式，取消了）
         */
    }

    static class static_inner{
        public void DumpInfo(){
            // 如下是ok的
            System.out.println(outer.outer_pri_s_val);
            
            // System.out.println(outer.this.outer_pri_val);  // 运行时会报错，因为不能引用到outer的实例
        }
    }

    class inner{
        private int inner_pri_val;

        public void DumpInfo(){
            // 内部类可以访问外部内的私有变量
            inner_pri_val = outer_pri_val;
            // 推荐如下编写方式：  这样可以保障解决重名的问题
            inner_pri_val = outer.this.outer_pri_val;
        }
    }
}


class Node {
    private String data;
    private String name;
    private Node next;

    public Node(String name,String data){
        this.data = data;
        this.name = name;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public void DumpInfo(){
        System.out.println(name + ","+data);
    }

}