package staticimport.learning;

public class ImportLearning{
    public static int add (int ... val){
        int sum = 0;

        for(int item:val){
            sum += item;
        }

        return sum;
    }

    public static int sub (int ... val){
        int sum = 0;

        for(int item:val){   
            sum -= item;
        }

        return sum;
    }


}