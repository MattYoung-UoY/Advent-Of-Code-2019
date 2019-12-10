package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static int stationX = 22, stationY = 28;
	
	public static void main(String[] args) {
		char[][] input = getInputs("src/main/input.txt");

		List<Asteroid> asteroids = new ArrayList<Asteroid>();

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {

				if (Character.valueOf(input[i][j]).equals('#')) {
					asteroids.add(new Asteroid(j, i));
				}
			}
		}
		
		int maxSeen = 0;
		Asteroid bestLOS = new Asteroid(-1, -1);
		
		for(Asteroid asteroid: asteroids) {
			List<Float> anglesSeen = new ArrayList<Float>();
			for(Asteroid viewing: asteroids) {
				double yDiff = asteroid.getY() - viewing.getY();
				double xDiff = asteroid.getX() - viewing.getX();
				float angle = (float) Math.atan2(yDiff, xDiff);
				if(!anglesSeen.contains(angle)) anglesSeen.add(angle);
			}
			if(anglesSeen.size() > maxSeen) {
				bestLOS = asteroid;
				maxSeen = anglesSeen.size();
			}
		}
		
		System.out.println(maxSeen);
		System.out.println(bestLOS);
		
	}

	private static char[][] getInputs(String filepath) {
		char[][] res;

		String text = "";

		try {
			text = new String(Files.readAllBytes(Paths.get(filepath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] rows = text.split("\n");

		res = new char[rows.length][rows[0].length() - 1];

		for (int i = 0; i < res.length; i++) {
			char[] row = rows[i].toCharArray();
			for (int j = 0; j < res[0].length; j++) {
				res[i][j] = row[j];
			}
		}

		return res;
	}

}
