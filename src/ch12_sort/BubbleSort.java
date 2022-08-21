package ch12_sort;

import java.util.ArrayList;
import java.util.Collections;


public class BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int idx=0;idx<dataList.size()-1;idx++){
            boolean swap = false;
            for(int idx2=0;idx2<dataList.size()-1-idx;idx2++){
                if(dataList.get(idx2)>dataList.get(idx2+1)){
                    Collections.swap(dataList,idx2,idx2+1);
                    swap = true;
                }
            }
            if(swap ==false){ //버블정렬은 맨앞에서부터 맨뒤까지 그 이후에는 맨앞에서 부터 맨뒤의 한칸앞까지
                //이동하는 방식인데 이때 한번의 순회에서 swap이 없었다면 굳이 남은 것들을 진행할 필요없이 정렬된 데이터임을 알수있다.
                break;
            }
        }
        return dataList;
    }
    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            testData.add((int)(Math.random() *100));
        }
        System.out.println(sort(testData));
    }
}
