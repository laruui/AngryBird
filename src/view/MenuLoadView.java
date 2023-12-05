package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.Player;

@SuppressWarnings("serial")
public class MenuLoadView extends GameViewMenu
{

	//��Ӧ��λ����ҳ�����Ե�����
	private JComboBox playersList;
	private JButton okLoadButton, deleteButton;

	public MenuLoadView(ArrayList<Player> players)
	{
        playersList = new JComboBox();
        playersList.setSize(200,30);
        playersList.setLocation(frameWidth/2-100,150);

        //���������JComboBox��
        for(Player p : players)
        {
        	playersList.addItem(p);
        }
        
        okLoadButton = new JButton("ȷ��");
        okLoadButton.setSize(200,30);
        okLoadButton.setLocation(frameWidth/2-100, 200);
        
        deleteButton = new JButton("ɾ��");
        deleteButton.setSize(200,30);
        deleteButton.setLocation(frameWidth/2-100, 250);
        
        
        //��������1�����������ǰ��
        this.add(playersList,new Integer(1));
        this.add(deleteButton, new Integer(1));
        this.add(okLoadButton,new Integer(1));
	}
	
	public JComboBox getPlayersList()
	{
		return playersList;
	}
	
	public void setPlayersList(ArrayList<Player> players){
		playersList.removeAllItems();
		for(Player p : players)
        {
        	playersList.addItem(p);
        }
	}
	
	public JButton getDeleteButton()
	{
		return deleteButton;
	}
	
	public JButton getOkLoadButton()
	{
		return okLoadButton;
	}
	
}
