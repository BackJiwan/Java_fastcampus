package ch21_backtracking;

import java.util.ArrayList;

public class NQueen {
    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size(); //하나의 Row에는 하나의 후보밖에 존재할 수 없다. 따라서 퀸 리스트의 사이즈=탐색해야할 Row
        for (int index = 0; index < currentRow; index++) {
            //후보들은 현재 탐색중인 Row보다 작은 값을 가지므로 index는 currentRow까지만 검사해보면된다.
            //currentCol은 탐색중인 Row에서 전달받은 특정한 Col이다. currentCol과 동일한 Col을 가지는 퀸이 있는지 확인해보고
            //또는 절대값(candidate.get(index)-currentCol) => y좌표 차이 == x좌표차이 인지 확인하여 대각선산에 위치하는지 판별
            //이때 currentRow의 값이 무조건 이전 퀸들의 index보다 크기 때문에 절대값이 필요하지 않다.
            if ((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index) ) {
                return false;
            }
        }
        return true;
    }

    //dfsFunc은 체스판의 크기 N과 현재 탐색중인 Row정보, 현재까지 가능한 퀸의 리스트를 인자로 받는다.
    private void dfsFunc(Integer N,Integer currentRow, ArrayList<Integer> currentCandidate) {
        //currentRow가 N이라는 것은 가장 아랫줄 까지 모두 검사하였다는 뜻이므로 현재까지 가능한 퀸을 출력한다.
        if(currentRow ==N){
            System.out.println(currentCandidate);
            return;
        }

        for(int index=0;index<N;index++){
            //index는 현재 분석중인 열(currentRow)에서 한칸씩 행을 이동하는 것이다.
            //따라서 현재 위치하고 있는 Row의 정보는 이미 알고 있으므로 index(Column)만 있어도 좌표를 알 수 있다.
            if(isAvailable(currentCandidate,index) == true){
                //index는 현재 Row의 특정 Col을 의미한다.
                //만약 현재까지의 퀸의 위치들과 현재 분석중인 좌표가 성립가능한 위치라면 현재 좌표를 퀸 위치 리스트에 등록하고 재귀호출
                currentCandidate.add(index);
                this.dfsFunc(N,currentRow +1,currentCandidate);
                //재귀함수 호출이후 별다른 소득없이 리턴했다면 더 볼필요 없기 때문에 방금 넣어준 퀸의 좌표를 remove해준다.
                currentCandidate.remove(currentCandidate.size() -1);
            }
        }
    }

    public static void main(String[] args){
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4,0,new ArrayList<Integer>());
    }
}
