package model.entities;

abstract class Enemy extends Entity { //定义一个Enemy类（敌人的意思） 继承自Entity类
	
	protected boolean back;   //定义一个boolean类型变量back
	protected boolean down;   //定义一个boolean类型变量down
	protected int timeDirection;  //？？？
	protected int timeDown;   	  //？？？
	
	//敌人是根据他所处坐标的方位及大小建模的
	//定义一个敌人的方法   坐标以及长宽都继承自父类的坐标以及长宽
	public Enemy(int x, int y, int width, int height) {
		super(x,y,width, height);
	}
}