package core_engine;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import misc.*;

@SuppressWarnings({"serial"})
public class GUI_Manager extends JPanel implements ActionListener, Runnable {
	
	private boolean isPlanting = false, shovel_clicked = false, clicked = false, insufficientSunWarning = false, gridOccupiedWarning = false;
	private boolean isExcavating = false;
	private Font mc;
	private int world_delay, cur_seed = 25, pack_location_y = 115;
	
	private Timer warn1, warn2;
	private RenderingMethods rm = new RenderingMethods();
	private GraphicsManager gm = new GraphicsManager();
	private Thread updater;
	private String lblSeed;
//Seed packs
	private ArrayList<SeedPack> packs = new ArrayList<SeedPack>();
	
//seed stat no.
	private JLabel lblSeedNo = new JLabel("");

//Shovel Button
	private JButton shovel;
	
//Loading bar
	
	
	public GUI_Manager(int i, int j)
	{
		super();
			setBounds(0, 0, 1280, 720);
			setOpaque(false);
			setLayout(null);
			this.world_delay = i;
			this.cur_seed = j;
			setCurrentSeed(cur_seed);
			
		initialWarnings();
		initialPlantSeedPacks();
		initialShovel();
		initialSeedNo();
		
		
		start();
	}
	
	@Override
	public void run() 
	{
		while (true)
		{
			updateGUI();
			
			try
			{
				Thread.sleep(world_delay);
			}
			
			catch (InterruptedException e) {}
		}
	}
	
	public void initialWarnings()
	{
		ActionListener insufficientSunWarn_end = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					insufficientSunWarning = false;
					warn1.stop();
				}
			}
		;
		
		ActionListener gridOccupiedWarn_end = new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
				{
					gridOccupiedWarning = false;
					warn2.stop();
				}
			}
		;
	
		warn1 = new Timer(3500, insufficientSunWarn_end);
		warn2 = new Timer(3500, gridOccupiedWarn_end);
	}
	
	public void warn1_start()
	{
		insufficientSunWarning = true;
		warn1.start();
	}
	
	public void warn2_start()
	{
		gridOccupiedWarning = true;
		warn2.start();
	}
	
	public void initialSeedNo()
	{
		setupFont();
		lblSeedNo.setFont(mc);
		lblSeedNo.setHorizontalAlignment(JLabel.CENTER);
		lblSeedNo.setVerticalAlignment(JLabel.CENTER);
		lblSeedNo.setText(lblSeed);
		lblSeedNo.setLocation(80, 13);
		lblSeedNo.setSize(75, 75);
		add(lblSeedNo);
	}
	
	public void initialShovel()
	{
		shovel = new JButton(gm.retrieveGraphics_GUI_ShovelButton(false));
		shovel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (shovel_clicked == false)
					{
						shovel_clicked = true;
						setExcavating(true);
						setPlanting(false);
						changeShovelButtonColor();
						clicked = false;
					}
					
					else
					{
						shovel_clicked = false;
						setExcavating(false);
						changeShovelButtonColor();
					}
					
					refreshAvailability();
				}
			}
		);
		
		shovel.setSize(75, 75);
		shovel.setHorizontalAlignment(JLabel.CENTER);
		shovel.setVerticalAlignment(JLabel.CENTER);
		shovel.setLocation(1197, 615);
		add(shovel);
	}
	
	public void changeShovelButtonColor()
	{
		if (isExcavating() == true) 
		{
			shovel.setIcon(gm.retrieveGraphics_GUI_ShovelButton(true));
		}
			
		else
		{
			shovel.setIcon(gm.retrieveGraphics_GUI_ShovelButton(false));
		}
		
		repaint();
	}
	
	public void initialPlantSeedPacks()
	{
		SeedPack sunflower = new SeedPack(pack_location_y, SeedPack.pack.sunflower, 50, 5);
			sunflower.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (clicked == true)
						{
							setPlanting(false); 
							sunflower.deselected(); 
							clicked = false;
						}
						
						else
							
						{
							
							clicked = true;
							setExcavating(false);
							setPlanting(true);
							sunflower.selected();
						}

						refreshAvailability();
					}
				}
			);
			add(sunflower);
			pack_location_y += 65;
		
		SeedPack peashooter = new SeedPack(pack_location_y, SeedPack.pack.peashooter, 100, 5);
			peashooter.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (clicked == true)
						{
							setPlanting(false); 
							peashooter.deselected(); 
							clicked = false;
						}
						
						else
							
						{
							clicked = true; 
							setExcavating(false);
							setPlanting(true); 
							peashooter.selected();  
						}

						refreshAvailability();
					}
				}
			);
			add(peashooter);
			pack_location_y += 115;
			
		packs.add(sunflower);
		packs.add(peashooter);
	}
	
	public void refreshAvailability()
	{
		for (SeedPack p: packs)
		{
			if (clicked == true && p.isSelected() == false && p.getAvailability() == true && p.isAvailable() == true)
			{
				p.setAvailability(false);
				p.setEnabled(false);
			}
			
			else if (clicked == false && p.getAvailability() == false)
			{
				p.setAvailability(true);
				p.setEnabled(true);
			}
		}
		
		if (isExcavating == false)
		{
			changeShovelButtonColor();
		}
		repaint();
	}
	
	public void setupFont()
	{
		try 
		{
//create the font to use. Specify the size!
		    mc = Font.createFont(Font.TRUETYPE_FONT, new File("assets\\misc\\Minecraftia.ttf")).deriveFont(24f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets\\misc\\Minecraftia.ttf")));
		} 
		
		catch (IOException e) { e.printStackTrace(); } 
		catch (FontFormatException e) { e.printStackTrace(); }
	}
	
	public void start()
	{
		updater = new Thread(this, "2-GUIHandler");
			updater.start();
	}
	
	public void updateGUI()
	{
		lblSeedNo.setText(lblSeed);
		repaint();
	}
	
	public void setCurrentSeed(int i)
	{
		this.cur_seed = i;
		this.lblSeed = "" + this.cur_seed;
	}
	
	public ArrayList<SeedPack> getSeedPacks()
	{
		return this.packs;
	}
	
	public void updateSunSeedNaturally(int y)
	{
		this.cur_seed += y;
		this.lblSeed = "" + this.cur_seed;
		repaint();
	}
	
	public void updateSunSeedUser(int y)
	{
		this.cur_seed -= y;
		this.lblSeed = "" + this.cur_seed;
		repaint();
	}
	
	public void resetPacks()
	{
		setPlanting(false);
		
		for (SeedPack p: packs)
		{
			if (p.isSelected() == true)
			{
				p.deselected();
			}
		}
		
		clicked = false;
		refreshAvailability();
	}

	public boolean isPlanting()
	{
		return this.isPlanting;
	}
	
	public boolean isExcavating()
	{
		return this.isExcavating;
	}

	public void setPlanting(boolean i) 
	{
		this.isPlanting = i;
	}
	
	public void setExcavating(boolean i)
	{
		this.isExcavating = i;
	}
	
	public void resetShovelClick()
	{
		this.shovel_clicked = false;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		rm.gr_gui_seedStatus(g, 5, 5);
		
		if (insufficientSunWarning == true)
		{
			rm.gr_gui_insufficientSunWarning(g, 315, 500);
		}
		
		if (gridOccupiedWarning == true)
		{
			rm.gr_gui_gridOccupiedWarning(g, 315, 500);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}
