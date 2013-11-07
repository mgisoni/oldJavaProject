package validationTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bowling.Frame;
import bowling.Game;

public class BowlingTestCases 
{

	/**
	 * Test Game() default constructor to verify expected initialization.
	 */
	@Test
	public void Game_DefaultConstructorTest() 
	{
		Game g = new Game();
		ArrayList<Frame> frameArray = g.getFrameArray();

		if (frameArray.size() == 10)
		{
			for (Frame f : frameArray)
			{
				assertTrue(f.getBallOne() == 0);
				assertTrue(f.getBallTwo() == 0);
				assertTrue(f.getBallThree() == 0);
			}
		}
		else
			fail("Game default constructor faliure.");
	}

	@Test
	public void Game_bowlFrame_invalidInputTest()
	{
		Game g = new Game();

		try
		{
			g.bowlFrame(-1, -1, -1);
		}
		catch (IllegalArgumentException e)
		{
			assertTrue(e.getMessage().equals("Invalid bowlFrame() arguments"));			
		}
	}

	@Test
	public void testPercfectGame()
	{
		Game perfectGame = new Game();

		for (int i=1;i<11;i++)
		{
			perfectGame.bowlFrame(i, 1, 10);
			perfectGame.bowlFrame(i, 2, 10);
			perfectGame.bowlFrame(i, 3, 10);
		}

		assertTrue(perfectGame.getCurrentScore() == 300);		
	}

	@Test
	public void testPerfectSpareGame()
	{
		Game g = new Game();

		//bowl 9 frames as 9 1 spare
		for (int i=1;i<10;i++)
		{
			g.bowlFrame(i, 1, 9);
			g.bowlFrame(i, 2, 1);
		}

		//bowl frame 10 as 9 1 9
		g.bowlFrame(10, 1, 9);
		g.bowlFrame(10,2, 1);
		g.bowlFrame(10, 3, 9);

		//debug text output for the frames played
		System.out.println(g.printFrames());
		//debug text output for current score
		System.out.println(g.getCurrentScore());

		assertTrue(g.getCurrentScore() == 190);
	}

	@Test
	public void testOpenFrameGame()
	{
		Game g = new Game();

		//bowl frames as per the last row on the assignment sheet

		//frame 1
		g.bowlFrame(1,1,9);
		g.bowlFrame(1, 2, 1);
		g.bowlFrame(1, 3, 0);

		//frame 2
		g.bowlFrame(2, 1, 0);
		g.bowlFrame(2, 2, 10);
		g.bowlFrame(2, 3, 10);

		//frame 3
		g.bowlFrame(3, 1, 10);
		g.bowlFrame(3, 2, 10);
		g.bowlFrame(3,3,6);

		//frame 4
		g.bowlFrame(4, 1, 10);
		g.bowlFrame(4,2, 6);
		g.bowlFrame(4, 3, 2);

		//frame 5
		g.bowlFrame(5, 1, 6);
		g.bowlFrame(5, 2, 2);

		//frame 6
		g.bowlFrame(6,1,7);
		g.bowlFrame(6, 2, 3);
		g.bowlFrame(6, 3, 8);

		//frame 7
		g.bowlFrame(7, 1, 8);
		g.bowlFrame(7, 2, 2);
		g.bowlFrame(7, 3, 10);

		//frame 8
		g.bowlFrame(8, 1, 10);
		g.bowlFrame(8, 2, 9);
		g.bowlFrame(8, 3, 0);

		//frame 9
		g.bowlFrame(9, 1, 9);
		g.bowlFrame(9, 2, 0);

		//frame 10
		g.bowlFrame(10, 1, 9);
		g.bowlFrame(10, 2, 1);
		g.bowlFrame(10, 3, 10);

		//debug text output for the frames played
		System.out.println(g.printFrames());
		//debug text output for current score
		System.out.println(g.getCurrentScore());

		assertTrue(g.getCurrentScore() == 168);

	}
}
