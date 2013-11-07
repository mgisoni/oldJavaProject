package bowling;

import java.util.ArrayList;

public class Game 
{
	private ArrayList<Frame> frameArray = new ArrayList<Frame>(10);

	public Game()
	{
		for (int i = 0; i < 10;i++)
		{
			frameArray.add(new Frame());
		}
	}
	public void bowlFrame(int frameNumber, int ballCount, int pinsKnockedDown)
	{
		if (ballCount <= 0 ||
				ballCount > 3 ||
				frameNumber <= 0 || 
				frameNumber >10 || 
				pinsKnockedDown < 0 || 
				pinsKnockedDown > 10
				)
			throw new IllegalArgumentException("Invalid bowlFrame() arguments");

		if (ballCount == 1)
			frameArray.get(frameNumber-1).setBallOne(pinsKnockedDown);
		else if (ballCount == 2)
			frameArray.get(frameNumber-1).setBallTwo(pinsKnockedDown);
		else if (ballCount == 3)
			frameArray.get(frameNumber-1).setBallThree(pinsKnockedDown);
		else
			throw new IllegalStateException();


	}

	public int getCurrentScore()
	{
		int currentScore = 0;

		for (int i =0; i<10;i++)
		{			
			//strike case
			if (frameArray.get(i).getBallOne() == 10)
			{
				currentScore += 10;
				currentScore += frameArray.get(i).getBallTwo();
				currentScore += frameArray.get(i).getBallThree();
			}
			//spare case
			if (frameArray.get(i).getBallOne() < 10 && 
					(frameArray.get(i).getBallOne() + frameArray.get(i).getBallTwo() == 10))
			{
				currentScore += 10;				
				currentScore += frameArray.get(i).getBallThree();						
			}
			//open frame case
			if (frameArray.get(i).getBallOne() < 10 && 
					(frameArray.get(i).getBallOne() + frameArray.get(i).getBallTwo() < 10))		
			{
				currentScore += frameArray.get(i).getBallOne();
				currentScore += frameArray.get(i).getBallTwo();
			}
		
		
		}

		return currentScore;
	}
	
	public String printFrames()
	{
		String result = "";
		
		for (int i = 0;i<10;i++)
		{
			result += frameArray.get(i).printFrame();
		}
		
		return result;
	}
	public ArrayList<Frame> getFrameArray() {
		return frameArray;
	}
	public void setScore(ArrayList<Frame> score) {
		this.frameArray = score;
	}
}
