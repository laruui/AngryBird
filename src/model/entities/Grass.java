package model.entities;

import javax.swing.ImageIcon;

public class Grass extends Entity { //定义草的方法 继承自Entity类

	//石头块与它的位置和大小产生
	public Grass(int x, int y, int width, int height) {
		super(x, y, width, height);

		imagePath = "res/images/grass.png";
		ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	}

	@Override
	public void move() {
		
	}

}
