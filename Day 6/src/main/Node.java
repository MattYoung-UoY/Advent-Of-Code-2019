package main;

import java.util.ArrayList;
import java.util.List;

public class Node<T>{

	private T node;
	private List<Node<T>> subTrees;
	private int depth = 0;
	
	public Node(T node, Node<T> parent){
		this.node = node;
		subTrees = new ArrayList<Node<T>>();
		if(parent != null) depth = parent.getDepth() + 1;
	}
	
	public List<T> getPathTo(T node){
		List<T> res = new ArrayList<T>();
		if(this.node.equals(node)) {
			res.add(this.node);
			return res;
		}else if(!subTrees.isEmpty()){
			for(Node<T> subTree: subTrees) {
				List<T> pathTo = subTree.getPathTo(node);
				if(pathTo != null) {
					res = pathTo;
					res.add(this.node);
					return res;
				}
			}
		}else {
			return null;
		}
		return null;
	}
	
	
	
	
	public void addSubTree(Node<T> tree) {
		subTrees.add(tree);
	}
	
	public int sumDepths() {
		int res = getDepth();
		for(Node<T> subTree: subTrees) {
			res += subTree.sumDepths();
		}
		return res;
	}
	
	public int depth(T node) {
		if(this.node == node) {
			return 0;
		}else {
			int depth = -1;
			for(Node<T> subTree: subTrees) {
				int subTreeDepth = subTree.depth(node);
				if(subTreeDepth != -1) depth = subTreeDepth;
			}
			return depth + 1;
		}
	}
	
	public List<Node<T>> getSubTrees(){
		return subTrees;
	}
	
	public T getNode() {
		return node;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		String res = (String) node;
		if(!subTrees.isEmpty()) {
			res += ":[";
			for(Node<T> subTree: subTrees) {
				res += subTree + ", ";
			}
			res += "]";
		}
		return res;
	}
	
}
