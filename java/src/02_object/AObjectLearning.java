package object;

import jdk.internal.cmm.SystemResourcePressureImpl;

/**
 * 
 */
public class AObjectLearning{
    public static void main(final String args[]) {
        System.out.println("AObjectLearning generator.");

        final GoodStudent objGoodStudent = new GoodStudent();

        objGoodStudent.DumpInfo();

        // 不适用不报错
        // A objA = new A();
        // objA.DumpInfo();


        func(new PolyB()); // B A
        func(new PolyC()); // C B A
        func(new PolyA()); // A

        // instanceof 用来判断对象是否属于类
        System.out.println(new PolyB() instanceof PolyA); // true
        System.out.println(new PolyB() instanceof PolyB); // true
        System.out.println(new PolyB() instanceof PolyC); // false

        PolyA aobj = new PolyA();
        PolyB bobj = new PolyB();
        PolyC cobj = new PolyC();

        func(aobj);func(bobj);func(cobj);
        System.out.println(cobj instanceof PolyC);
        System.out.println(bobj instanceof PolyC);
        System.out.println(aobj instanceof PolyC);

        B_abstract objB = new B_abstract();
        System.out.println( objB.sum(1,2));
        System.out.println( objB.sum(1,2,3));

        ABC_implement objABC_implement = new ABC_implement();
        ABC_implement objABC_implement1= new ABC_implement();
        objABC_implement.sub();
        System.out.println(objABC_implement instanceof ABC_implement);
        System.out.println(objABC_implement instanceof A_interface);
        System.out.println(objABC_implement instanceof B_interface);
        System.out.println(objABC_implement instanceof C_interface);

        // 任何类都继承自Object， Object可用来表示所有的引用对象 int [] 
        System.out.println(objABC_implement instanceof Object);

        // Object的三个方法
        System.out.println(objABC_implement.toString());
        System.out.println(objABC_implement.hashCode());
        System.out.println(objABC_implement1.toString());
        System.out.println(objABC_implement1.hashCode());

        // 合理的重载equals方法，可以用来比较对象的一致性
        System.out.println(objABC_implement.equals(objABC_implement1));
        
        ObjectTest();
        

    }
    /**
     * Object也可以用来表示数组、接口等
     */
    static void ObjectTest()
    {
        Object obj = new int[]{1,23,43};
        System.out.println(obj);

        if (obj instanceof int[]){
            int data[] = (int[])obj;

            for (int x=0;x < data.length;x++){
                System.out.print(data[x]+" ");
            }
        }
    }

    static void func(PolyA obj){
        obj.print();
    }
}

class Person {
    public String name;
    public String id;
    public int age;
    public boolean sex;

    public Person() {
        name = "Gao yong";
        id = "4210031978";
        age = 23;
        sex = false;
    }

    public Person(final String name) {
        this.name = name;
    }
    

    public void DumpInfo(){
        System.out.println("name= "+name+";id="+id+";age="+age+",sex="+sex);
    }
}
/**
 * java 类继承只能有一个父类，但是可以多次继承。这个是与C++的最大区别
 */
class Student  extends Person{
    public String school;
    public String grade;
    public String classname;

    public Student(){
        // 调用上级构造函数，必须放在第一行
        super("Maven实战");
        school = "Nanshan";
        grade = "8.1";
        classname = "0";
    }

    public void DumpInfo(){
        System.out.println("school= "+school+";grade="+grade+";classname="+classname);
        // super指父类
        super.DumpInfo();
    }

}
// final 定义的类，不能再次被继承
final class GoodStudent extends Student{
    public String award;

    public GoodStudent(){
        award = "12";
    }
    public void DumpInfo(){
        System.out.println("award= "+award);
        super.DumpInfo();
    }


}
final class B{
    void a(){}

    /**
     * final 定义的函数不允许被重复定义
     */
    final b(){}

    // final 定义的属性必须被初始化，以后再不能被修改
    final double GOOD = 100.0;
}
class A extends B{
    public String a;
    public void DumpInfo(){
        a = "a.b.a";
        System.out.println(a);
    }
}

class PolyA{
    public void print(){
        System.out.println("A print");
    }
}
class PolyB extends PolyA{
    /**
     * 重写父类的print
     */
    public void print(){
        System.out.println("B print");
        super.print();
    }
}

class PolyC extends PolyB{
    /**
     * 重写父类的print
     */
    public void print(){
        System.out.println("C print");
        super.print();
    }
}

/**
 * 抽象类
 * 
 *  抽象类不能直接实例化为对象
 * 
 */
abstract class A_abstract{
    public int sum(int a,int b){
        return a+b;
    }
    /**
     * 要求子类必须实现此函数
     * @param a
     * @param b
     * @param c
     * @return
     */
    public abstract int sum(int a,int b,int c);
}

class B_abstract extends A_abstract{
    public int sum(int a,int b,int c){
        return a+b+c;
    }
}

/**
 * 如果定义的类都是抽象方法和属性，就可以使用接口定义，而不是使用抽象定义
 * 
 *  另外他可以被实现类多重引用
 */
interface A_interface {
    public static final String MSG = "A_OK";

    public abstract void sum();
}
interface B_interface {
    public static final String MSG = "B_OK";

    public abstract void sub();
}
interface C_interface {
    public static final String MSG = "C_OK";

    public abstract void mul();
}

class ABC_implement implements A_interface,B_interface,C_interface{
    public void sum(){System.out.println(A_interface.MSG);}
    public void sub(){System.out.println(C_interface.MSG);}
    public void mul(){System.out.println(B_interface.MSG);}
}