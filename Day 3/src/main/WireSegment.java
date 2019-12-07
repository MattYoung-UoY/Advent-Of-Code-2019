package main;

public class WireSegment {

	private Point start, end;

	public WireSegment(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}
	
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
	
}
