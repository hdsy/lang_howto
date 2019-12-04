/**
 * 如果增加了此处
 *  package learning.package1;
 * 那么，编译时
 *  cd $java_file_path
 *  java -d $lang_howto/class/ PackageLearning.java
 * 执行时
 *  cd $lang_howto
 *  javac learning.package1.PackageLearning
 */
package learning.package1; // 包的定义


// 在设定好class的路径下增加此路径
/**
 * 如果引入的包中含有重名的类，则需要使用包名指定，避免冲突。
 */
import learning.util.PackageUtil;
import learning.util_01.PackageUtil_01;
import learning.util_02.PackageUtil_02;

public class PackageLearning{
    public static void main(final String args[]){
        System.out.println("Hello PackageLearning .");

        /**
         * 例如：cd $lang_howto/java/class
         * 
         * 第一种方法：确保依赖顺序，逐个编译
         * javac -d . -encoding utf-8 $lang_howto/src/package1/PackageUtil.java
         * javac -d . -encoding utf-8 $lang_howto/src/package1/PackageLearning.java
         * 
         * 第二种方法：交给javac自己判断依赖顺序
         * javac -d . -encoding utf-8 $lang_howto/src/package1/*.java
         * 
         * 最后执行即可：
         * java learning.package1.PackageLearning
         * 
         */


        PackageUtil objPackageUtil = new PackageUtil();

        objPackageUtil.PrintAll(args);

        
        PackageUtil_02 objPackageUtil_02 = new PackageUtil_02();

        objPackageUtil_02.PrintAll(args);

        
        PackageUtil_01 objPackageUtil_01 = new PackageUtil_01();

        objPackageUtil_01.PrintAll(args);
    }
}


/**
 * 常用的包
 *  java.lang 基础的包，类似String这样的类都是保存于此包中，1.0以上都自动引入此包，不必显式指定
 *  java.lang,reflect 反射机制的包，是java.lang的子包
 *  java.util 工具包，常用的类库，例如日期
 *  java.text 文本处理的类库
 *  java.sql 数据库操作包
 *  java.net 网络相关
 *  java.io 输出输出相关
 *  java.awt GUI相关的包
 *  java.swing 图形界面，更轻
 *  java.applet 小应用程序，已经过时
 */


/** jar 生成自己的包
 *  jar cvf learning.jar learning
 * 
 *  使用时  
 * 
 *  set CLASSPATH=.;$jar_file_path
 * 
 *  实例
 * 
 * # set CLASSPATH=.;F:\git\github\lang_howto\java\class\learning.jar;
 * #java learning.package1.PackageLearning aaa bbb ccc
        Hello PackageLearning .
        aaa
        bbb
        ccc
        util02:aaa
        util02:bbb
        util02:ccc
        util_01 : aaa
        util_01 : bbb
        util_01 : ccc
*/

/**
 * 访问权限的定义
 * 
 * 序号     范围        private     default     protected       public
 * 1        同包同类    ok          ok          ok              ok
 * 2        同包异类                ok          ok              ok
 * 3        异包子类                            ok              ok
 * 4        异包主类                                            ok
 * 
 * protected 定义的属性只能被子类使用，ok的情况下
 */


 /**
  * 单例模式
  */
  class Singleton{
    
      /** 02 不能外部创建，
       *    就要考虑内部创建 ： 
       *        并可以对外部访问，所有要用static
       *    另外考虑到所有属性应该被封装起来，所以要加private
       *        如何对外暴露这个实例，要定义专门的方法
       * 
       *    因为这个其实是一个常量，不会再重新定义，所有可以考虑加上final
       * 
       *    以此延伸，可以做多组实例，用来分类，例如性别、周、月、颜色等
       * 
       */
      private final static Singleton instance = new Singleton(); 

      /**
       * 这个就是可被外部访问的获取实例的方法
       */
      public static Singleton getInstance(){
          return instance;
      }
      
    /**  01  
     * 单例不能被外部创建实例，因此将构造函数私有化 */  
        private Singleton(){

        }
  }
  