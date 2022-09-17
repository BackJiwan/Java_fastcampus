package ch14_DP_DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Dynamic {
    public static int dynamicFunc(int data){
        Integer[] cache = new Integer[data+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int idx =2;idx<data+1;idx++){
            cache[idx] = cache[idx-1] + cache[idx-2];
        }
        return cache[data];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dynamicFunc(n));
    }
}
