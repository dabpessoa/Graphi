package unifor.br.graph;

public class Edge {
	private Vertex leftVertex;
	private Vertex rightVertex;
	private Object weight;
	
	public Edge() {}
	
	public Edge(Vertex leftVertex, Vertex rightVertex, Object weight) {
		this.leftVertex = leftVertex;
		this.rightVertex = rightVertex;
		this.weight = weight;
	}

	public Vertex getLeftVertex() {
		return leftVertex;
	}

	public void setLeftVertex(Vertex leftVertex) {
		this.leftVertex = leftVertex;
	}

	public Vertex getRightVertex() {
		return rightVertex;
	}

	public void setRightVertex(Vertex rightVertex) {
		this.rightVertex = rightVertex;
	}

	public Object getWeight() {
		return weight;
	}

	public void setWeight(Object weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "("+leftVertex+","+rightVertex+","+weight+")";
	}
}
