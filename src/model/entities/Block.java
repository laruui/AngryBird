package model.entities;

import javax.swing.ImageIcon;

public class Block extends Entity{ //定义一个Block的类(障碍物类) 继承自Entity类
	
	//阻碍物是根据其所处坐标的方位及大小建模的
	public Block(int x, int y, int width, int height) { //定义构造方法  坐标以及宽高
		super(x, y, width, height); //继承自父类的坐标 宽高
		
		imagePath = "res/images/block.png";  //图片路径
		ImageIcon ii = new ImageIcon(imagePath);  //创建一个ImageIcon对象   传入图片路径
	    image = ii.getImage(); //调用getImage()方法获取图片信息 赋值给image
	    imageHeight = ii.getIconHeight(); //获取图标的高度
	    imageWidth = ii.getIconWidth();	  //获取图标的宽度
	}

	@Override
	public void move() { //重写move()方法
		
	}
	
}
