package ch18_graphSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFSSearch {
    static HashMap<String, ArrayList<String>> graph2 = new HashMap<String, ArrayList<String>>();

    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> grpah, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size()-1);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph2.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        graph2.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph2.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph2.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph2.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph2.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph2.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph2.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph2.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph2.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph2.put("J", new ArrayList<String>(Arrays.asList("I")));

        BFSSearch bObject = new BFSSearch();
        System.out.println(bObject.bfsFunc(graph2, "A"));
    }
}