package misc;

import javax.swing.ImageIcon;

public class AppIcon {
	
	private ImageIcon icon;
	
	public AppIcon()
	{
		icon = new ImageIcon("assets\\graphics\\static\\icon.png");
	}
	public ImageIcon getAppIcon()
	{
		return this.icon;
	}
}
