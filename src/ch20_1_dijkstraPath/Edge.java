package ch20_1_dijkstraPath;

class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex; //노드의 이름과 가중치를 가진다.

    public Edge(int distance, String vertex) { //생성자(거리,이름)
        this.distance = distance;
        this.vertex = vertex;
    }

    // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
    public String toString() { //toString을 손대면 println의 동작을 변경가능하다.
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }

    @Override //Edge 타입의 객체에서 distance를 기준으로 정렬하도록 재정의 한다.
    public int compareTo(Edge edge)
    {
        return this.distance - edge.distance;
    }
}
