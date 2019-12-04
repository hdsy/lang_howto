/**
 * Java 数据类型分为基本与引用，基本数据类型不需要显示的分配内存，引用的需要显示生命和分配。
 * 
 * 基础数据类型：
 *      数值型 
 *          类型 尺寸bit 取值范围 默认值
 *          byte  8 [-128,127] 0  最接近于内存实质，当网络传输或者字符编解码时可使用此类型
 *          short 16 [-32768,32767] 0
 *          int 32 [-2147483648,2147483647] 0
 *          long 64,[-..,...] 0
 *          float 32 [-3.4E38,3.4E38] 0
 *          double 64 [-1.7E308,1.7E308] 0
 *      字符型 
 *          char 16 [0-255] 0
 *      布尔型 
 *          boolean - [ture,false] false
 * 
 * 引用数据类型：
 *      类 class
 *      接口    interface
 *      数组    
 */
class Test {
    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;
 
    public static void main(String[] args) {
        System.out.println("Bool :" + bool);
        System.out.println("Byte :" + by);
        System.out.println("Character:" + ch);
        System.out.println("Double :" + d);
        System.out.println("Float :" + f);
        System.out.println("Integer :" + i);
        System.out.println("Long :" + l);
        System.out.println("Short :" + sh);
        System.out.println("String :" + str);
    }
}

public class DataTypeLearning{
    static void TypeBasicTest(){
        // byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
  
        // short  
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);  
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();  
  
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);  
    }
    public static void main(final String args[]){

        TypeBasicTest();

        System.out.println("DataTypeLearning");

        int num = 10;

        System.out.println(num);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 须弥戒子：最大+1 则为最小，最小-1则为最大;  这个是java的设计原则，循环使然。
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE-1);
        // 如果要想获得正确的值，要使用long
        System.out.println(Integer.MAX_VALUE+1L);
        System.out.println(Integer.MIN_VALUE-1L);
        // 将范围大的数据类型转为范围小的数据类型
        short num_short = (short)num;
        System.out.println(num_short);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        // 要考虑可能的数据溢出,这个溢出的规则很有意思，也是循环的。最大最小如此往复
        num = Short.MAX_VALUE+10;
        System.out.println(num);
        num_short = (short)num;
        System.out.println(num_short);

        // 浮点数
        float f1 = 10.2F;
        float f2 = (float) 10.2;

        double d1 = 10.2;
        System.out.println(f1*f2);  // 104.03999 属于java的计算BUG，要在Math、BigDecimal这些工具类中解决之
        System.out.println(d1*d1);  // 104.03999999999999

        /**运算中的类型变换
         * 
         * int/int => int
         * int + long => long
         * int / double => double
         * 
         * */ 


        char c = 'A';
        int c_num = c;
        System.out.println(c);
        System.out.println(c_num);

        // 字母的大小写转换
        c_num += 32;
        c = (char)c_num;
        System.out.println(c);
        System.out.println(c_num);

        // 汉字的表示
        c = '高';
        c_num = c;
        System.out.println(c);
        System.out.println(c_num);


        boolean flag =false ;

        if (!flag){
            System.out.println("flag is false");
        }


    }
}

