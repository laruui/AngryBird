package view;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuHomeView extends GameViewMenu
{

	//���Ե�������������ҳ
	private JButton newButton,optionsButton,exitButton;
	
	public MenuHomeView() {
		
        newButton = new JButton("����Ϸ");
        newButton.setSize(250,40);
        newButton.setLocation(frameWidth/2-115, 200);

        
        optionsButton = new JButton("���ư���");
        optionsButton.setSize(250,40);
        optionsButton.setLocation(frameWidth/2-115, 300);
        
        exitButton = new JButton("�˳���Ϸ");
        exitButton.setSize(250,40);
        exitButton.setLocation(frameWidth/2-115, 400);
        
        backButton.setVisible(false); 
        								//����ҳ��û�к��˰�ť��������1�����������ǰ��
   	 	this.add(newButton,new Integer(1));
   	 	this.add(optionsButton,new Integer(1));
   	 	this.add(exitButton,new Integer(1));
	}
	
	public JButton getNewButton()
	{
		return newButton;
	}
	
	public JButton getOptionsButton()
	{
		return optionsButton;
	}
	
	public JButton getExitButton()
	{
		return exitButton;
	}
	
}
