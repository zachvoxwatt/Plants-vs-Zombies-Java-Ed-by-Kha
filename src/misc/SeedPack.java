package misc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SeedPack extends JButton implements ActionListener {
	
	private int pack_w = 115, pack_h = 65, pack_location_x = 23, price = 0, duration, chargetime;
	private boolean isSelected = false, active = false, available = true, isAvailable = true;
	private GraphicsManager gm = new GraphicsManager();
	private Timer t;
	
	public enum pack 
	{ sunflower, peashooter };
	private pack pc;
	
	public SeedPack(int j, pack p, int k, int a)
	{
		super();
			setPrice(k);
			setSize(pack_w, pack_h);
			setLocation(pack_location_x, j);
			setPlant(p);
			this.duration = a * 1000;
		switch (p)
		{
			case sunflower:
				setIcon(gm.retrieveGraphics_Pack_Sunflower());
				setChargetime(5);
				break;
			case peashooter:
				setIcon(gm.retrieveGraphics_Pack_Peashooter());
				setChargetime(5);
				break;
		}
		
		t = new Timer(duration, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.setEnabled(true);
		this.isAvailable = true;
		this.t.stop();
	}
	
	public void usedPack()
	{
		this.isAvailable = false;
		this.setEnabled(false);
		this.t.start();
	}
	
	public void setAvailability(boolean i)
	{
		this.available = i;
	}
	
	public boolean getAvailability()
	{
		return this.available;
	}
	
	public void setActive(boolean i)
	{
		this.active = i;
	}
	
	public boolean getStatus()
	{
		return this.active;
	}
	
	public void selected()
	{
		this.isSelected = true;
	}
	
	public void deselected()
	{
		this.isSelected = false;
	}
	
	public boolean isSelected()
	{
		return this.isSelected; 
	}
	
	public boolean isAvailable() 
	{
		return this.isAvailable;
	}

	public void setAvailable(boolean i)
	{
		this.isAvailable = i;
	}

	public void setPlant(pack p)
	{
		this.pc = p;
	}
	
	public void setPrice(int i)
	{
		this.price = i;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public pack getPlant()
	{
		return this.pc;
	}

	public int getChargetime() 
	{
		return this.chargetime;
	}

	public void setChargetime(int c) 
	{
		this.chargetime = c;
	}
}
