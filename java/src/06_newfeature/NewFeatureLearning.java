
/**
 * 内建函数式接口,这里比较怪异，用*代替时，总不能通过
 */
/*
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;
//*/
import java.util.function.*;
/** 003 静态导入 import static package.class.*
 * 如果冲突了，就要执行全路径
 */
import static  staticimport.learning.ImportLearning.*;


/**
 * 一般形态的package导入
 */
import staticimport.learning.*;
import staticimport.learning.ImportLearning;


public class NewFeatureLearning{
    public static void main(final String args[]) {

        System.out.println("NewFeatureLearning : " + add(new int[] { 1, 2, 3 }) + "\n" + addVariant(1, 2, 3) + "\n"
                + addVariant2(1, 2, 3)
                // +"\n" + ImportLearning.add(2,3,4) // 找不到类
                + "\n" + ImportLearning.sub(2, 3, 4) // 对应 import staticimport.learning.ImportLearning;
                + "\n" + staticimport.learning.ImportLearning.add(2, 3, 4)
                // +"\n" + add(2,3,4) // 冲突了
                + "\n" + staticimport.learning.ImportLearning.sub(2, 3, 4) + "\n" + sub(2, 3, 4) // 对应 import static
                                                                                                 // staticimport.learning.ImportLearning.*;
        );

        final Point<Integer> objPoint = new Point<Integer>();
        objPoint.setPoint(3, 4);
        System.out.println("(" + objPoint.getX() + "," + objPoint.getY() + ")");

        final Point<Double> objPoint1 = new Point<Double>();
        objPoint1.setPoint(1 / 3.0, 4.0);
        System.out.println("(" + objPoint1.getX() + "," + objPoint1.getY() + ")");

        DumpInfo(objPoint);
        DumpInfo(objPoint1);

        final MyColor mc = MyColor.RED;
        System.out.println("Enum val's name is " + mc.name());
        System.out.println("Enum val's index is " + mc.ordinal());

        for (final MyColor item : MyColor.values()) {
            System.out.println("[" + item.name() + "：" + item.ordinal() + " " + item + " ]");
        }

        final AnnotationTestChild objAC = new AnnotationTestChild();

        objAC.DumpInfo();

        final IMessage objMessage = new MessageImpl();

        objMessage.fun();
        objMessage.print();

        IMessage.get();

        // Lambda
        LambdaTestInstance.main();

        // Function Reference
        IFunctionRefTest.DumpInfo();

        // Function inline
        final Function<String, Boolean> fun = "abcd"::startsWith;

        System.out.println(fun.apply("cd"));
        System.out.println(fun.apply("ab"));

        final Consumer<String> cons = System.out::print;
        cons.accept("Hello aa");

        final Supplier<String> sup = "gauss"::toUpperCase;
        System.out.println(sup.get());

        final Predicate<String> pre = "gauss"::equalsIgnoreCase;
        System.out.println(pre.test("GAUSS"));
        System.out.println(pre.test("GAUsS"));


    }

    /**
     * 004 通配符 <?> 可用来获取值，但是不能设定值
     * 
     * <? extends classname > 设置泛型上限制，可以在声明和方法参数上使用 例如 ? extends NUmber
     * 可以设置NUmber或者Number的之类 <? super classname > 设置泛型下限， 例如 ? super String
     * 意味着只能设置String 或者他的父类Object
     * 
     * @param pt
     */
    public static void DumpInfo(final Point<?> pt) {
        System.out.println("(" + pt.getX() + "," + pt.getY() + ")");
    }

    /**
     * 001 可变参数 可变参数本质是一个数组，因此并不能如C++一样实现真正的多类型可变参数
     */
    public static int add(final int[] data) {
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        return sum;
    }

    /**
     * 功能等同于add , 使用方式上可以 func(1,2,3,4,...)
     * 
     * @param data
     * @return
     */
    public static int addVariant(final int... data) {
        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        return sum;
    }

    public static int addVariant2(final int... data) {
        int sum = 0;
        /**
         * 002 for类似foreach 在其他语言 for循环的增强型 数据类型 变量：数组| 集合
         */
        for (final int item : data) {
            sum += item;
        }

        return sum;
    }

}

/**
 * 004 泛型 只能为object的子类，如int double不行，Integer，Double可
 */
class Point<T> {
    private T x;
    private T y;

    public void setX(final T x) {
        this.x = x;
    }

    public void setY(final T y) {
        this.y = y;
    }

    public void setPoint(final T x, final T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }
}

/**
 * 005 枚举 enum switch (val) 中val的类型 JDK1.4 int char JDK1.5 + enum JDK1.7 +
 * String
 * 
 * 
 */
enum MyColor {
    // 枚举对象必须放在首行
    RED("red"), GREEN("gree"), BLUE("blue");

    // 可以有自己的属性
    private String title;

    // 可以有构造方法，但是不能为public
    private MyColor(final String title) {
        this.title = title;
    }

