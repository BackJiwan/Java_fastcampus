package ch20_2_kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

public class KruskalPath {
    HashMap<String,String> parent = new HashMap<String,String>(); //key=자식노드, value = 부모노드
    HashMap<String,Integer> rank = new HashMap<String,Integer>(); //key=노드이름, value = 랭크값

    public String find(String node){
        //path compression 적용
        //find는 최종적으로 부모노드의 이름을 리턴한다.
        //만약 노드의 부모노드가 현재 노드와 같지 않다면 부모 노드가 존재한다는 뜻
        if(parent.get(node) != node){
            //부모 노드가 존재한다면 현재 노드의 부모로 부모 노드의 부모 노드를 전달해준다.
            //즉 이과정이 재귀적으로 발생하면 최종적으로 Root 하나에 여러 자식노드가 1레벨로 연결된다.
            parent.put(node,find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentNode;

        // 1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            makeSet(vertices.get(index));
        }

        // 2. 간선 weight 기반 sorting
        // Collections.sort() : ArrayList 정렬 기능
        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++) {
            currentNode = edges.get(index);
            if (find(currentNode.nodeV) != find(currentNode.nodeU)) {
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }

        return mst;
    }



    public static void main(String[] args){
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalPath kObject = new KruskalPath();
        System.out.println(kObject.kruskalFunc(vertices, edges));
    }

}
