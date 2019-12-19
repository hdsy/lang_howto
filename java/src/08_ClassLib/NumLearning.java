import java.util.Random;

import java.math.BigInteger;
import java.math.BigDecimal;



import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Arrays;

public class NumLearning {
    public static void main(final String args[]) throws Exception {
        System.out.println("NumLearning::main :");
        NumTest();
        DecimalTest();
        DateTest();
        CalendarTest();
        ArraysTest();
    }

    static void ArraysTest(){
        int data[] = new int[]{1,5,6,2,3,4,9,8,7,10};

        
        for (int itm :data)
            System.out.print(itm+" ");
        System.out.println();    

        Arrays.sort(data);

        for (int itm :data)
            System.out.print(itm+" ");
        System.out.println();

        System.out.println(Arrays.binarySearch(data,9));

        int data1[] ={1,5,6,2,3,4,9,8,7,10};
        int data2[] ={1,5,6,2,3,4,9,8,7,10};

        System.out.println(Arrays.equals(data1,data2) + " " + Arrays.equals(data,data2));

        System.out.println(data.toString() + ":" + Arrays.toString(data));

        // 当array是对象时，如果要直接使用sort类函数，则需要实现Comparable接口
        /**
         * Arrays ： equals|fill|sort|binarySearch|toString
         * 
         * public interface Comparable<T>{
         *  // return code  : 
         *      > 1 
         *      < -1 
         *      = 0
         *  public int compareTo(T o);
         * }
        */

        /**
         * 如果对象没有实现Comparable，那么可以使用Comparator的接口，可挽救此类情况
         * @FunctionalInterface
         * public interface Comparator<T>{
         *  public int compare(T o1,T o2);
         *  public boolean equals(Object obj);
         * }
         * 
         */


    }

    static void CalendarTest(){
        Calendar objCalendar = Calendar.getInstance();

        StringBuffer buf = new StringBuffer();

        buf.append(objCalendar.get(Calendar.YEAR)).append("-");
        buf.append(objCalendar.get(Calendar.MONTH)+1).append("-"); // month from 0 ,so ++
        buf.append(objCalendar.get(Calendar.DAY_OF_MONTH)).append(" ");
        buf.append(objCalendar.get(Calendar.HOUR_OF_DAY)).append(":");
        buf.append(objCalendar.get(Calendar.MINUTE)).append(":");
        buf.append(objCalendar.get(Calendar.SECOND)).append(".");
        buf.append(objCalendar.get(Calendar.MILLISECOND));

        System.out.println(buf);
    }

    /** Others ...
     * 
     * Calendar
     * Arrays
     *  Comparable
     *  Comparator
     *      lambda
     * 
     */

    /**
     * Date
     * @throws ParseException
     * 
     * 
     */ 
    public static void DateTest() throws ParseException{
        Date objDate = new Date();

        System.out.println(objDate);
        System.out.println(objDate.getTime());

        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        String str = objSDF.format(objDate);

        System.out.println(str);

        String strDate = "2005-12-21 10:10:10.101";

        Date objDate1 = objSDF.parse(strDate);


        System.out.println(objDate1);
        System.out.println(objDate1.getTime());


        
    }

    /** BigDecimal
     * 
     */
    public static void DecimalTest(){
        BigDecimal bigA = new BigDecimal(15.5);

        BigDecimal bigB = bigA.divide(new BigDecimal(1),0,BigDecimal.ROUND_HALF_UP);

        System.out.println(bigB.doubleValue());

    }

    /** BigInteger
     * Math 的方法以static定义，支持对数、绝对值、幂运算等 Random 随机数，对象形态 BigInteger 大整数 bigDecimal
     * 大浮点数
     */
    public static void NumTest() {

        double a = Math.round(12.2);
        a = Math.pow(12.2, 2);

        final Random rd = new Random();
        a = rd.nextInt(100);

        final Random rd1 = new Random(1);
        a = rd1.nextInt(100);

        final BigInteger bigA = new BigInteger("234809234801");
        final BigInteger bigB = new BigInteger("8939834789");

        System.out.println("add big : "+bigA.add(bigB));

        System.out.println("mul big : "+bigA.multiply(bigB));
        System.out.println("sub big : "+bigA.subtract(bigB));
        System.out.println("div  big : "+bigA.divide(bigB));

        BigInteger result[] = bigA.divideAndRemainder(bigB);

        System.out.println("商："+result[0]+",余数："+result[1]);
    }
}