/**
 * 如果增加了此处
 *  package learning.package1;
 * 那么，编译时
 *  cd $java_file_path
 *  java -d $lang_howto/class/ -encoding utf-8 PackageLearning.java
 * 在使用者程序中，使用如下指令引入
 *  import learning.util.PackageUtil;
 */
package learning.util_02; // 包的定义



public class PackageUtil_02{
    public void PrintAll(final String args[]){
        for(int i=0;i<args.length;i++)
            System.out.println("util02:"+args[i]);
    }
}
