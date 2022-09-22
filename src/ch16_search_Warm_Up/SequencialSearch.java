package ch16_search_Warm_Up;

import java.util.ArrayList;

public class SequencialSearch {
    public int searchFunc(ArrayList<Integer> dataList,Integer searchItem){
        for(int idx =0; idx<dataList.size();idx++){
            if(dataList.get(idx) == searchItem){
                return idx;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            testData.add((int)(Math.random())*100);
        }

        SequencialSearch sSearch = new SequencialSearch();
        System.out.println(sSearch.searchFunc(testData,99));
    }
}
