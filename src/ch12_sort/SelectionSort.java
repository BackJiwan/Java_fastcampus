package ch12_sort;
import java.util.ArrayList;
import java.util.Collections;
//강의 없이 직접 구현해본 선택정렬 알고리즘

public class SelectionSort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int stand=0;stand<dataList.size()-1;stand++){
            int lowest = dataList.get(stand);
            int lowest_idx = stand;
            for(int idx = stand+1;idx<dataList.size();idx++){
                if(dataList.get(idx)<lowest){ //만약 가장 앞부터 선정되는 기준 요소보다 작은 값이 존재한다면 인덱스와 값을 기억한다.
                    lowest =dataList.get(idx);
                    lowest_idx = idx;
                }
            }
            Collections.swap(dataList,stand,lowest_idx); //최종적으로 매 시행마다 가장 작았던 값을 기준점과 swap한다.
        }
        return dataList;
    }
}
class Main{
    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<Integer>();
        SelectionSort sSort = new SelectionSort();

        for(int i=0;i<100;i++){
            testData.add((int)(Math.random()*100));
        }

        System.out.println(sSort.sort(testData));
    }

}
