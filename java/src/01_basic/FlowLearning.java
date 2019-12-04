public class FlowLearning{
    public static void main(String args[]){
        /**
         * 条件分支
         */
        int a = 3;
        int b = 1;
        /*
         if (expr1){}else if(expr2){}else{}
            expr 为bool表达式或bool值
         */
        if(a > b){
            System.out.println("True  : a > b is "+ (a>b));
        }
        else{
            System.out.println("False : a > b is "+ (a>b));
        }

        // 
        /**
         * switch(expr){case value:break;...;default:break;}
            expr : 整数，字符，枚举，String
         */
            
        switch(a){// 逻辑值不合法 a>b
            case 2:
                System.out.println("Swith 3  : a  is "+ a);break;
            case 1:
                System.out.println("Swith 1 : a  is "+ a);break;
            default:
                System.out.println("default  : a  is "+ a);break;

        }

        /**
         * while(expr){;continue;break;}
         * do{;continue;break;}while(expr)
         * for(org,expr,upt){;continue;break;}
         * 
         * expr bool表达式
         * 
         * continue 退出本轮次循环，继续下一个循环
         * break 退出整个循环
         * 
         */

         for(int x=1;x<=9;x++)
         {
             for(int y=1;y<=x;y++)
             {
                 System.out.print(x + "*" + y + "=" +(x*y) + "\t");
             }
             System.out.println();
         }

       

    }
}