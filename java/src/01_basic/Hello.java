// java的注释分为单行
/*
    多行
    ...

    ...
*/
/**
 * 文档注释
 * 同于多行，但是这里的内容会纳入javadoc生成的文档里面。这类注释是需要面向使用者的。
 * 
 * 
 * 
 * ...
 * 
 */

/**
 * 下载jdk-8u231-windows-x64.exe，双击安装之后，在命令行使用java -version 与javac -version确认安装成功
 */
public class Hello{
    public static void main(final String args[]){
        /**
         * System.out.print 不换行
         * System.out.println 换行
         */
        System.out.println("Hello world,Java 1.2!");

        final Demo_print A = new Demo_print();

        A.A();
        A.A();
        A.A();

        final Demo_println AA = new Demo_println();

        AA.A();
        AA.A();

        final 高勇 bb = new 高勇();
        bb.A();
    }
}

/**
 * cmd窗口执行命令
    javac Hello.java
    java Hello
    即可看到输出相关字符串
 */


 /**
  * javac 有默认机制，对于public class定义的：
        1、要求文件名与类名保持一致，使用扩展名.java
        2、每个.java文件只能有一个类，也只生成一个.class文件，与类名相同

        对于class定义的：
        1、类名称可以与文件名不一致
        2、每个.java文件可存在多个class定义，但是编译生成多个.class文件，与class定义名相同

        程序入口：
        main函数要求放到类中，是执行的开始。 public static void main

  */
class Demo_print{
    public void A(){
        System.out.print("A");
    }

}

class Demo_println{
public void A(){
    System.out.println("A");
}

}

  /**
   * java Hello执行的Hello.class文件必须在当前目录
   * 否则就要设定CLASSPATH
   * set CLASSPATH=f:\git\github\lang_howto\java\src
   * java Hello
   * 
   * 原理在于，执行java命令启动JVM时，默认将CLASSPATH指向当前目录，如果不在当前目录则需要设定此变量到合适的路径去
   * 
   * 如果编译时出现编码错误，可按照文件编码对javac命令指定编码格式 如 
   * javac  -encoding utf-8 Hello.java
   */


class IDandKey{
    // 标志符不能与关键字重合，由字母、下划线领头的包括数字在内的字符串
    /**
    * java的关键字好多
        abstract
        assert        jdk 1.4 +
        boolean
        break
        byte
        case
        catch
        char
        class
        continue
        const         java实际没有使用到此关键字
        default
        do
        double
        else
        extends
        enum          jdk 1.5 +
        final
        finally
        float
        for
        goto           java实际没有使用到此关键字
        if
        implements
        import
        instanceof
        int 
        interface
        long
        native
        new
        package
        private
        protected
        public
        return
        short
        static
        synchronized
        super
        strictfp
        this
        throw
        throws
        transient
        try
        void
        volatile
        while

        true，false，null 是java重特殊含义的标志符，并未纳入关键字的部分

    */

    public void DumpInfo(){
        System.out.print("test");
    }

}

/**
* java可支持标记符未中文，在JDK1.7之后

    如果把关键字也都中文化，估计我们就可以看到汉字编程了，倒是可以考虑下 ：）
*/
class 高勇{
    public void A(){
        final int 高勇女儿 = 3;
        System.out.println(高勇女儿);
    }
}



