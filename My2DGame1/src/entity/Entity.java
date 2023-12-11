package entity;

import java.awt.image.BufferedImage;

public class Entity { // parent class of players,monster etc..

	public int x, y;
	public int speed;

	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2 ;
	public String direction;
	
	public int spriteCounter = 0;		//moving animation for boy
	public int spriteNum = 1;
}
