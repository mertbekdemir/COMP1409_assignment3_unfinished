
public class Grader {
	private final int max;
	private int marks;
	
	public Grader(final int m) {
		max = m;
		marks = 0;
	}
	
	public void addMark(final int mark ) {
		marks += mark;
		
	}
	
	public int getMarks() {
		return marks;
	}
	
	public int getMax() {
		return max;
	}
}