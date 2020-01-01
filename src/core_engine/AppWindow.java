package core_engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import misc.*;

@SuppressWarnings(value = {"serial"})

public class AppWindow extends JFrame {
	
	private AppIcon icon = new AppIcon();
	private DisplayPanel dp;
	private Menu m = new Menu();
	private Credits c = new Credits();
	private JButton play = new JButton();
	private JButton cre = new JButton();
	
	public AppWindow() 
	{
		super();
			
			play.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dp = new DisplayPanel();
						add(dp);
						remove(m);
						remove(play);
					}
				}
			);
			
			cre.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						add(c);
						repaint();
						remove(m);
						remove(play);
						remove(cre);
					}
				}
			);
		play.setSize(372, 86);
		play.setLocation(438, 448);
		cre.setSize(372, 86);
		cre.setLocation(438, 524);
			
			add(play);
			add(cre);
			add(m);
		
			setLayout(null);
			setSize(1280, 720);
			setTitle("Plants vs Zombies in Java");
			setIconImage(icon.getAppIcon().getImage());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLocationRelativeTo(null);
	}

					
	public void showTime()
	{
		setVisible(true);
	}
}
