package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Level;
import model.ListChangedEvent;
import model.ListListener;
import model.entities.Bird;
import model.entities.Egg;
import model.entities.Entity;

@SuppressWarnings("serial")
//这个类能向下转换成observer的原因是他继承了JPanel类
//而jpanel类继承自component类，也就是说GameView类拥有component类的所有的东西
//component类继承了imageobserver接口，也就是说component是具有imageobserver的所有的东西的
//所以jpanel具有imageobserver的所有的东西，也就是说本类具有imageobserver的所有的东西的
//也就是说，本类转换为imageobserver的一个对象毫无压力
public class GameView extends JPanel implements ListListener {
	private Level map;
	private ArrayList<Entity> entities;
	private int frameHeight = 600;
	private int frameWidth = 1200;
	private Bird currentBird;
	private int currentHighestScore;
	private String slingShotName1 = "res/images/lance-pierre1.png";
	private Image slingShotImg1;
	private String slingShotName2 = "res/images/lance-pierre2.png";
	private Image slingShotImg2;
	/*底下要用的e就是整个Java类（GameView）这个类的构造方法的一个参数，
	现在得找找哪里初始化这个类了，才能找到这个e到底是啥东西*/
	public GameView(ArrayList<Entity> entities) {
		
		/*将此 Component 的焦点状态设置为指定值。此值覆盖 Component 的默认焦点状态
		focusable - 表明此 Component 是否可以获得焦点g*/
        setFocusable(true); 
        
	   /*设置此组件是否应该使用缓冲区进行绘制。
	        如果设置为 true，则此组件的所有绘制将在一个离屏绘制缓冲区内完成。
	        然后将该离屏绘制缓冲区复制到屏幕上。Swing 绘制系统始终使用一个最大的双缓冲区。
	        如果缓冲了某个 Component，并且还缓冲了它的某个祖先，则将使用该祖先缓冲区。*/
        setDoubleBuffered(true);
        
        
        ImageIcon img1 = new ImageIcon(slingShotName1);
	    slingShotImg1 = img1.getImage(); 
	    ImageIcon img2 = new ImageIcon(slingShotName2);
	    slingShotImg2 = img2.getImage(); 
        
        this.entities = entities; 
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        //显示了水平
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0,frameWidth,frameHeight, this);
        //先画右边的弹弓
        g2d.drawImage(slingShotImg2, 100,412, this);
       
	    //这里显示右上角的小鸟和蛋的数量
	    int k = 0;
	    for(int i = entities.size()-1; i >=0;i--) {
	    	Entity e = entities.get(i);
		    	if(e instanceof Bird && e != currentBird) {
		    		g2d.drawImage(e.getImage(), frameWidth-100-k*15, 100,e.getImageWidth(),e.getImageHeight(), this);
		    		k++;
		    	}
	    		if(e == currentBird)
	    		{
	    			Egg egg = new Egg(0,0,28,30);
	    			for (int j = 0; j < currentBird.getEggLeft(); ++j) {
	        			g2d.drawImage(egg.getImage(), frameWidth-100+j*15, 20, this);
		    		}
	    	}
	    }
        //e是某一个entity，也就是实体
        for (Entity e : entities) {
        	//如果这个实体不是小鸟的话，就怎么着
        	if (!(e instanceof Bird)) 
        	{ 
        		//不是所有的鸟，只是目前的
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(), this);
        	}
        	//如果这个实体是小鸟的话，就怎么着
        	//找jb半天，这个e，tmd就是小鸟，我都不知道找了半天啥。。。。。
        	if(e== currentBird )
        		//e可以是任何实体类，各种东西，但是，这里，只有e是currentBird，也就是小鸟的时候才执行这个代码，。。。。懂了吧
        	{
        		//构建了一个坚实的 BasicStroke与指定线宽与盖的默认值为7f
        		g2d.setStroke(new BasicStroke(7.0f));
        		//设置颜色是棕色，这个你可以去百度rgb颜色查看器，我刚查过，是棕色
        		g2d.setColor(new Color(54, 28, 13));
        		//drawLine()划线的方法
        		if(!currentBird.isFlying())
        			//画条线，从135,442这个点划到，e是现在的小鸟，e.getPosition()获取小鸟的位置，.getX()+的x的值，e.getImageWidth()获取小鸟的宽度，然后除以2，就是小鸟的正中心
        g2d.drawLine(135,442, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		//这个是画图片的方法，img -指定要绘制的图像。如果这个方法不 img是空的。 x - nullx坐标。 y - nully坐标。 width -矩形的宽度。 height -矩形的高度。 observer对象有更多的图像转换通知。
        		//这个方法有几个重载的方法，一定要找到是哪个重载的方法
        		//还有，这个e真是好神奇。啥都能干，找找这个e是，就是小鸟，
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(),e.getImageWidth(),e.getImageHeight(), this);//这里的this就是当前类的意思，当前类是GameView类，这个类向下隐式转换为ImageObserver类的对象observer，这块懂了
        		
        		if(!currentBird.isFlying())
        			//画条线
        			g2d.drawLine(120,442, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		
        	}
        		g2d.setStroke(new BasicStroke(7.0f));
        		g2d.setColor(new Color(54, 28, 13));
        		//这个是弹射出去之后一闪而过的那条没有放鸟的皮筋的画法
        		if(currentBird.isFlying())
        			g2d.drawLine(135,442,120,442);
        		g2d.setStroke(new BasicStroke(1.0f));
        		g2d.setColor(new Color(0, 0, 0));
        }
        
        //最后画左边的弹弓   和左上角的分数和时间
        g2d.drawImage(slingShotImg1, 100, 412, this);
        g.drawString("Highest Score : " + currentHighestScore, 10, 15);
        g.drawString("Flying time left : " + currentBird.getFlyingTimeLeft(), 10, 30);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	public void setEntityList(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	

	public Level getMap() {
		return map;
	}

	public void setMap(Level map) {
		this.map = map;
	}
	
	public void setCurrentHighestScore(int highestScore) {
		this.currentHighestScore = highestScore;
	}

	@Override
	public void listChanged(ListChangedEvent event) {
		entities = event.getEntityList();
		currentBird = event.getCurrentBird();
		repaint();
		
	}
}
