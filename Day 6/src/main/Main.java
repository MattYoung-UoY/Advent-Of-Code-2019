package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	Tree<String> tree = new Tree<String>(null, "COM");
	
	public static void main(String[] args) {
		List<String[]> inputs = getInputs();
		
		
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
