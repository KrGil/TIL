package programmer_lv1;

public class lee {
    public static void main(String[] args) {
        solution(5);
    }

    public static int solution(int n){
        // n 이 1~100 사이
        // 약수의 갯수의 합.

        int result=0;

        for(int x=1;x<=n;x++){
            for(int y=1;x>=y;y++){
                if(x%y==0){
                    System.out.println("x:"+x+"y:"+y);

                    result++;
                }
                else if(y>x) y=0;
            }
            System.out.println("result:"+result);
        }



        return result;
    }
}
