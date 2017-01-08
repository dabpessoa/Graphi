package unifor.br.tad;

import java.util.ArrayList;

import unifor.br.graph.Edge;
import unifor.br.graph.Vertex;

public interface GraphTAD {
	//modificadores da estrutura
    public void insertVertex(Vertex v);
    public void insertVertex(Object o);
    public Object removeVertex(Vertex v);
    public Object removeVertex(Object o);
    public boolean insertEdge(Edge e);
    public boolean insertEdge(Object left, Object right, Object weight);
    public Object removeEdge(Edge e);
    public Object removeEdge(Object left, Object right, Object weight);

    //analisadores da estrutura
    public int grauGraph();
    public ArrayList<Vertex> getAdjacents(Vertex v, boolean isOrientated);
    public ArrayList<Vertex> getAdjacents(Object o, boolean isOrientated);
}
