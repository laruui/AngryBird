package model.entities;

import javax.swing.ImageIcon;

public class Block extends Entity{ //����һ��Block����(�ϰ�����) �̳���Entity��
	
	//�谭���Ǹ�������������ķ�λ����С��ģ��
	public Block(int x, int y, int width, int height) { //���幹�췽��  �����Լ����
		super(x, y, width, height); //�̳��Ը�������� ���
		
		imagePath = "res/images/block.png";  //ͼƬ·��
		ImageIcon ii = new ImageIcon(imagePath);  //����һ��ImageIcon����   ����ͼƬ·��
	    image = ii.getImage(); //����getImage()������ȡͼƬ��Ϣ ��ֵ��image
	    imageHeight = ii.getIconHeight(); //��ȡͼ��ĸ߶�
	    imageWidth = ii.getIconWidth();	  //��ȡͼ��Ŀ��
	}

	@Override
	public void move() { //��дmove()����
		
	}
	
}
