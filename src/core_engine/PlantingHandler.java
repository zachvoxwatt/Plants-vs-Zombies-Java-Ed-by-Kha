package core_engine;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JPanel;

import entities.*;
import misc.SeedPack;
import misc.SeedPack.pack;

@SuppressWarnings("serial")
public class PlantingHandler extends JPanel implements Runnable {
	
	private Thread ph;
	private int rev_grid, sel_grid, grid, world_delay, grid_x, grid_y, price = 0, i;
	private ArrayList<Generic> plants1; private ArrayList<Generic> plants2; private ArrayList<Generic> plants3;
	private ArrayList<Generic> plants4; private ArrayList<Generic> plants5;
	private ArrayList<SeedPack> sp;
	private boolean[] Grids = new boolean[51];
	
	public PlantingHandler()
	{
		initialGrids();
		start();
	}
	
	@Override
	public void run() 
	{
		while (true)
		{	
			execute();
			try
			{
				Thread.sleep(world_delay);
			}
			
			catch (InterruptedException e) {}
		}
	}
	
	public void start()
	{
		ph = new Thread(this, "8-PlantingHandler");
			ph.start();
	}
	
	public void initialGrids()
	{
		for (i = 0; i < 51; i++)
		{
			Grids[i] = false;
		}
	}
	
