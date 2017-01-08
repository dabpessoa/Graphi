package br.unifor.run;

import unifor.br.graph.Edge;
import unifor.br.graph.Graph;
import unifor.br.graph.Vertex;

public class GraphTest {
	public static void main( String args[] ) {
		
		// Instanciando uma novo grafo
		Graph g = new Graph();
		
		
		// Vertices
		Vertex v1 = new Vertex();
		v1.setInf("a");
		
		Vertex v2 = new Vertex();
		v2.setInf("b");
		
		Vertex v3 = new Vertex();
		v3.setInf("c");
		
		Vertex v4 = new Vertex();
		v4.setInf("d");
		
		Vertex v5 = new Vertex();
		v5.setInf("e");
		
		
		// Arestas
		Edge e1 = new Edge();
		e1.setLeftVertex(v1);
		e1.setRightVertex(v2);
		e1.setWeight("3");
		
		Edge e2 = new Edge();
		e2.setLeftVertex(v2);
		e2.setRightVertex(v4);
		e2.setWeight("1");
		
		Edge e3 = new Edge();
		e3.setLeftVertex(v5);
		e3.setRightVertex(v1);
		e3.setWeight("9");
		
		Edge e4 = new Edge();
		e4.setLeftVertex(v5);
		e4.setRightVertex(v2);
		e4.setWeight("7");
		
		Edge e5 = new Edge();
		e5.setLeftVertex(v5);
		e5.setRightVertex(v3);
		e5.setWeight("4");
		
		Edge e6 = new Edge();
		e6.setLeftVertex(v5);
		e6.setRightVertex(v4);
		e6.setWeight("3");
		
		Edge e7 = new Edge();
		e7.setLeftVertex(v4);
		e7.setRightVertex(v4);
		e7.setWeight("8");
		
		
		// Atribuindo Vertices e Arestas ao Grafo
		g.insertVertex(v1);
		g.insertVertex(v2);
		g.insertVertex(v3);
		g.insertVertex(v4);
		g.insertVertex(v5);
		
		g.insertEdge(e1);
		g.insertEdge(e2);
		g.insertEdge(e3);
		g.insertEdge(e4);
		g.insertEdge(e5);
		g.insertEdge(e6);
		g.insertEdge(e7);
		
		// Imprimindo Matriz de Adjacencia
		System.out.println(g.getMatrizAdj(true));
		
		// Imprimindo Matriz de Incidência
		System.out.println(g.getMatrizInc(true));
		
		// Imprimir Adjacentes de um vertice específico
		System.out.println("Adjacentes do Vértice 'V5':");
		System.out.println();
		for ( int i = 0 ; i < g.getAdjacents(v5, true).size(); i++) {
			System.out.print(g.getAdjacents(v5, true).get(i).getInf().toString()+", ");
		}
		
		// Imprimindo Lista de Todos os Vértices
		System.out.println();
		System.out.println();
		System.out.println("Vertices: ");
		for (int i = 0 ; i < g.getVertexes().size() ; i++) {
			System.out.print(g.getVertexes().get(i)+", ");
		}
		
		// Imprimindo Lista de Todas as Arestas
		System.out.println();
		System.out.println();
		System.out.println("Arestas: ");
		for (int i = 0 ; i < g.getEdges().size() ; i++) {
			System.out.print(g.getEdges().get(i)+", ");
		}
		
		// Verificando se dois vértices são adjacentes
		System.out.println();
		System.out.println();
		System.out.println("Verificação de Adjacência: ");
		System.out.println("=> 'a' e 'b' são adjacentes: "+g.isAdjacent(v1, v2, false));
		System.out.println("=> 'a' e 'e' são adjacentes (Orientado): "+g.isAdjacent(v1, v5, true));
		System.out.println("=> 'a' e 'e' são adjacentes (Não Orientado): "+g.isAdjacent(v1, v5, false));
	}
}
