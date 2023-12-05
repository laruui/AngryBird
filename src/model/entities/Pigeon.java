package model.entities;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	
	
	public Pigeon() {
		super(50, 48); //大小 50 48
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    speed = 100;
	    eggs = new ArrayList<Egg>();
	    eggLeft = 3;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
    
	//功能停止比赛盘旋的鸟
    public void hovering() {
    	isMoving = !isMoving;
    }
    
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
}
