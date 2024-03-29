package main;

public class Point {

	private int x, y, distance;
	
	public Point(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ": " + distance + ")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