	public void checkRemovingGrids(int x, int y)
	{
		//Lane #1
		if (y > 110 && y < 220)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 1; setRemovingGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 2; setRemovingGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 3; setRemovingGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 4; setRemovingGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 5; setRemovingGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 6; setRemovingGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 7; setRemovingGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 8; setRemovingGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 9; setRemovingGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 10; setRemovingGrid(grid);	}
		}
			
		//Lane #2
		if (y > 220 && y < 330)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 11; setRemovingGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 12; setRemovingGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 13; setRemovingGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 14; setRemovingGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 15; setRemovingGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 16; setRemovingGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 17; setRemovingGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 18; setRemovingGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 19; setRemovingGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 20; setRemovingGrid(grid);	}
		}
			
		//Lane #3
		if (y > 330 && y < 435)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 21; setRemovingGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 22; setRemovingGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 23; setRemovingGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 24; setRemovingGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 25; setRemovingGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 26; setRemovingGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 27; setRemovingGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 28; setRemovingGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 29; setRemovingGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 30; setRemovingGrid(grid);	}
		}
			
		//Lane #4
		if (y > 435 && y < 540)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 31; setRemovingGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 32; setRemovingGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 33; setRemovingGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 34; setRemovingGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 35; setRemovingGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 36; setRemovingGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 37; setRemovingGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 38; setRemovingGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 39; setRemovingGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 40; setRemovingGrid(grid);	}
		}
					
		//Lane #5
		if (y > 540 && y < 645)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 41; setRemovingGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 42; setRemovingGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 43; setRemovingGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 44; setRemovingGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 45; setRemovingGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 46; setRemovingGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 47; setRemovingGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 48; setRemovingGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 49; setRemovingGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 50; setRemovingGrid(grid);	}	
		}
	}
	
	public void checkValidGrids(int x, int y)
	{
		//Lane #1
		if (y > 110 && y < 220)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 1; setSelectedGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 2; setSelectedGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 3; setSelectedGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 4; setSelectedGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 5; setSelectedGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 6; setSelectedGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 7; setSelectedGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 8; setSelectedGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 9; setSelectedGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 10; setSelectedGrid(grid);	}
		}
			
		//Lane #2
		if (y > 220 && y < 330)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 11; setSelectedGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 12; setSelectedGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 13; setSelectedGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 14; setSelectedGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 15; setSelectedGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 16; setSelectedGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 17; setSelectedGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 18; setSelectedGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 19; setSelectedGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 20; setSelectedGrid(grid);	}
		}
			
		//Lane #3
		if (y > 330 && y < 435)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 21; setSelectedGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 22; setSelectedGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 23; setSelectedGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 24; setSelectedGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 25; setSelectedGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 26; setSelectedGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 27; setSelectedGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 28; setSelectedGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 29; setSelectedGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 30; setSelectedGrid(grid);	}
		}
			
		//Lane #4
		if (y > 435 && y < 540)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 31; setSelectedGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 32; setSelectedGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 33; setSelectedGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 34; setSelectedGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 35; setSelectedGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 36; setSelectedGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 37; setSelectedGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 38; setSelectedGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 39; setSelectedGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 40; setSelectedGrid(grid);	}
		}
					
		//Lane #5
		if (y > 540 && y < 645)
		{
			if ( x > 240 && x < 335 ) 	{	grid = 41; setSelectedGrid(grid);	}
			if ( x > 335 && x < 430 ) 	{	grid = 42; setSelectedGrid(grid);	}
			if ( x > 430 && x < 525 ) 	{	grid = 43; setSelectedGrid(grid);	}
			if ( x > 525 && x < 620 ) 	{ 	grid = 44; setSelectedGrid(grid);	}
			if ( x > 620 && x < 715 ) 	{ 	grid = 45; setSelectedGrid(grid);	}
			if ( x > 715 && x < 810 ) 	{ 	grid = 46; setSelectedGrid(grid);	}
			if ( x > 810 && x < 905 ) 	{ 	grid = 47; setSelectedGrid(grid);	}
			if ( x > 905 && x < 1000 ) 	{ 	grid = 48; setSelectedGrid(grid);	}
			if ( x > 1000 && x < 1095 ) { 	grid = 49; setSelectedGrid(grid);	}
			if ( x > 1095 && x < 1190 ) { 	grid = 50; setSelectedGrid(grid);	}	
		}
	}
	
	public void setPlantingGrid()
	{
		switch (grid)
		{
			//Lane #1
			case 1:
				grid_x = 260;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 2:
				grid_x = 355;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 3:
				grid_x = 450;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 4:
				grid_x = 545;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 5:
				grid_x = 640;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 6:
				grid_x = 735;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 7:
				grid_x = 830;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 8:
				grid_x = 925;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 9:
				grid_x = 1020;
				grid_y = 110;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 10:
				grid_x = 1115;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			//Lane #2
			case 11:
				grid_x = 260;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 12:
				grid_x = 355;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 13:
				grid_x = 450;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 14:
				grid_x = 545;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 15:
				grid_x = 640;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 16:
				grid_x = 735;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 17:
				grid_x = 830;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 18:
				grid_x = 925;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 19:
				grid_x = 1020;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 20:
				grid_x = 1115;
				grid_y = 220;
				setGrid(grid, true); sel_grid = grid;
				break;
			
			//Lane #3
			case 21:
				grid_x = 260;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 22:
				grid_x = 355;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 23:
				grid_x = 450;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 24:
				grid_x = 545;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 25:
				grid_x = 640;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 26:
				grid_x = 735;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 27:
				grid_x = 830;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 28:
				grid_x = 925;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 29:
				grid_x = 1020;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 30:
				grid_x = 1115;
				grid_y = 330;
				setGrid(grid, true); sel_grid = grid;
				break;
			
			//Lane #4
			case 31:
				grid_x = 260;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 32:
				grid_x = 355;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 33:
				grid_x = 450;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 34:
				grid_x = 545;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 35:
				grid_x = 640;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 36:
				grid_x = 735;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 37:
				grid_x = 830;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 38:
				grid_x = 925;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 39:
				grid_x = 1020;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 40:
				grid_x = 1115;
				grid_y = 435;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			//Lane #5
			case 41:
				grid_x = 260;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 42:
				grid_x = 355;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 43:
				grid_x = 450;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 44:
				grid_x = 545;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
	
			case 45:
				grid_x = 640;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 46:
				grid_x = 735;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 47:
				grid_x = 830;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 48:
				grid_x = 925;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 49:
				grid_x = 1020;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
				
			case 50:
				grid_x = 1115;
				grid_y = 540;
				setGrid(grid, true); sel_grid = grid;
				break;
		}
	}
	
	public void setRemovingGrid()
	{
		switch (grid)
		{
			//Lane #1
			case 1:
				grid_x = 260;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 2:
				grid_x = 355;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 3:
				grid_x = 450;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 4:
				grid_x = 545;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 5:
				grid_x = 640;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 6:
				grid_x = 735;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 7:
				grid_x = 830;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 8:
				grid_x = 925;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 9:
				grid_x = 1020;
				grid_y = 110;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 10:
				grid_x = 1115;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			//Lane #2
			case 11:
				grid_x = 260;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 12:
				grid_x = 355;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 13:
				grid_x = 450;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 14:
				grid_x = 545;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 15:
				grid_x = 640;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 16:
				grid_x = 735;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 17:
				grid_x = 830;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 18:
				grid_x = 925;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 19:
				grid_x = 1020;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 20:
				grid_x = 1115;
				grid_y = 220;
				setGrid(grid, false); rev_grid = grid;
				break;
			
			//Lane #3
			case 21:
				grid_x = 260;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 22:
				grid_x = 355;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 23:
				grid_x = 450;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 24:
				grid_x = 545;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 25:
				grid_x = 640;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 26:
				grid_x = 735;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 27:
				grid_x = 830;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 28:
				grid_x = 925;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 29:
				grid_x = 1020;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 30:
				grid_x = 1115;
				grid_y = 330;
				setGrid(grid, false); rev_grid = grid;
				break;
			
			//Lane #4
			case 31:
				grid_x = 260;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 32:
				grid_x = 355;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 33:
				grid_x = 450;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 34:
				grid_x = 545;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 35:
				grid_x = 640;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 36:
				grid_x = 735;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 37:
				grid_x = 830;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 38:
				grid_x = 925;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 39:
				grid_x = 1020;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 40:
				grid_x = 1115;
				grid_y = 435;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			//Lane #5
			case 41:
				grid_x = 260;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 42:
				grid_x = 355;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 43:
				grid_x = 450;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 44:
				grid_x = 545;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
	
			case 45:
				grid_x = 640;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 46:
				grid_x = 735;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 47:
				grid_x = 830;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 48:
				grid_x = 925;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 49:
				grid_x = 1020;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
				
			case 50:
				grid_x = 1115;
				grid_y = 540;
				setGrid(grid, false); rev_grid = grid;
				break;
		}
	}
	
	public void adjustCoor()
	{
		for (SeedPack a: sp)
		{
			if (a.isSelected() == true && a.getPlant() == pack.peashooter)
			{
				grid_y += 15;
			}
		}
	}
	
	public void plant()
	{
		setPlantingGrid();
		
		for (SeedPack s: sp)
		{
			if (s.isSelected() == true)
			{
				switch (s.getPlant())
				{
					case sunflower:
						if (sel_grid >= 1 && sel_grid <= 10) plants1.add(new Sunflower(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 11 && sel_grid <= 20) plants2.add(new Sunflower(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 21 && sel_grid <= 30) plants3.add(new Sunflower(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 31 && sel_grid <= 40) plants4.add(new Sunflower(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 41 && sel_grid <= 50) plants5.add(new Sunflower(grid_x, grid_y, sel_grid));
						
						break;

					case peashooter:
						adjustCoor();
						if (sel_grid >= 1 && sel_grid <= 10) plants1.add(new Peashooter(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 11 && sel_grid <= 20) plants2.add(new Peashooter(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 21 && sel_grid <= 30) plants3.add(new Peashooter(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 31 && sel_grid <= 40) plants4.add(new Peashooter(grid_x, grid_y, sel_grid));
						else if (sel_grid >= 41 && sel_grid <= 50) plants5.add(new Peashooter(grid_x, grid_y, sel_grid));
						
						break;
						
					default:
						break;
				}
			}
		}
		resetSelectedGrid();
	}
	
	public void remove()
	{
		setRemovingGrid();
		
		try
		{
			for (Generic p: plants1)
			{
				if (p.getGrid() == rev_grid)
				{
					plants1.remove(p);
				}
			}
			
			for (Generic p: plants2)
			{
				if (p.getGrid() == rev_grid)
				{
					plants2.remove(p);
				}
			}
			
			for (Generic p: plants3)
			{
				if (p.getGrid() == rev_grid)
				{
					plants3.remove(p);
				}
			}
			
			for (Generic p: plants4)
			{
				if (p.getGrid() == rev_grid)
				{
					plants4.remove(p);
				}
			}
			
			for (Generic p: plants5)
			{
				if (p.getGrid() == rev_grid)
				{
					plants5.remove(p);
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
		
		finally	
		{
			resetRemovingGrid();
		}
	}
	
	public int execute()
	{
		return this.price;
	}
	
	public boolean checkGrid(int i)
	{
		if (Grids[i] == true)
			return false;
		else
			return true;
	}
	
	public void setPrice(int i)
	{
		this.price = i;
	}
	
	public void setGrid(int j, boolean i)
	{
		this.Grids[j] = i;
	}
	
	public void setSelectedGrid(int i)
	{
		this.sel_grid = i;
	}
	
	public void setRemovingGrid(int i)
	{
		this.rev_grid = i;
	}
	
	public void resetSelectedGrid()
	{
		this.sel_grid = 0;
	}
	
	public void resetRemovingGrid()
	{
		this.rev_grid = 0;
	}
	
	public int getSelectedGrid()
	{
		return this.sel_grid;
	}
	
	public int getRemovingGrid()
	{
		return this.rev_grid;
	}
	
	public void sunConsumptionListener(int i)
	{
		this.price = i;
	}
	
	public void retrieveWorldDelay(int i)
	{
		this.world_delay = i;
	}
	
	public void retrievePlants1(ArrayList<Generic> a)
	{
		this.plants1 = a;
	}
	
	public void retrievePlants2(ArrayList<Generic> a)
	{
		this.plants2 = a;
	}
	
	public void retrievePlants3(ArrayList<Generic> a)
	{
		this.plants3 = a;
	}
	
	public void retrievePlants4(ArrayList<Generic> a)
	{
		this.plants4 = a;
	}
	
	public void retrievePlants5(ArrayList<Generic> a)
	{
		this.plants5 = a;
	}
	
	public void retrievePacks(ArrayList<SeedPack> a)
	{
		this.sp = a;
	}
}
