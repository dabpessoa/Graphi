package br.unifor.run;

import java.util.List;

import unifor.br.graph.*;
/**
 * 
 * MAKE-SET(x): Cria a árvore apenas com a raiz.
 * FIND-SET(x): Segui-se o caminho da árvore até encontrar a raiz e a retorna.
 * UNION(x,y): Faz a raiz de uma árvore apontar para outra.
 * 
 * Classe que implementa as três operações básicas
 * de árvores disjuntas
 * 
 * Neste Exemplo estou usando uma API de Grafo
 * criada por mim em um trabalho antigo da Faculdade.
 * Porém imagino que a mais ideal seria uma API de Árvore
 * propriamente dita.
 * 
 * @author Diego Augusto
 *
 */
public class Set {
	private Graph graph;
	
	public Set() {
		graph = new Graph();
	}
	
	/**
	 * Método referente ao MAKE-SET(x), que cria
	 * uma árvore (representada por um grafo) apenas
	 * com a raiz (representado por um único vértice).
	 * 
	 * @param o
	 */
	public void makeTreeSet(Object o) {
		
		/*
		 *  Cria o Vértice com o objeto "o" passado como parâmetro
		 *  armazenado nele.
		 */
		Vertex v1 = new Vertex();
		v1.setInf(o);	
		
		/*
		 * Insere o vértice e a aresta no grafo.
		 */
		graph.insertVertex(v1);
		
	}
	
	/**
	 * 
	 * Detecta a qual das árvores disjuntas
	 * o parâmetro passado pertence e ao encontrar
	 * tal árvore a percorre até encontrar
	 * sua raiz da qual será retornada.
	 * 
	 * @param o
	 */
	public Object findTreeSet(Object o) {
		
		
		if (graph.isVertex(new Vertex(o))) {
			List<Edge> edges = graph.getEdges();
			
			for ( int i = 0 ; i < edges.size() ; i++) {
				if (edges.get(i).getRightVertex().equals(new Vertex(o))) {
					findTreeSet(edges.get(i).getRightVertex());
				} else return o;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * Método referente ao UNION(x,y), que faz
	 * a união dos conjuntos criados no MAKE-SET(x).
	 * Fazendo com que a raiz de uma árvore aponte 
	 * para outra, ou seja, criam-se as aresta do grafo
	 * através da ligação das árvores disjuntas.
	 * 
	 * @param o1
	 * @param o2
	 */
	public boolean unionTreeSet(Object o1, Object o2) {
		
		/*
		 * Este primeiro "IF" testa se os objetos
		 * passados como parâmetro existem no grafo,
		 * ou seja, se são árvores disjuntas, para só
		 * então fazer a união.
		 */
		if (graph.isVertex(new Vertex(o1)) && graph.isVertex(new Vertex(o2))) {
			
			/*
			 * Ao fazer a união, pega-se o representante da primeira
			 * árvore disjunta e o liga com o representante de outra
			 * árvore disjunta. O representante da segunda árvore
			 * tornar-se-á o novo representante da nova árvore gerada.
			 * Sendo assim este segundo "IF" testa se o objeto "o2" já tem
			 * alguma aresta incidente à ele. Pois se tiver este não
			 * poderá mais receber nenhuma ligação, caso contrário
			 * este grafo não seria mais uma árvore.
			 * 
			 * Se o resultado do teste for verdadeiro, criar-se-á então a 
			 * aresta que liga os dois parâmetros passados, aresta esta da qual, 
			 * em seguida, será inserida no grafo.
			 */
			if (graph.hasIncEdges(new Vertex(o2))) {
				
				Edge e = new Edge();
				e.setLeftVertex(new Vertex(o1));
				e.setRightVertex(new Vertex(o2));
				
				graph.insertEdge(e);
				
			}
			
		} 
		
		return false;
	}
	
}
