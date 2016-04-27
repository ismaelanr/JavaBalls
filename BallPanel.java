import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Random;


public class BallPanel extends JPanel
{
	int xCor, yCor;
	Ball[] balls = new Ball[20];
	int threads = 0;
	BallPanel b = this;
	ExecutorService execService = Executors.newCachedThreadPool();
	Random rand = new Random();


	public BallPanel()
	{
		System.out.print("Panel");
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if(threads < 20)
				{

					System.out.println("Here");
					System.out.print("X-Cor: ");
					System.out.println(e.getX());
					System.out.print("Y-Cor: ");
					System.out.println(e.getY());
					balls[threads] = new Ball(e.getX(),e.getX(),b,threads);
					execService.execute(balls[threads]);

					threads+=1;

				}

			}
		});
	}
	
	/*
	public int getThreads()
	{
		return threads;
	}
	*/


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i <= threads - 1; i++)
		{
			if(threads == 1)
				g.setColor(Color.BLUE);
			else
				{
					float r = rand.nextFloat();
					float gG = rand.nextFloat();
					float b = rand.nextFloat();
					g.setColor(new Color(r,gG,b));
				}
			g.drawOval(balls[i].getX(),balls[i].getY(),20,20);
			g.fillOval(balls[i].getX(),balls[i].getY(),20,20);
		}
	}	

}		