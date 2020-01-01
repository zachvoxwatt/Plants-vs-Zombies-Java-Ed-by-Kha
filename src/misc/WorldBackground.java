package misc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//This class gives the main Logic class the background information
@SuppressWarnings("serial")
public class WorldBackground extends JPanel {
	
	private Image bg;
	
	public WorldBackground()
	{
		super();
			setBounds(0,0,1280,720);
			setOpaque(false);
		bg = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\background.png");
	}
	
	public Image getBGImage()
	{
		return this.bg;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		repaint();
		g.drawImage(bg, -2, -2, null);
	}
}
