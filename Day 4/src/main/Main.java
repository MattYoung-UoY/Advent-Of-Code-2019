package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	static int start = 356261;
	static int end = 846303;

	public static void main(String[] args) {

		ArrayList<Integer> ints = new ArrayList<Integer>();

		for (int i = start; i < end + 1; i++) {
			if (inOrder(i) && doubles(i)) {
				ints.add(i);
			}
		}

		for(int i: ints) {
			System.out.println(i);
		}
		
		System.out.println(ints.size());
		
	}
	
	private static boolean doub(int i) {
		char[] chars = Integer.toString(i).toCharArray();
		for(int j = 0; j < chars.length-1; j++) {
			if(chars[j] == chars[j+1]) return true;
		}
		return false;
	}

	private static boolean doubles(int i) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		char[] chars = Integer.toString(i).toCharArray();
		for(char item: chars) {
			if(count.containsKey(item)) count.put(item, count.get(item) + 1);
			else count.put(item, 1);
		}
		for(int counter: count.values()) {
			if(counter == 2) return true;
		}
		return false;
	}

	private static boolean inOrder(int i) {
		char[] intChars = Integer.toString(i).toCharArray();
		for (int index = 0; index < intChars.length - 1; index++) {
			if (intChars[index] > intChars[index + 1])
				return false;
		}
		return true;
	}

}
