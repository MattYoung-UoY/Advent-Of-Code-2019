package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int sum = 0;
	
	public static void main(String[] args) {
		System.out.println(sum(fuelRequirements(inputs())));
	}
	
	public static int sum(List<Integer> in) {
		sum = 0;
		in.forEach(num -> {
			sum += num;
		});
		return sum;
	}
	
	public static List<Integer> fuelRequirements(List<Integer> masses){
		List<Integer> fuel = new ArrayList<Integer>();
		masses.forEach(mass -> fuel.add(moduleFuel(mass)));
		return fuel;
	}
	
	public static List<Integer> inputs() {
		List<Integer> masses = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/input.txt"))));
			String line;
			while((line = br.readLine()) != null) masses.add(Integer.parseInt(line));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return masses;
	}
	
	public static int moduleFuel(int mass) {
		float fuel = mass;
		
		fuel /= 3;
		fuel -= (fuel %= 1);
		fuel -= 2;
		
		if(fuel <= 0) return 0;
		return (int) fuel + moduleFuel((int) fuel);
	}
	
}
