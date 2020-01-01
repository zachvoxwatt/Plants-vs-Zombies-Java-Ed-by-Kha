package entities;

import misc.Actions;

public class Lawnkiller extends Generic implements Actions {
	
	public Lawnkiller(int i)
	{
		super();
			setSide(side.LAWNKILLER);
			setLane(i);
			setX(160);
			
			switch (i)
			{
				case 1:
					setY(150);
					break;
				
				case 2:
					setY(260);
					break;
					
				case 3:
					setY(370);
					break;
					
				case 4:
					setY(470);
					break;
					
				case 5:
					setY(580);
					break;
			}
			setVelo(7);
	}
	@Override
	public void move() 
	{
		this.x += this.velo;
	}
	
	@Override
	public void stop()
	{
		this.velo = 0;
	}
}
