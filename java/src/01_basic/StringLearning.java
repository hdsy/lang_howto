public class StringLearning{
    public static void main(String args[]){
        String str = "Hello World!";

        System.out.println(str);

        CJavaString jstr = new CJavaString();

        System.out.println(jstr.Add("Hello"," World"));
        System.out.println(jstr.AddInt("Hello ",100));
        System.out.println(jstr.AddInt("Hello ",100,45));
    }

}
/**
 * java支持特殊字符：
 *  换行    \n
 *  制表    \t
 *  反杠    \\
 *  引号    \"
 *  单引    \'
 */
class CJavaString{
    /**
     * String + 会将两个字符串拼接起来
     * @param l
     * @param r
     * @return
     */
    String Add(String l,String r){
        return l+r;
    }

    /**
     * String + int 会先将int转换成String，再拼接起来
     * @param l
     * @param r
     * @return
     */
    String AddInt(String l,int r){
        return l+r;
    }
    /**
     * String + int + int 从左往右结合，先转为String，再拼接
     * @param l
     * @param r
     * @param r1
     * @return
     */
    String AddInt(String l,int r,int r1){
        return l+r+r1;
    }

}