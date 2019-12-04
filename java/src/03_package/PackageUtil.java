/**
 * 如果增加了此处
 *  package learning.package1;
 * 那么，编译时
 *  cd $java_file_path
 *  java -d $lang_howto/class/ -encoding utf-8 PackageLearning.java
 * 在使用者程序中，使用如下指令引入
 *  import learning.util.PackageUtil;
 */
package learning.util; // 包的定义


/**
 * public 关键字表示此类可以被其他包使用，否则只能在自己的包内使用
 */
public class PackageUtil{
    public void PrintAll(final String args[]){
        for(int i=0;i<args.length;i++)
            System.out.println(args[i]);
    }
}
