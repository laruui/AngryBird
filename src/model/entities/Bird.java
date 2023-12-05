package model.entities;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class Bird extends Entity { //定义一个抽象类Bird（鸟类） 继承自 Entity类（实体）
	protected short flyingTime;     //定义一个short类型的变量 flyingTime（飞行时间）
	protected int eggLeft;			//定义一个int类型的变量eggLeft（）
	protected ArrayList<Egg> eggs;  //定义一个ArrayList集合 eggs（泛型是Egg，应该为蛋的一个数组）
	protected boolean isFlying;     //判断是否为飞行状态
	protected boolean isMoving;		//判断是否为移动状态
	private double time;            //定义一个double类型的变量 time
	protected Dimension frameSize;  //定义一个Dimension的frameSize的变量  封装框架的长宽
	private double accelX;			//定义一个double类型的 变量accelX 可能是X轴加速
	private double accelY;			//定义一个double类型的 变量accelY 可能是Y轴加速
	protected int startLocationX;   //定义一个int类型的变量startLocationX(X轴开始位置)
	protected int startLocationY;	//定义一个int类型的变量startLocationY(Y轴开始位置)
	private long lastTime;			//定义一个long类型的变量lastTime （最后时间）
	private long flyingTimeLeft;	//定义一个long类型的变量flyingTimeLeft（最多飞行时间）
	
	//l'oiseau est construit avec sa taille 鸟构造，其大小
	public Bird(int width, int height) { //创建Bird类构造方法 参数是长度跟高度
		super(100,440,width,height);  //继承自父类的构造方法 
		isMoving = false;			  //将false赋值给isMoving 初试状态为停止
		time = 0.1;					  //经过测试 这个值影响小鸟初试的
		accelX = 0;					  //经过测试 似乎影响小鸟速度
		startLocationX = 100;         //X 跟 Y 这俩个只字面意思是起始位置，但是经过测试
		startLocationY = 440;		  //会跟小鸟的速度有关系，可能是与上面俩变量有关，类似v=s/t
		accelY = 9.81;				  //经过测试 这个是重力加速度
		flyingTimeLeft = 10000;       //这个是最多飞行时间的意思
	}
	
	public int getEggLeft() { //定义一个获取eggLeft的方法
		return eggLeft;
	}

	public void setEggLeft(int i) { //定义一个设置eggLeft的方法 讲参数i赋值给当前类的eggLeft
		this.eggLeft = i;
	}
	public int getStartLocationX() //定义一个获取X初始位置的方法
	{
		return startLocationX;
	}
	public int getStartLocationY()//定义一个获取Y初始位置的方法
	{
		return startLocationY;
	}
	
	public abstract void hovering(); //重定义的方法仅能够鸟类的盘旋     方法只为了可以悬停飞行的鸟重新定义
	public boolean isFlying() { //定义一个方法 判断是否在飞行状态
		return isFlying;
	}

    public void move() {  //定义一个move方法
    	if(isFlying){
	    	if(isMoving){	//这俩个代码 可能是算出小鸟最后的击中点坐标
		    	hitBox.x = (int) Math.round(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX);
		    	hitBox.y = (int) Math.round(0.5*accelY*time*time-Math.sin(angle)*speed*time+startLocationY);
		    	time+=0.1;
	    	}
	    	long currentTime = System.currentTimeMillis(); //currentTimeMillis() 返回当前时间以毫秒为单位
	    	flyingTimeLeft -= (currentTime - lastTime); //飞行时间 = 当前时间 - 最后时间
	    	lastTime = currentTime; //把当前时间赋值给最后时间
    	}
	    	if (hitBox.y > (int) frameSize.getHeight() || hitBox.x > (int) frameSize.getWidth() ||flyingTimeLeft <= 0 )
	    		visible = false;
	    	// 
    }
    
    public void launch(){ //定义一个发射方法 ???
    	isMoving = true;  
    	isFlying = true;  
    	lastTime = System.currentTimeMillis();
    }
    
	public void moveRight() { // ???
		accelX+=0.1;
    }
    
    public void moveLeft() { // ???
    	accelX-=0.1;
    }
	
	public long getFlyingTimeLeft() { //定义一个获取最多飞行时间的方法
		return flyingTimeLeft;
	}
}
//这样就报错了
//左边这个JRE system Library是Java系统库，都在Java\jre1.8文件夹下
//而地下那个就是referenced Library是外部库的意思，一般要放到外部库的包都自己建立一个文件夹名字叫lib，就是Library的意思
//也可以不放到外部文件放哪里都行，放到lib里面只是默认规范，但是必须在项目文件夹下有
