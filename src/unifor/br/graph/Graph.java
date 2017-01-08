package unifor.br.graph;

import java.util.ArrayList;
import java.util.List;

import unifor.br.tad.GraphTAD;

public class Graph implements GraphTAD{
	private List<Vertex> vertexes;
	private List<Edge> edges;
	
	public Graph() {
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	@Override
	public void insertVertex(Vertex v) {
		vertexes.add(v);
	}
	
	@Override
	public void insertVertex(Object o) {
		Vertex v = new Vertex(o);
		vertexes.add(v);
	}
	
	@Override
	public Object removeVertex(Vertex v) {
		Object aux = v.getInf();
		vertexes.remove(v);
		return aux;
	}
	
	@Override
	public Object removeVertex(Object o) {
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).getInf().equals(o)) {
				vertexes.remove(vertexes.get(i));
				return o;
			}
		}
		return o;
	}
	
	@Override
	public boolean insertEdge(Edge e) {
		boolean leftOK = false;
		boolean rightOK = false;
		
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).equals(e.getLeftVertex())) {
				leftOK = true;
			}
		}
		
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).equals(e.getRightVertex())) {
				rightOK = true;
			}
		}
		
		if (leftOK && rightOK) {
			edges.add(e);
			
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insertEdge(Object left, Object right, Object weight) {
		Vertex vLeft = new Vertex(left);
		Vertex vRight = new Vertex(right);
		Edge e = new Edge(vLeft, vRight, weight);
		
		boolean leftOK = false;
		boolean rightOK = false;
		
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).equals(e.getLeftVertex())) {
				leftOK = true;
			}
		}
		
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).equals(e.getRightVertex())) {
				rightOK = true;
			}
		}
		
		if (leftOK && rightOK) {
			edges.add(e);
			
			return true;
		}
		return false;
	}
	
	@Override
	public Object removeEdge(Edge e) {
		Edge aux = e;
		edges.remove(e);
		return aux.getWeight();
	}
	
	@Override
	public Object removeEdge(Object left, Object right, Object weight) {
		for (int i = 0 ; i < edges.size() ; i++) {
			if (edges.get(i).getLeftVertex().getInf().equals(left) && edges.get(i).getRightVertex().getInf().equals(right) && edges.get(i).getWeight().equals(weight)) {
				edges.remove(edges.get(i));
				return weight;
			}
		}
		
		return weight;
	}
	
	@Override
	public ArrayList<Vertex> getAdjacents(Vertex v, boolean isOrientated) {
		ArrayList<Vertex> listAdj = new ArrayList<Vertex>();
		
		for (int i = 0 ; i < edges.size() ; i++) {
			if (edges.get(i).getLeftVertex().equals(v)) {
				listAdj.add(edges.get(i).getRightVertex());
			}
			
			if (isOrientated) {
				if (edges.get(i).getRightVertex().equals(v)) {
					listAdj.add(edges.get(i).getLeftVertex());
				}
			}
		}
		
		return listAdj;
	}
	
	@Override
	public ArrayList<Vertex> getAdjacents(Object o, boolean isOrientated) {
		Vertex v = new Vertex();
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).getInf().equals(o)) {
				v = vertexes.get(i);
			}
		}
		
		ArrayList<Vertex> listAdj = new ArrayList<Vertex>();
		
		for (int i = 0 ; i < edges.size() ; i++) {
			if (edges.get(i).getLeftVertex().equals(v)) {
				listAdj.add(edges.get(i).getRightVertex());
			}
			
			if (isOrientated) {
				if (edges.get(i).getRightVertex().equals(v)) {
					listAdj.add(edges.get(i).getLeftVertex());
				}
			}
		}
		
		return listAdj;
	}
	
	@Override
	public int grauGraph() {
		return vertexes.size();
	}
	
	public boolean isAdjacent(Vertex v1, Vertex v2, boolean isOrientated) {
		
		for (int k = 0 ; k < edges.size() ; k++) {
			if (edges.get(k).getLeftVertex().equals(v1)) {
				if (edges.get(k).getRightVertex().equals(v2)) {
					return true;
				}
			}
			
			if (!isOrientated) {
				if (edges.get(k).getRightVertex().equals(v1)) {
					if (edges.get(k).getLeftVertex().equals(v2)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isAdjacent(Object o1, Object o2, boolean isOrientated) {
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).getInf().equals(o1)) {
				v1 = vertexes.get(i);
			}
			if (vertexes.get(i).getInf().equals(o2)) {
				v2 = vertexes.get(i);
			}
		}
		
		for (int k = 0 ; k < edges.size() ; k++) {
			if (edges.get(k).getLeftVertex().equals(v1)) {
				if (edges.get(k).getRightVertex().equals(v2)) {
					return true;
				}
			}
			
			if (!isOrientated) {
				if (edges.get(k).getRightVertex().equals(v1)) {
					if (edges.get(k).getLeftVertex().equals(v2)) {
						return true;
					}
				}
			}
		}		
		
		return false;
	}
	
	public String getMatrizAdj(boolean isOrientated) {
        StringBuffer out = new StringBuffer();

        out.append("--> Matriz De Adjacência: \n");
        out.append("\n");
        
        out.append("\t     ");
        for (int i = 0 ; i < grauGraph() ; i++) {
        	out.append(vertexes.get(i).getInf().toString()+"   ");
        }
        out.append("\n");
        
        for ( int i=0; i<grauGraph(); i++ )
        { out.append("\t" + vertexes.get(i).getInf().toString() +":   ");
          for ( int j=0; j<grauGraph(); j++ )
          {
            if (isAdj(i,j, isOrientated)) 
              out.append("1   ");
            else 
              out.append("0   ");
          }
          out.append('\n');
         }
         return out.toString(); 
    }
	
	private boolean isAdj (int i , int j, boolean isOrientated) {
		
		for (int k = 0 ; k < edges.size() ; k++) {
			if (edges.get(k).getLeftVertex().equals(vertexes.get(i))) {
				if (edges.get(k).getRightVertex().equals(vertexes.get(j))) {
					return true;
				}
			}
			
			if (!isOrientated) {
				if (edges.get(k).getRightVertex().equals(vertexes.get(i))) {
					if (edges.get(k).getLeftVertex().equals(vertexes.get(j))) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	String sinal = "-";
	public String getMatrizInc(boolean isOrientated) {
		StringBuffer out = new StringBuffer();
		
		out.append("--> Matriz de Incidência: \n");
		out.append("\n");
		   
		out.append("\t     ");
		for (int i = 0 ; i < edges.size() ; i++) {
			out.append(edges.get(i).getWeight().toString()+"   ");
		}
		out.append("\n");
		
		for ( int i=0; i < grauGraph(); i++ ) { out.append("\t" + vertexes.get(i).getInf().toString() +":   ");
          for ( int j=0; j < edges.size(); j++ ) {
            if (isInc(i,j, isOrientated)) {
            	out.append(sinal);
            }
            else 
              out.append("0   ");
          }
          out.append('\n');
         }
		
		return out.toString(); 
	}
	
	private boolean isInc(int i, int j, boolean isOrientated) {
		
		if (vertexes.get(i).equals(edges.get(j).getLeftVertex())) {
			sinal = "1   ";
			return true;
		}
		
		if (vertexes.get(i).equals(edges.get(j).getRightVertex())) {
			if(isOrientated) {
				sinal = "-1  ";
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasIncEdges(Vertex v) {
		
			for (int j = 0 ; j < edges.size() ; j++) {
				if (v.equals(edges.get(j).getRightVertex())) {
					return false;
				}
		}
		return true;
	}
	
	public boolean isVertex(Vertex v) {
		
		for (int i = 0 ; i < vertexes.size() ; i++) {
			if (vertexes.get(i).equals(v)) return true;
		}
		
		return false;
	}
	
	public boolean isEdge(Edge e) {
		
		for (int i = 0 ; i < edges.size() ; i++) {
			if (edges.get(i).equals(e)) return true;
		}
		
		return false;
	}
	
	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(List<Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
}
