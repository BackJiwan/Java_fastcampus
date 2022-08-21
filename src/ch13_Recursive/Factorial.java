//1.팩토리얼을 구해야한다.
//2.factorial 함수를 만들고 매개변수로 n을 받고 결과를 return 한다.
//3.팩토리얼 함수는 내부에서 n * n-1 을 수행하며 n -1은 팩토리얼 함수로 진행한다.

package ch13_Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Factorial {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(factorial(n));
    }
    public static int factorial(int n){
        if(n<=1)
            return 1;
        else
            return n * factorial(n-1);
    }
}
