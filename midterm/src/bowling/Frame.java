package bowling;

public class Frame 
{
	private int ballOne;
	private int ballTwo;
	private int ballThree;

	public int getBallOne() {
		return ballOne;
	}
	public void setBallOne(int ballOne) {
		this.ballOne = ballOne;
	}
	public int getBallTwo() {
		return ballTwo;
	}
	public void setBallTwo(int ballTwo) {
		this.ballTwo = ballTwo;
	}
	public int getBallThree() {
		return ballThree;
	}
	public void setBallThree(int ballThree) {
		this.ballThree = ballThree;
	}
	public String printFrame()
	{
		String result = "" + ballOne + ", " + ballTwo + ", ";

		if (ballThree != 0)
			result +=  ballThree + " |";
		else
			result += "x |";
		return result;
	}
}
