package main;

import java.util.ArrayList;
import java.util.List;

public class Tree<T>{

	private Tree<T> superTree;
	private T node;
	private List<Tree<T>> subTrees;
	
	public Tree(Tree<T> superTree, T node){
		this.superTree = superTree;
		this.node = node;
		subTrees = new ArrayList<Tree<T>>();
	}
	
	public void addSubTree(Tree<T> tree) {
		subTrees.add(tree);
	}
	
	public int depth() {
		if(superTree == null) {
			return 0;
		}else {
			return superTree.depth() + 1;
		}
	}
	
	public List<Tree<T>> getSubTrees(){
		return subTrees;
	}
	
	public T getNode() {
		return node;
	}
	
}
