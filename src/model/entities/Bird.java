package model.entities;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class Bird extends Entity { //����һ��������Bird�����ࣩ �̳��� Entity�ࣨʵ�壩
	protected short flyingTime;     //����һ��short���͵ı��� flyingTime������ʱ�䣩
	protected int eggLeft;			//����һ��int���͵ı���eggLeft����
	protected ArrayList<Egg> eggs;  //����һ��ArrayList���� eggs��������Egg��Ӧ��Ϊ����һ�����飩
	protected boolean isFlying;     //�ж��Ƿ�Ϊ����״̬
	protected boolean isMoving;		//�ж��Ƿ�Ϊ�ƶ�״̬
	private double time;            //����һ��double���͵ı��� time
	protected Dimension frameSize;  //����һ��Dimension��frameSize�ı���  ��װ��ܵĳ���
	private double accelX;			//����һ��double���͵� ����accelX ������X�����
	private double accelY;			//����һ��double���͵� ����accelY ������Y�����
	protected int startLocationX;   //����һ��int���͵ı���startLocationX(X�Ὺʼλ��)
	protected int startLocationY;	//����һ��int���͵ı���startLocationY(Y�Ὺʼλ��)
	private long lastTime;			//����һ��long���͵ı���lastTime �����ʱ�䣩
	private long flyingTimeLeft;	//����һ��long���͵ı���flyingTimeLeft��������ʱ�䣩
	
	//l'oiseau est construit avec sa taille ���죬���С
	public Bird(int width, int height) { //����Bird�๹�췽�� �����ǳ��ȸ��߶�
		super(100,440,width,height);  //�̳��Ը���Ĺ��췽�� 
		isMoving = false;			  //��false��ֵ��isMoving ����״̬Ϊֹͣ
		time = 0.1;					  //�������� ���ֵӰ��С����Ե�
		accelX = 0;					  //�������� �ƺ�Ӱ��С���ٶ�
		startLocationX = 100;         //X �� Y ������ֻ������˼����ʼλ�ã����Ǿ�������
		startLocationY = 440;		  //���С����ٶ��й�ϵ���������������������йأ�����v=s/t
		accelY = 9.81;				  //�������� ������������ٶ�
		flyingTimeLeft = 10000;       //�����������ʱ�����˼
	}
	
	public int getEggLeft() { //����һ����ȡeggLeft�ķ���
		return eggLeft;
	}

	public void setEggLeft(int i) { //����һ������eggLeft�ķ��� ������i��ֵ����ǰ���eggLeft
		this.eggLeft = i;
	}
	public int getStartLocationX() //����һ����ȡX��ʼλ�õķ���
	{
		return startLocationX;
	}
	public int getStartLocationY()//����һ����ȡY��ʼλ�õķ���
	{
		return startLocationY;
	}
	
	public abstract void hovering(); //�ض���ķ������ܹ����������     ����ֻΪ�˿�����ͣ���е������¶���
	public boolean isFlying() { //����һ������ �ж��Ƿ��ڷ���״̬
		return isFlying;
	}

    public void move() {  //����һ��move����
    	if(isFlying){
	    	if(isMoving){	//���������� ���������С�����Ļ��е�����
		    	hitBox.x = (int) Math.round(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX);
		    	hitBox.y = (int) Math.round(0.5*accelY*time*time-Math.sin(angle)*speed*time+startLocationY);
		    	time+=0.1;
	    	}
	    	long currentTime = System.currentTimeMillis(); //currentTimeMillis() ���ص�ǰʱ���Ժ���Ϊ��λ
	    	flyingTimeLeft -= (currentTime - lastTime); //����ʱ�� = ��ǰʱ�� - ���ʱ��
	    	lastTime = currentTime; //�ѵ�ǰʱ�丳ֵ�����ʱ��
    	}
	    	if (hitBox.y > (int) frameSize.getHeight() || hitBox.x > (int) frameSize.getWidth() ||flyingTimeLeft <= 0 )
	    		visible = false;
	    	// 
    }
    
    public void launch(){ //����һ�����䷽�� ???
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
	
	public long getFlyingTimeLeft() { //����һ����ȡ������ʱ��ķ���
		return flyingTimeLeft;
	}
}
//�����ͱ�����
//������JRE system Library��Javaϵͳ�⣬����Java\jre1.8�ļ�����
//�������Ǹ�����referenced Library���ⲿ�����˼��һ��Ҫ�ŵ��ⲿ��İ����Լ�����һ���ļ������ֽ�lib������Library����˼
//Ҳ���Բ��ŵ��ⲿ�ļ������ﶼ�У��ŵ�lib����ֻ��Ĭ�Ϲ淶�����Ǳ�������Ŀ�ļ�������
