package core_engine;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import misc.WorldBackground;

@SuppressWarnings("serial")
public class DisplayPanel extends JPanel implements Runnable {
	
	private WorldBackground wB = new WorldBackground();
	private World w = new World();
	private Thread dpu;
	private JLayeredPane lmg = new JLayeredPane();
	
	public DisplayPanel()
	{
		super();
			setLayout(null);
			setBounds(0, 0, 1280, 720);
		initialPanes();
		start();
	}
	
	public void initialPanes()
	{
		//initialize the layered pane		
				lmg.setLayout(null);
				lmg.setBounds(0, 0, 1280, 720);
				
		//adding child panes
				//World background pane
					lmg.add(wB, new Integer(0));
				//World pane
					lmg.add(w, new Integer(1));
					
		//DisplayPanel adds the layered pane which holds all child pane
				add(lmg);
	}

	@Override
	public void run()
	{
		while (true)
		{
			updateDisplay();
			
			try
			{
				Thread.sleep(w.getWorldDelay());
			}
			
			catch (InterruptedException e) {}
		}
	}
	
	public void start()
	{
		dpu = new Thread(this, "1-DisplayHandler");
			dpu.start();
	}
	
	public void updateDisplay()
	{
		
	}
}
