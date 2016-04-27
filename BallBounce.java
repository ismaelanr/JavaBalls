import javax.swing.*;		
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BallBounce
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("The Bounce, Return of the Balls.");
		final BallPanel panel = new BallPanel();
		int threads = 0;


		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
		//System.out.print(frame.getWidth()); Test method for current width.


	}

}




