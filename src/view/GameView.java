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
//�����������ת����observer��ԭ�������̳���JPanel��
//��jpanel��̳���component�࣬Ҳ����˵GameView��ӵ��component������еĶ���
//component��̳���imageobserver�ӿڣ�Ҳ����˵component�Ǿ���imageobserver�����еĶ�����
//����jpanel����imageobserver�����еĶ�����Ҳ����˵�������imageobserver�����еĶ�����
//Ҳ����˵������ת��Ϊimageobserver��һ���������ѹ��
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
	/*����Ҫ�õ�e��������Java�ࣨGameView�������Ĺ��췽����һ��������
	���ڵ����������ʼ��������ˣ������ҵ����e������ɶ����*/
	public GameView(ArrayList<Entity> entities) {
		
		/*���� Component �Ľ���״̬����Ϊָ��ֵ����ֵ���� Component ��Ĭ�Ͻ���״̬
		focusable - ������ Component �Ƿ���Ի�ý���g*/
        setFocusable(true); 
        
	   /*���ô�����Ƿ�Ӧ��ʹ�û��������л��ơ�
	        �������Ϊ true�������������л��ƽ���һ���������ƻ���������ɡ�
	        Ȼ�󽫸��������ƻ��������Ƶ���Ļ�ϡ�Swing ����ϵͳʼ��ʹ��һ������˫��������
	        ���������ĳ�� Component�����һ�����������ĳ�����ȣ���ʹ�ø����Ȼ�������*/
        setDoubleBuffered(true);
        
        
        ImageIcon img1 = new ImageIcon(slingShotName1);
	    slingShotImg1 = img1.getImage(); 
	    ImageIcon img2 = new ImageIcon(slingShotName2);
	    slingShotImg2 = img2.getImage(); 
        
        this.entities = entities; 
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        //��ʾ��ˮƽ
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0,frameWidth,frameHeight, this);
        //�Ȼ��ұߵĵ���
        g2d.drawImage(slingShotImg2, 100,412, this);
       
	    //������ʾ���Ͻǵ�С��͵�������
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
        //e��ĳһ��entity��Ҳ����ʵ��
        for (Entity e : entities) {
        	//������ʵ�岻��С��Ļ�������ô��
        	if (!(e instanceof Bird)) 
        	{ 
        		//�������е���ֻ��Ŀǰ��
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(), this);
        	}
        	//������ʵ����С��Ļ�������ô��
        	//��jb���죬���e��tmd����С���Ҷ���֪�����˰���ɶ����������
        	if(e== currentBird )
        		//e�������κ�ʵ���࣬���ֶ��������ǣ����ֻ��e��currentBird��Ҳ����С���ʱ���ִ��������룬�����������˰�
        	{
        		//������һ����ʵ�� BasicStroke��ָ���߿���ǵ�Ĭ��ֵΪ7f
        		g2d.setStroke(new BasicStroke(7.0f));
        		//������ɫ����ɫ����������ȥ�ٶ�rgb��ɫ�鿴�����Ҹղ��������ɫ
        		g2d.setColor(new Color(54, 28, 13));
        		//drawLine()���ߵķ���
        		if(!currentBird.isFlying())
        			//�����ߣ���135,442����㻮����e�����ڵ�С��e.getPosition()��ȡС���λ�ã�.getX()+��x��ֵ��e.getImageWidth()��ȡС��Ŀ�ȣ�Ȼ�����2������С���������
        g2d.drawLine(135,442, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		//����ǻ�ͼƬ�ķ�����img -ָ��Ҫ���Ƶ�ͼ�������������� img�ǿյġ� x - nullx���ꡣ y - nully���ꡣ width -���εĿ�ȡ� height -���εĸ߶ȡ� observer�����и����ͼ��ת��֪ͨ��
        		//��������м������صķ�����һ��Ҫ�ҵ����ĸ����صķ���
        		//���У����e���Ǻ����档ɶ���ܸɣ��������e�ǣ�����С��
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(),e.getImageWidth(),e.getImageHeight(), this);//�����this���ǵ�ǰ�����˼����ǰ����GameView�࣬�����������ʽת��ΪImageObserver��Ķ���observer����鶮��
        		
        		if(!currentBird.isFlying())
        			//������
        			g2d.drawLine(120,442, (int)e.getPosition().getX()+e.getImageWidth()/2, (int)e.getPosition().getY()+e.getImageHeight()/2);
        		
        	}
        		g2d.setStroke(new BasicStroke(7.0f));
        		g2d.setColor(new Color(54, 28, 13));
        		//����ǵ����ȥ֮��һ������������û�з����Ƥ��Ļ���
        		if(currentBird.isFlying())
        			g2d.drawLine(135,442,120,442);
        		g2d.setStroke(new BasicStroke(1.0f));
        		g2d.setColor(new Color(0, 0, 0));
        }
        
        //�����ߵĵ���   �����Ͻǵķ�����ʱ��
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
