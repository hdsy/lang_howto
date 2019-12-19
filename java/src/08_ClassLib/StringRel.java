public class StringRel {
    public static void main(String args[]){
        System.out.println("StringRel::main :");

        StringTest();
    }

    
    /** 字符串
     *  String          不能改变的内容的字符串
     *      <-  extends Object
     *      <-  implements Serializable , Comparable<String> , CharSequence
     * 
     *  StringBuffer    可频繁改变的字符串，而且其方法都是 synchronized 申明的，是线程安全的
     *      <-  extends Object
     *      <-  implements Serializable , CharSequence
     * 
     *      常用方法为 
     *          append
     *          reverse 字符串反转操作
     *          insert  在指定位置追加内容
     *          delete  删除指定索引范围的内容
     * 
     *  StringBuilder   可频繁改变的字符串，但是方法可异常操作，属于非线程安全方法     
     *      <-  extends Object
     *      <-  implements Serializable , CharSequence
     */
    public static void StringTest(){
        StringBuffer objStrBuf = new StringBuffer("I ");

        objStrBuf.append("Hello ").append("world").append("!!!");

        System.out.println(objStrBuf);

        change(objStrBuf);

        System.out.println(objStrBuf.delete(1, 10));

        String objStr = objStrBuf.toString();

        String objStr1 = new String(objStrBuf.reverse());

        

        System.out.println(objStr + " " + objStr1 + " " + objStr.contentEquals(objStrBuf.insert(1,"AA")));

        change(objStr);

        System.out.println(objStr+ " " + objStr1);



    }

    public static void change(StringBuffer sb){
        sb.append("+StringBuffer+...");
    }

    public static void change(String sb){
        sb += "+String+...";
    }
}
 