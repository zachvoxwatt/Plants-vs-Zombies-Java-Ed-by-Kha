package misc;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GraphicsManager {
	
//Random graphics
	private Image sunflower = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\hero\\sunflower.gif");
	private Image peashooter_i = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\hero\\peashooter_idle.gif");
	private Image peashooter_a = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\hero\\peashooter_active.gif");
	private Image lk = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\lawnkiller\\lawnkiller.png");
	private Image nor_z_w = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\hostile\\zombie.gif");
	private Image nor_z_e = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\hostile\\zombie_eating.gif");
	private Image sun = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\gui\\seed.png");
	private Image sunStat = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\gui\\seed_status.png");
	private Image pea = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\random\\pea.png");
	
//Seed Packs	
	private Icon sunflower_pack = new ImageIcon("assets\\graphics\\static\\packs\\sunflower.png");
	private Icon peashooter_pack = new ImageIcon("assets\\graphics\\static\\packs\\peashooter.png");

//GUI graphics
	private Image insufficientSun_sign = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\warnings\\warning_sun.png");
	private Image occupiedGrid_sign = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\warnings\\occupied_grid.png");
	private Image shovel_cursor = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\dynamic\\random\\shovel_cursor.png");
	private Icon shovel_button1 = new ImageIcon("assets\\graphics\\static\\gui\\shovel_button1.png");
	private Icon shovel_button2 = new ImageIcon("assets\\graphics\\static\\gui\\shovel_button2.png");

//Loading bars
	private Image load5 = Toolkit.getDefaultToolkit().createImage("assets\\graphics\\static\\recharge\\5.gif");
	
//Random graphics
	public Image retrieveGraphics_Pea()
	{
		return this.pea;
	}
	
	public Image retrieveGraphics_Sunflower()
	{
		return this.sunflower;
	}
	
	public Image retrieveGraphics_PeashooterIdle()
	{
		return this.peashooter_i;
	}
	
	public Image retrieveGraphics_PeashooterActive()
	{
		return this.peashooter_a;
	}
	
	public Image retrieveGraphics_ZombieWalking()
	{
		return this.nor_z_w;
	}
	
	public Image retrieveGraphics_ZombieEating()
	{
		return this.nor_z_e;
	}
	
	public Image retrieveGraphics_Lawnkiller()
	{
		return this.lk;
	}
	
	public Image retrieveGraphics_Sun()
	{
		return this.sun;
	}

//Seed Packs
	public Icon retrieveGraphics_Pack_Sunflower()
	{
		return this.sunflower_pack;
	}
	
	public Icon retrieveGraphics_Pack_Peashooter()
	{
		return this.peashooter_pack;
	}

//Loading bar
	public Image retrieveGraphics_load_5()
	{
		return this.load5;
	}
	
//GUI
	public Image retrieveGraphics_GUI_WarningSun()
	{
		return this.insufficientSun_sign;
	}
	
	public Image retrieveGraphics_SeedStatus()
	{
		return this.sunStat;
	}
	
	public Image retrieveGraphics_GUI_OccupiedGridWarning()
	{
		return this.occupiedGrid_sign;
	}
	
	public Icon retrieveGraphics_GUI_ShovelButton(boolean i)
	{
		if (i == true)
			return this.shovel_button2;
		else
			return this.shovel_button1;
	}
	
	public Image retrieveGraphics_GUI_ShovelCursor()
	{
		return this.shovel_cursor;
	}
}
