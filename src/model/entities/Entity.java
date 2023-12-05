package model.entities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
//�������e
public abstract class Entity {  //��������� Entity(ʵ�����˼)
	protected float speed; 		//�����ٶȱ���
	protected String imagePath; //����ͼƬ·������
	protected Image image;      //����ͼƬ����
	protected int imageWidth;   //����ͼƬ��ȱ���
	protected int imageHeight;  //����ͼƬ�߶ȱ���
	protected boolean visible = true; //�ж��Ƿ�ɼ�
	protected Rectangle hitBox; // ָ������ռ��е�һ������ͨ������ռ��� Rectangle �������Ϸ��ĵ� (x,y)����Ⱥ͸߶ȿ��Զ����������
	protected double angle;		//����Ƕ�

	//һ��ʵ��������λ�úʹ�С����
	public Entity(int x, int y, int width, int height) { //����ʵ����
		hitBox = new Rectangle(x, y, width, height); //����һ��Rectangle���� 
		imageWidth=width; //�����췽���е�width��ֵ��imageWidth����
		imageHeight=height;//�����췽���е�height��ֵ��imageHeight����
	}
	
	public Point getPosition() { //һ�����ʾ�� (x,y)����ռ��е�λ�ã�ָ���������ȡ� 
								//����getPosition()����
		return new Point(hitBox.x, hitBox.y); // ����ͳ�ʼ��һ��ָ��ָ���� (x,y)λ��������ռ�
	}
	
	public Image getImage() { //����getImage()����
        return this.image;	 //���ص�ǰ���image
    }
	
	//�÷������ƶ�ʵ�����¶���
	abstract public void move(); //����һ�����󷽷�move���ƶ���
	
	public boolean isVisible() { //����һ������ �ж��Ƿ��ǿɼ���
		return this.visible;	//���ص�ǰ���visible
	}
	
	public Rectangle getHitBox() { //����һ��getHitBox()�ķ��� ������Rectangle
		return hitBox;          //����hitBox
	}
	
	public void setSpeed(float speed) { //����һ�������ٶȵķ��� setSpeed()
		this.speed = speed;				//������speed��ֵ����ǰ���speed
	}
	public void setAngle(double a){angle=a;}  //����һ�����ýǶȵķ��� ��a��ֵ����ǰ���angle����
	public double getAngle(){return angle;}   //����һ����ýǶȵķ��� 
	public double getSpeed(){return speed;}   //����һ������ٶȵķ���
	public int getImageWidth(){return imageWidth;}  //������ͼƬ��ȵķ���
	public int getImageHeight(){return imageHeight;} //������ͼƬ���ȵķ���
	
	public void setPosition(int x, int y) { //��һ����������ķ���
		hitBox.x = x;   //��x��ֵ�������hitBox.x
		hitBox.y = y;	//��y��ֵ�������hitBox.y
	}
}
