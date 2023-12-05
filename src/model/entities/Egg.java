package model.entities;

import javax.swing.ImageIcon;


public class Egg extends Entity {

	//鸡蛋与它的位置和大小创建
	public Egg(int x, int y, int width, int height) { //定义Egg方法 传入坐标以及宽高参数
		super(x,y,width,height); //继承自父类的坐标以及宽高参数
		imagePath = "res/images/egg.png";  //定义图片路径 
    	ImageIcon ii = new ImageIcon(imagePath); //创建ImageIcon传入图片路径
	    image = ii.getImage();  //将获取的图片赋值给image
	    imageHeight = ii.getIconHeight(); //将获取的图片高度赋值给image
	    imageWidth = ii.getIconWidth();	  //将获取的图片赋值宽度给image
		speed = 3; //鸡蛋下降的速度为3
	}

	//蛋仅移动沿着垂直轴（y）
	public void move() { //定义移动方法
		hitBox.y += speed; //
		speed+=10f;	  //
	}
}

