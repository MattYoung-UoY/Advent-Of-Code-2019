package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static Node<String> root;
	private static List<String[]> inputs;
	
	public static void main(String[] args) {
		inputs = getInputs();
		
		root = createTree("COM", null);
		
		//Part 1
		System.out.println(root.sumDepths());
		
		//Part 2
		List<String> myRoute = root.getPathTo("YOU");
		List<String> santaRoute = root.getPathTo("SAN");
		
		String commonNode = "";
		for(String node: myRoute) {
			if(santaRoute.contains(node)) {
				commonNode = node;
				break;
			}
		}

		int depthCommonNode = root.getPathTo(commonNode).size();
		int depthSanta = santaRoute.size();
		int depthMe = myRoute.size();
		
		int res = (depthMe - depthCommonNode) + (depthSanta - depthCommonNode) - 2;
		
		System.out.println(res);
	}
	
	private static Node<String> createTree(String node, Node<String> parent) {
		Node<String> res = new Node<String>(node, parent);
		
		for(String[] pair: inputs) {
			if(pair[0].equals(node)) {
				res.addSubTree(createTree(pair[1], res));
			}
		}
		
		return res;
	}
	
	private static List<String[]> getInputs(){
		List<String[]> res = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/input.txt"))));
			String line;
			while((line = br.readLine()) != null) res.add(line.split("\\)"));
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
