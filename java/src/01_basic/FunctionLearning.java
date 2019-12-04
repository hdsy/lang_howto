public class FunctionLearning{
    public static void main(String args[]){
        printInfo();

        printInfo("*    World!    *");

        
        printInfo("* " + printInfo(100) + "       *");
    }

    public static void printInfo(){
        System.out.println("****************");
        System.out.println("*    hello     *");
        System.out.println("****************");
    }
    /**
     * 重载函数
     * @param arg
     */
    public static void printInfo(String arg){
        System.out.println("****************");
        System.out.println(arg);
        System.out.println("****************");
    }

    public static int printInfo(int arg){
        if (arg == 1)
            return 1;
        
        return arg + printInfo(arg-1);
    }
}