package br.unifor.run;

import java.util.List;

import unifor.br.graph.*;
/**
 * 
 * MAKE-SET(x): Cria a �rvore apenas com a raiz.
 * FIND-SET(x): Segui-se o caminho da �rvore at� encontrar a raiz e a retorna.
 * UNION(x,y): Faz a raiz de uma �rvore apontar para outra.
 * 
 * Classe que implementa as tr�s opera��es b�sicas
 * de �rvores disjuntas
 * 
 * Neste Exemplo estou usando uma API de Grafo
 * criada por mim em um trabalho antigo da Faculdade.
 * Por�m imagino que a mais ideal seria uma API de �rvore
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
	 * M�todo referente ao MAKE-SET(x), que cria
	 * uma �rvore (representada por um grafo) apenas
	 * com a raiz (representado por um �nico v�rtice).
	 * 
	 * @param o
	 */
	public void makeTreeSet(Object o) {
		
		/*
		 *  Cria o V�rtice com o objeto "o" passado como par�metro
		 *  armazenado nele.
		 */
		Vertex v1 = new Vertex();
		v1.setInf(o);	
		
		/*
		 * Insere o v�rtice e a aresta no grafo.
		 */
		graph.insertVertex(v1);
		
	}
	
	/**
	 * 
	 * Detecta a qual das �rvores disjuntas
	 * o par�metro passado pertence e ao encontrar
	 * tal �rvore a percorre at� encontrar
	 * sua raiz da qual ser� retornada.
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
	 * M�todo referente ao UNION(x,y), que faz
	 * a uni�o dos conjuntos criados no MAKE-SET(x).
	 * Fazendo com que a raiz de uma �rvore aponte 
	 * para outra, ou seja, criam-se as aresta do grafo
	 * atrav�s da liga��o das �rvores disjuntas.
	 * 
	 * @param o1
	 * @param o2
	 */
	public boolean unionTreeSet(Object o1, Object o2) {
		
		/*
		 * Este primeiro "IF" testa se os objetos
		 * passados como par�metro existem no grafo,
		 * ou seja, se s�o �rvores disjuntas, para s�
		 * ent�o fazer a uni�o.
		 */
		if (graph.isVertex(new Vertex(o1)) && graph.isVertex(new Vertex(o2))) {
			
			/*
			 * Ao fazer a uni�o, pega-se o representante da primeira
			 * �rvore disjunta e o liga com o representante de outra
			 * �rvore disjunta. O representante da segunda �rvore
			 * tornar-se-� o novo representante da nova �rvore gerada.
			 * Sendo assim este segundo "IF" testa se o objeto "o2" j� tem
			 * alguma aresta incidente � ele. Pois se tiver este n�o
			 * poder� mais receber nenhuma liga��o, caso contr�rio
			 * este grafo n�o seria mais uma �rvore.
			 * 
			 * Se o resultado do teste for verdadeiro, criar-se-� ent�o a 
			 * aresta que liga os dois par�metros passados, aresta esta da qual, 
			 * em seguida, ser� inserida no grafo.
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
