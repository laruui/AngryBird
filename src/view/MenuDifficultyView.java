package view;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuDifficultyView extends GameViewMenu
{


	//属性的声明已经适应页面的难度的选择
	private JLabel difficultyLabel;
	private JButton easyButton, mediumButton, hardButton, extremeButton;
	private String parentPanel="";
	
	public MenuDifficultyView()
	{
		
        difficultyLabel = new JLabel("选择难度 :");
        difficultyLabel.setSize(220, 40);
        difficultyLabel.setLocation(frameWidth/2-100,150);
		
        easyButton = new JButton("容易");
        easyButton.setSize(220,40);
        easyButton.setLocation(frameWidth/2-100, 250);

        
        extremeButton = new JButton("噩梦");
        extremeButton.setSize(220,40);
        extremeButton.setLocation(frameWidth/2-100, 350);
        

        //具有索引1添加属性是在前景
   	 	this.add(difficultyLabel,new Integer(1));
   	 	this.add(easyButton,new Integer(1));
   	 	this.add(extremeButton,new Integer(1));
	}
	
	public JButton getEasyButton()
	{
		return easyButton;
	}

	
	public JButton getExtremeButton()
	{
		return extremeButton;
	}
	
	public String getParentPanel()
	{
		return this.parentPanel;
	}
	
	public void setParentPanel(String parent)
	{
		this.parentPanel=parent;
	}
}
