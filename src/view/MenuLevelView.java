package view;

import java.util.ArrayList;

import javax.swing.JButton;

import model.LevelNumber;

@SuppressWarnings("serial")
public class MenuLevelView extends GameViewMenu
{
	//���Ե�������Ӧ��ˮƽѡ��ҳ��
	private ArrayList<JButton> lvlButtons;

	public MenuLevelView()
	{
        lvlButtons = new ArrayList<JButton>();
        
        //��ͬ��εİ�ť�Ĵ���
        for (int lvlNumber = 0; lvlNumber < LevelNumber.getLevelNumber(); ++lvlNumber) {
        	lvlButtons.add(new JButton("" + (lvlNumber+1)));
        	lvlButtons.get(lvlNumber).setSize(60,60);
        	int lineNumber = lvlNumber / 5;
        	lvlButtons.get(lvlNumber).setLocation(frameWidth/2-190+(lvlNumber%5)*80,frameHeight/2-80 + lineNumber*80);
        }
        
        //��Ӱ�ť��1����������ǰ��
   	 	for (JButton button : lvlButtons) {
   	 		this.add(button, new Integer(1));
   	 	}
		
	}
	
	public ArrayList<JButton> getLvlButtons()
	{
		return lvlButtons;
	}
}
