package exception1;

public class ExceptionLearning {
    public static void main(String args[]) throws Exception{

        System.out.println("div start:");

    
        // 放在非try块中，编译就会报异常， 因为div用throws声明了异常 ;  除非主程序也用throws声明了不处理异常
        System.out.println("10/10 = " + MyMath.div(10,1));


        try{
            
            // 放在非try块中，编译就会报异常， 因为div用throws声明了异常
            System.out.println("10/10 = " + MyMath.div(10,0));

            System.out.println("10/0 = " + (10/1.0));
            System.out.println("div ended");

            System.out.println("args[1] = " + args[1]);
            System.out.println("arr exceed ended");

        }
        catch(ArithmeticException ex){

            System.out.println("ArithmeticException ocurr");
            System.out.print(ex.getMessage());

            ex.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException ex){

            System.out.println("ArrayIndexOutOfBoundsException ocurr");
            System.out.print(ex.getMessage());

            ex.printStackTrace();
        }
        catch(Exception ex){

            System.out.println("Exception ocurr");
            System.out.print(ex.getMessage());

            ex.printStackTrace();
        }

        finally{
            System.out.println("always be done here ");
        }
        System.out.println("all ended");
    }
}

/**
 * Object 
 *  -> Throwable    
 *      -> Exception    指的是程序运行中的一场，程序可给予一场处理机制处理
 *          -> RuntimeException  基于此类的异常并不要求一定有使用方显示处理，但如果有异常，程序会终止，交给JVM处理
 *              -> ArithmaticException
 *              -> IllegalArgumentException
 *                  -> NumberFormatException
 *      -> Error 指的是JVM的错误，程序尚未执行，无法处理
 * 
 *  Exception 的捕获机制按照代码的捕获顺序传递直到最后;所以如果有父层异常要放到子层的后面，否则是不可触达的。有些编译器更会直接报错
 *      原理上可以捕获Throwable，但是因为Throwable还有Error的情形出现，程序无法处理，因而这个做法是无效的
 */


 /**
  * throws 声明我不处理异常，要有使用方来处理异常
  */
 class MyMath{
     public static int div (int x,int y)throws Exception{
         int res = 0;

         System.out.println("div statrt");

         // 进行断言操作，识别除数为0
         /**
          * 默认java不开启断言，需要使用-ea选项给予打开
            java -ea 

            #java\src\exception1>java -ea exception1.ExceptionLearning
            div start:
            div statrt
            Exception in thread "main" java.lang.AssertionError: y is 0
                    at exception1.MyMath.div(ExceptionLearning.java:83)
                    at exception1.ExceptionLearning.main(ExceptionLearning.java:10)

            #\java\src\exception1>java  exception1.ExceptionLearning
            div start:
            div statrt
            div ended
            Exception in thread "main" java.lang.ArithmeticException: / by zero
                    at exception1.MyMath.div(ExceptionLearning.java:86)
                    at exception1.ExceptionLearning.main(ExceptionLearning.java:10)
                    
          */
         assert y != 0 : "y is 0";

         try{
             res = x/y;
         }
         catch(Exception ex)
         {
             // 向外抛出异常，并可增加保障性代码，确保动作到位
             System.out.println(ex.getMessage());

             throw new MyException("may be y is 0");
         }
         finally{
             System.out.println("div ended");
         }
         return res;
     }
 }

 /**
  * 自定义异常
  */
 class MyException extends Exception{
     /**
    * 编译器提示增加的，不懂什么意思
    */
    private static final long serialVersionUID = 1L;

    public MyException(String msg) {
         super(msg);
     }
 }