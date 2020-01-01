package core_engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Credits extends JPanel{
	
	private Image i = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\credits.png");

	public Credits()
	{
		super();
			setLayout(null);
			setBounds(0, 0, 1280, 720);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(i, 0, 0, null);
		repaint();
	}
}
