Eclipse、IDEA
    流行的java开发工具

JDT
    Eclipse中直接使用JDT即可完成java程序的开发，JDT协助生成和管理代码

    【file】-【new】-【java project】

    协助我们自动生成setter getter
    【Source 】 -【Generate Constructor using Fields】

    协助配置调试与编译环境
    【Run As 】-【Run Configure】 -【Argument】

    快捷键如下：
        Alt  + /    代码提示
        Ctrl + 1    为错误代码给出纠正方案
        Ctrl + SHift + O    组织导入，导入其他包的类
        Ctrl + /    单行注释
        Ctrl + H    强烈搜索
        Ctrl + ALt + 下箭头 复制当前行代码
        Ctrl + SHift + L 列出全部快捷键列表

    
JUnit
    测试框架 junit.framework.TestCase

    public class MyMathTest{
        @Test
        public void testDiv(){
            ...
            TestCase.assetEqual(MyMath.div(10,2),5);
            ...
        }
    }

        判断是否为空 ： assertNull  assertNotNull
        是否为true  ：  assetTrue assertNotFalse
        是否相等    ：  assetEqual

    