package view;

import main.GameFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameViewMenu extends JLayeredPane {
	
	final int frameWidth = GameFrame.getFrameSize().width;
	final int frameHeight = GameFrame.getFrameSize().height;

	//属性来实现菜单spages背景
	private String titleImagePath = "res/images/title.png";
	private String backgroundImagePath = "res/images/background.png";
	private Image image,title;
	private JPanel backPanel;
	
	//继承后退按钮上的所有网页
	protected JButton backButton;
	
	public GameViewMenu()
	{

		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();

	    ImageIcon ti = new ImageIcon(titleImagePath);
	    title = ti.getImage();
	    
	    //该板涂上所需的背景
	    backPanel= new JPanel() {
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0,frameWidth, frameHeight, null);
				g.drawImage(title,frameWidth/2-295, 20, null);
			
			}
		};
		
		backPanel.setSize(new Dimension(frameWidth, frameHeight));
	    setFocusable(true);
        setDoubleBuffered(true);
        
        backButton = new JButton("返回");
        backButton.setSize(150,35);
        backButton.setLocation(1000, 500);
        
        this.add(backPanel,new Integer(0)); 
        this.add(backButton,new Integer(1));//背板具有0的索引是在具有索引为1的所有其他对象的背景
   	 	        
        this.setVisible(true);
	}
	
	public JButton getBackButton(){
		return backButton;
	}
	
}