    // 可以有其他方法
    public String toString() {
        return this.title;
    }

}

/**
 * 006 Annotation ? 用来回避对象中方法覆盖时，名称固定的问题，减少拼写问题造成的歧义
 * 
 */
class AnnotationTest {
    /**
     * override 会检查方法是否是父类有的，确认是覆盖的写法，否则编译会错
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Hello Annotation!";
    }

    /**
     * 定义此方法为过期，如果被使用会告警
     * 
     * @return
     */
    @Deprecated
    public String toUpper() {
        return "Hello Annotation!".toUpperCase();
    }
}

class AnnotationTestChild extends AnnotationTest {
    @Override
    public String toString() {
        return "Hello Annotation Child.";
    }

    /**
     * 使用了父类过期方法，编译会告警
     */
    @Override
    public String toUpper() {
        return "Hello Annotation Child!".toUpperCase();
    }

    /**
     * 如果不增加注解，则会告警
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public void DumpInfo() {
        final Point pt = new Point();

        pt.setX("3.0abcd");

        System.out.println(pt.getX());
    }

}

/**
 * 007 接口定义强化 JDK 1.8 之后，可以在接口中定义普通方法与静态方法
 */

interface IMessage {
    public void print();

    default void fun() {
        System.out.println("func : yootk.com");
    }

    static void get() {

        System.out.println("get : yootk.com");
    }
}

interface IChart {
    public void Chart();
}

interface IMessageChild extends IMessage, IChart {
    public void a();
}

class MessageImpl implements IMessage {
    @Override
    public void print() {

        System.out.println("print : yootk.com \n 20191203");
    }
}

/**
 * 008 Lambda表达式 JDK1.8 以上版本
 * 
 * 简化接口仅有单一抽象方法的定义，以及匿名内部类定义
 * 
 * 为了标注出Lambda接口与其他接口的差异，可以增加注解:
 * 
 * @FunctionalInterface
 * 
 */
interface ILambdaTest2 {
    public void DumpInfo(int a, int b);
}

@FunctionalInterface
interface ILambdaTest {
    public void DumpInfo();

    /** 可以定义普通方法与静态方法 */

    default void fun() {
        System.out.println("func : yootk.com");
    }

    static void get() {

        System.out.println("get : yootk.com");
    }
}

class LambdaTestInstance {
    public static  void main(){
        // ----------------------------------------------------------------------
        // lambda 表达式
        func(()->System.out.println("........LambdaTestInstance......1"));
        // <==> 等价于
        // ----------------------------------------------------------------------
        func(
            new ILambdaTest(){
                @Override
                public void DumpInfo(){
                    System.out.println("........LambdaTestInstance......2");
                }
            }
        );
        // ----------------------------------------------------------------------
        // <==> 等价于
        func(
            ()->{
                System.out.println("........LambdaTestInstance......20");
                System.out.println("........LambdaTestInstance......21");
                System.out.println("........LambdaTestInstance......22");
            }
        );
        // ----------------------------------------------------------------------
        func(
            new ILambdaTest2(){
                @Override
                public void DumpInfo(final int a, final int b){
                    System.out.println("........LambdaTestInstance......2 " + " " + (a+b));
                }
            }
        );
        func(
            (a,b)->{
                    System.out.println("........LambdaTestInstance......2 " + " " + (a+b));
            }
                
            
        );

    }

    public static void func(final ILambdaTest obj) {
        obj.DumpInfo();
    }

    public static void func(final ILambdaTest2 obj ){
        obj.DumpInfo(10,30);
    }
}
/** 009 方法引用
 * 
 * JDK1.8 + 变量可引用，方法也可引用
 * 
 * 1. 引用静态方法  ：  ClassName::Function Of Static   |   String::valueOF
 * 2. 引用对象方法  ：  Object :: Function              |   "string instance"::toUpperCase
 * 3. 特定类的方法  ：  特定类 :: 普通方法                |    String::compareTO
 * 4. 引用构造方法  ：  类名称 :: new                    |    String::new    
 */
@FunctionalInterface
interface IFunctionRef<P,R>{
    public R Function2Test(P objP);
}

class IFunctionRefTest{
    public static void DumpInfo(){
        IFunctionRef<Integer,String> msg = String::valueOf;

        String str = msg.Function2Test(1234);

        System.out.println(str.replace("12", "00"));

    }
}


/** 010 内建函数式接口
 * 
 * 在方法引用的操作中有一些范式：参数&返回值（有误的组合 ： 11，10，01，00判断真假）；
 * 因此JDK1.8 + 后，直接在java.util.function 里面定义了如下函数式接口
 */
/*
@FunctionalInterface
public interface Function<T,R>{
    public R apply(T t);
}
@FunctionalInterface
public interface Consumer<T>{
    public void accept(T t);
}
@FunctionalInterface
public interface Supplier<T>{
    public T get();
}
@FunctionalInterface
public interface Predicate<T>{
    public boolean test(T t);
}

//*/