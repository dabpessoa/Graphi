package unifor.br.graph;

public class Vertex {
	private Object inf;
	
	public Vertex() {}
	
	public Vertex(Object inf) {
		this.inf = inf;
	}

	public Object getInf() {
		return inf;
	}

	public void setInf(Object inf) {
		this.inf = inf;
	}
	
	public String toString() {
		return inf.toString();
	}
}
