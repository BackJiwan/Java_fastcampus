import java.util.ArrayList;
import java.util.Collections;


public class ch12_BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int idx=0;idx<dataList.size()-1;idx++){
            boolean swap = false;
            for(int idx2=0;idx2<dataList.size()-1-idx;idx2++){
                if(dataList.get(idx2)>dataList.get(idx2+1)){
                    Collections.swap(dataList,idx2,idx2+1);
                    swap = true;
                }
            }
            if(swap ==false){
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
