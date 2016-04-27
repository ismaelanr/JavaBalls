import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;

public class Ball implements Runnable 
{
	private static final SecureRandom gen = new SecureRandom(); //Generator for random speed.

	private int xCor = 0, yCor = 0,
			deltaX = gen.nextInt(9) + 1, deltaY = gen.nextInt(9) + 1,
			width = 20, height = 20,
			thread;

			Container p;	

	public Ball(int x, int y,BallPanel b,int t)
	{
		p = b;
		this.setX(x);
		this.setY(y);
		this.setThread(t);

	}

	public int getX()
	{
		return xCor;
	}

	public void setX(int x)
	{
		xCor = x;
	}

	public int getY()
	{
		return yCor;
	}

	public void setY(int y)
	{
		yCor = y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setDeltaX(int x)
	{
		deltaX = x;
	}

	public void setDeltaY(int y)
	{
		deltaY = y;
	}

	public void setThread(int t)
	{
		thread = t;
	}
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(60);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			xCor = xCor + deltaX;
			yCor = yCor + deltaY;
			if((xCor + 20)>800)
				deltaX = -deltaX;
			if((yCor +20)>590)
				deltaY = -deltaY;
			if(xCor < 0)
				deltaX = -deltaX;
			if(yCor < 0)
				deltaY = -deltaY;
			p.repaint();

		}

	}

}