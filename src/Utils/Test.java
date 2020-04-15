package Utils;

public enum Test {
	
	One(1), Two(2);
	
	private int x;

	/**
	 * @param x
	 */
	private Test(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}

}
