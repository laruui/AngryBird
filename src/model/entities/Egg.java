package model.entities;

import javax.swing.ImageIcon;


public class Egg extends Entity {

	//����������λ�úʹ�С����
	public Egg(int x, int y, int width, int height) { //����Egg���� ���������Լ���߲���
		super(x,y,width,height); //�̳��Ը���������Լ���߲���
		imagePath = "res/images/egg.png";  //����ͼƬ·�� 
    	ImageIcon ii = new ImageIcon(imagePath); //����ImageIcon����ͼƬ·��
	    image = ii.getImage();  //����ȡ��ͼƬ��ֵ��image
	    imageHeight = ii.getIconHeight(); //����ȡ��ͼƬ�߶ȸ�ֵ��image
	    imageWidth = ii.getIconWidth();	  //����ȡ��ͼƬ��ֵ��ȸ�image
		speed = 3; //�����½����ٶ�Ϊ3
	}

	//�����ƶ����Ŵ�ֱ�ᣨy��
	public void move() { //�����ƶ�����
		hitBox.y += speed; //
		speed+=10f;	  //
	}
}

