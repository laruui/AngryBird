package model.entities;

import javax.swing.ImageIcon;

public class Grass extends Entity { //����ݵķ��� �̳���Entity��

	//ʯͷ��������λ�úʹ�С����
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
