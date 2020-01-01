package entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import misc.Actions;

public class Sunflower extends Generic implements Actions, ActionListener {
	
	private boolean lock1 = false;
	private Timer sunProducer = new Timer(7000, this);
	
	public Sunflower(double x, double y, int k)
	{
		super();
			setGrid(k);
			checkSetLane(k);
			setSide(side.SUPPORTER);
			setPlantType(plantType.sunflower);
			setX(x);
			setY(y);
			setLife(150);
			setPrice(50);
			
		sunProducer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		setSunOut(true);
		
		if (lock1 == false)
		{
			sunProducer.setDelay(24000);
			sunProducer.stop();
			sunProducer.restart();
			lock1 = true;
		}
	}
	
	public void executeFunction()
	{
		this.setSunOut(true);
	}
	
	public boolean getFunctionStatus()
	{
		return this.getSunOut();
	}
	
	@Override
	public void move() {}
	@Override
	public void stop() {}
}
