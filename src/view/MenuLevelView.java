package view;

import java.util.ArrayList;

import javax.swing.JButton;

import model.LevelNumber;

@SuppressWarnings("serial")
public class MenuLevelView extends GameViewMenu
{
	//属性的声明适应的水平选择页面
	private ArrayList<JButton> lvlButtons;

	public MenuLevelView()
	{
        lvlButtons = new ArrayList<JButton>();
        
        //不同层次的按钮的创建
        for (int lvlNumber = 0; lvlNumber < LevelNumber.getLevelNumber(); ++lvlNumber) {
        	lvlButtons.add(new JButton("" + (lvlNumber+1)));
        	lvlButtons.get(lvlNumber).setSize(60,60);
        	int lineNumber = lvlNumber / 5;
        	lvlButtons.get(lvlNumber).setLocation(frameWidth/2-190+(lvlNumber%5)*80,frameHeight/2-80 + lineNumber*80);
        }
        
        //添加按钮用1个索引是在前景
   	 	for (JButton button : lvlButtons) {
   	 		this.add(button, new Integer(1));
   	 	}
		
	}
	
	public ArrayList<JButton> getLvlButtons()
	{
		return lvlButtons;
	}
}
