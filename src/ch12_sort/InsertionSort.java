package ch12_sort;
import java.util.ArrayList;
import java.util.Collections;
//강의 없이 구현해본 삽입정렬 코드
public class InsertionSort {
    public ArrayList<Integer> iSort(ArrayList<Integer> dataList){
        for(int stand=0;stand<dataList.size()-1;stand++){
            for(int idx = stand+1;idx>0;idx--){
                if(dataList.get(idx)<dataList.get(idx-1)){
                    Collections.swap(dataList,idx,idx-1);
                } else{ //기준점의 앞부분은 정렬이 되어 있는 상태이기때문에 한번 막히면 더이상 진행 필요 X
                    break;
                }
            }
        }
        return dataList;
    }
}
class Main2{
    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        InsertionSort iSort = new InsertionSort();
        for(int i=0;i<100;i++){
            testData.add((int)(Math.random()*100));
        }
        System.out.println(iSort.iSort(testData));
    }
}