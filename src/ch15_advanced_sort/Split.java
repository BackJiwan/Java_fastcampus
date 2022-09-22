//package ch15_advanced_sort;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Split {
//    public void splitFunc(ArrayList<Integer> dataList){
//        if(dataList.size() <= 1){
//            return ;
//        }
//        int medium = dataList.size()/2;
//
//        ArrayList<Integer> leftArr = new ArrayList<Integer>();
//        ArrayList<Integer> rightArr  = new ArrayList<Integer>();
//
//        leftArr = new ArrayList<Integer>(dataList.subList(0,medium));
//        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));
//
//        System.out.println(leftArr);
//        System.out.println(rightArr);
//    }
//    public static void main(String[] args){
//        Split sObject = new Split();
//        sObject.splitFunc(new ArrayList<Integer>(Arrays.asList(4,1,2,3,5,7)));
//    }
//}


