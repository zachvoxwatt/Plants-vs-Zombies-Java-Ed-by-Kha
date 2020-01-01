package misc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

@SuppressWarnings("unused")
public class RenderingMethods {
	
	private GraphicsManager gm = new GraphicsManager();
	private Graphics g;

//General methods
	public void gr_Sun(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_Sun(), (int) x, (int) y, null);
	}
	
	public void gr_Zombie(Graphics g, double x, double y, boolean i)
	{
		if (i == false) g.drawImage(gm.retrieveGraphics_ZombieWalking(), (int) x, (int) y, null);
		
		else g.drawImage(gm.retrieveGraphics_ZombieEating(), (int) x, (int) y, null);
	}
	
	public void gr_Lawnkiller(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_Lawnkiller(), (int) x, (int) y, null);
	}
	
	public void gr_Sunflower(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_Sunflower(), (int) x, (int) y, null);
	}
	
	public void gr_Peashooter(Graphics g, double x, double y, boolean isActive)
	{
		if (isActive == false)
		{
			g.drawImage(gm.retrieveGraphics_PeashooterIdle(), (int) x, (int) y, null);
		}
		else g.drawImage(gm.retrieveGraphics_PeashooterActive(), (int) x, (int) y, null);
	}
	
	public void gr_Pea(Graphics g, int x, int y)
	{
		g.drawImage(gm.retrieveGraphics_Pea(), x, y, null);
	}
	
//Miscellaneous related methods
	public void gr_misc_showGrids(Graphics g, boolean show)
	{
		if (show == true)
		{
			int i = 0;
			g.setColor(Color.RED);
			//draw outer border
			g.drawRect(240, 110, 950, 540);
			
			//draw horizontal lines
			g.drawLine(240, 220, 1190, 220);
			g.drawLine(240, 330, 1190, 330);
			g.drawLine(240, 435, 1190, 435);
			g.drawLine(240, 540, 1190, 540);
			
			//draw vertical lines
			for (i = 240; i <= 1190; i += 95)
			{
				g.drawLine(i, 110, i, 650);
			}
		}
	}
	
//GUI related methods
	public void gr_gui_seedStatus(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_SeedStatus(), (int) x, (int) y, null);
	}
	
	public void gr_gui_insufficientSunWarning(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_GUI_WarningSun(), (int) x, (int) y, null);
	}
	
	public void gr_gui_gridOccupiedWarning(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_GUI_OccupiedGridWarning(), (int) x, (int) y, null);
	}
	
	public void gr_gui_shovelCursor(Graphics g, double x, double y)
	{
		g.drawImage(gm.retrieveGraphics_GUI_ShovelCursor(), (int) x, (int) y, null);
	}
}
