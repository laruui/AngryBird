package model.entities;

abstract class Enemy extends Entity { //����һ��Enemy�ࣨ���˵���˼�� �̳���Entity��
	
	protected boolean back;   //����һ��boolean���ͱ���back
	protected boolean down;   //����һ��boolean���ͱ���down
	protected int timeDirection;  //������
	protected int timeDown;   	  //������
	
	//�����Ǹ�������������ķ�λ����С��ģ��
	//����һ�����˵ķ���   �����Լ������̳��Ը���������Լ�����
	public Enemy(int x, int y, int width, int height) {
		super(x,y,width, height);
	}
}