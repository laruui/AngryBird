package model.entities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
//这个就是e
public abstract class Entity {  //定义抽象类 Entity(实体的意思)
	protected float speed; 		//定义速度变量
	protected String imagePath; //定义图片路径变量
	protected Image image;      //定义图片变量
	protected int imageWidth;   //定义图片宽度变量
	protected int imageHeight;  //定义图片高度变量
	protected boolean visible = true; //判断是否可见
	protected Rectangle hitBox; // 指定坐标空间中的一个区域，通过坐标空间中 Rectangle 对象左上方的点 (x,y)、宽度和高度可以定义这个区域。
	protected double angle;		//定义角度

	//一个实体与它的位置和大小产生
	public Entity(int x, int y, int width, int height) { //定义实体类
		hitBox = new Rectangle(x, y, width, height); //创建一个Rectangle对象 
		imageWidth=width; //将构造方法中的width赋值给imageWidth变量
		imageHeight=height;//将构造方法中的height赋值给imageHeight变量
	}
	
	public Point getPosition() { //一个点表示在 (x,y)坐标空间中的位置，指定整数精度。 
								//创建getPosition()方法
		return new Point(hitBox.x, hitBox.y); // 构造和初始化一个指向指定的 (x,y)位置在坐标空间
	}
	
	public Image getImage() { //创建getImage()方法
        return this.image;	 //返回当前类的image
    }
	
	//该方法在移动实体重新定义
	abstract public void move(); //定义一个抽象方法move（移动）
	
	public boolean isVisible() { //定义一个方法 判断是否是可见的
		return this.visible;	//返回当前类的visible
	}
	
	public Rectangle getHitBox() { //定义一个getHitBox()的方法 类型是Rectangle
		return hitBox;          //返回hitBox
	}
	
	public void setSpeed(float speed) { //定义一个设置速度的方法 setSpeed()
		this.speed = speed;				//讲参数speed赋值给当前类的speed
	}
	public void setAngle(double a){angle=a;}  //定义一个设置角度的方法 讲a赋值给当前类的angle变量
	public double getAngle(){return angle;}   //定义一个获得角度的方法 
	public double getSpeed(){return speed;}   //定义一个获得速度的方法
	public int getImageWidth(){return imageWidth;}  //定义获得图片宽度的方法
	public int getImageHeight(){return imageHeight;} //定义获得图片长度的方法
	
	public void setPosition(int x, int y) { //顶一个设置坐标的方法
		hitBox.x = x;   //将x赋值给本类的hitBox.x
		hitBox.y = y;	//将y赋值给本类的hitBox.y
	}
}
