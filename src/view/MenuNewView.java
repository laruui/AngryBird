package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MenuNewView extends GameViewMenu
{

	//���Ե��������ʺ��ڽ����µĲ�λҳ��
	JLabel playernameLabel;
	JTextField playernameField;
	JButton okNewButton;

	public MenuNewView()
	{
        playernameLabel = new JLabel("����������ǳ� :");
        playernameLabel.setSize(200, 30);
        playernameLabel.setLocation(frameWidth/2-100,150);
        
        playernameField = new JTextField();
        playernameField.setSize(225,30);
        playernameField.setLocation(frameWidth/2-100,250);
   	 	
   	 	okNewButton = new JButton("ȷ��");
   	 	okNewButton.setSize(225,30);
   	 	okNewButton.setLocation(frameWidth/2-100, 350);
   	 	

   	 	//��������1�����������ǰ��
        this.add(playernameLabel,new Integer(1));
   	 	this.add(playernameField,new Integer(1));
        this.add(okNewButton,new Integer(1));
        
	}
	
	public JTextField getPlayerNameField()
	{
		return playernameField;
	}
	
	public JButton getOkNewButton()
	{
		return okNewButton;
	}
	
}
