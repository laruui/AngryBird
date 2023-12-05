package model.entities;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class HummingBird extends Bird {	 //定义蜂鸟 继承自Bird类
	public HummingBird() { //定义蜂鸟方法
		super(45, 44);	//调用父类构造参数 传入参数45 44
	    imagePath = "res/images/hummingbird.png"; //创建图片路径
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    speed = 100;
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	    eggs = new ArrayList<Egg>();
	    eggLeft = 1;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
    
    public void hovering() {
    	isMoving = !isMoving;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
