package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int[] input;

	private static final int WIDTH = 25, HEIGHT = 6;

	private static List<int[]> layers;

	public static void main(String[] args) {
		input = getInputs();
		layers = getLayers(input, WIDTH, HEIGHT);

		// Part 1
		{
			int[] layerFewestZeros = fewestZeros(layers);

			int ones = 0, twos = 0;

			for (int num : layerFewestZeros)
				if (num == 1)
					ones++;
				else if (num == 2)
					twos++;

			System.out.println(ones * twos);
		}

		// Part 2
		{
			int[] image = new int[WIDTH * HEIGHT];
			for(int i = 0; i < image.length; i++) image[i] = 2;
			
			for(int[] layer: layers) {
				for(int j = 0; j < image.length; j++) {
					if(image[j] == 2) image[j] = layer[j];
				}
			}
			
			printLayer(image);
		}
	}

	private static void printLayer(int[] layer) {
		System.out.println("--------------------------------------------------------------------------");
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				System.out.print(layer[(i * WIDTH) + j] + ",");
			}
			System.out.println();
		}
	}
	
	private static int[] fewestZeros(List<int[]> layers) {
		int[] res = layers.get(0);

		int currentZeros = 0;
		for (int num : res)
			if (num == 0)
				currentZeros++;

		for (int[] layer : layers) {
			int zeros = 0;
			for (int num : layer)
				if (num == 0)
					zeros++;
			if (zeros < currentZeros) {
				currentZeros = zeros;
				res = layer;
			}
		}

		return res;
	}

	private static List<int[]> getLayers(int[] inputs, int width, int height) {
		List<int[]> res = new ArrayList<int[]>();

		int layerSize = width * height;
		int layers = inputs.length / layerSize;

		int[] currentLayer = new int[layerSize];
		for (int i = 0; i < layers; i++) {
			for (int j = 0; j < layerSize; j++) {
				currentLayer[j] = inputs[(i * layerSize) + j];
			}
			res.add(currentLayer);
			currentLayer = new int[layerSize];
		}

		return res;
	}

	private static int[] getInputs() {
		int[] res;

		String line = null;

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("src/main/input.txt"))));
			line = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		char[] intChars = line.toCharArray();

		res = new int[intChars.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(String.valueOf(intChars[i]));
		}

		return res;
	}

}
