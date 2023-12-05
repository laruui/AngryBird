package model;

import model.entities.Block;
import model.entities.Entity;
import model.entities.Grass;
import model.entities.HummingBird;
import model.entities.Pig;
import model.entities.Pigeon;
import model.entities.Sparrow;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Level { // �Զ���һ��Level��
	private String backgroundImagePath = "res/images/background.png"; // ���屳��ͼƬ·��
	private Image image;
	private int tabMap[][];
	private int tabMapSizeX = 47;
	private int tabMapSizeY = 22;
	private int blockSize = 26;
	private String grassImagePath = "res/images/grass.png";
	private Image grass;
	private String blockImagePath = "res/images/block.png";
	private Image block;
	private boolean isLoaded;
	private ArrayList<Entity> entities;
	private int pigSpeed;


	// �ȼ������߲�ȡ��Ӧ���ı��ļ����Ѷ�
	public Level(String fileMapPath, String difficulty) {
		ImageIcon ii = new ImageIcon(backgroundImagePath);
		image = ii.getImage();
		ImageIcon gr = new ImageIcon(grassImagePath);
		grass = gr.getImage();
		ImageIcon bl = new ImageIcon(blockImagePath);
		block = bl.getImage();


		// ����ٶ��ǹ̶�������������
		if (difficulty == "easy")
			pigSpeed = 0;
		if (difficulty == "medium")
			pigSpeed = 1;
		if (difficulty == "hard")
			pigSpeed = 2;
		if (difficulty == "extreme")
			pigSpeed = 3;

		entities = new ArrayList<Entity>();


		// ���ظ��ļ������Ǵ�����ˮƽ������
		try {
			FileInputStream ips = new FileInputStream(fileMapPath);
			isLoaded = true;
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			line = br.readLine();
			while (!line.equals("Map")) { 
				
				if (line.equals("Pigeon")){ //��������
					entities.add(new Pigeon());
				}
				if (line.equals("Humming Bird")){ //��������
					entities.add(new HummingBird());
				}
				if (line.equals("Sparrow")){ //������ȸ
					entities.add(new Sparrow());
				}
				line = br.readLine();
			}


			// tabMap
			// ͨ��һ�����ı��ļ�һ������͸���tabMap
			tabMap = new int[tabMapSizeY][tabMapSizeX];

			for (int i = 0; i < tabMapSizeY; i++) {
				line = br.readLine();

				for (int j = 0; j < tabMapSizeX; j++) {
					// ���ǣ�Ƥ�������������
					// ������ǵ�ͼ��1,2,3�Ĵ���0�Ͳ���������������ʵ����ǿ���������壬Ȼ����ص������������ȥִ����Ӧ�Ĳ������������Դͷ
					char car = line.charAt(j);
					String st = String.valueOf(car);
					tabMap[i][j] = Integer.parseInt(st);
					if (tabMap[i][j] == 3) // �����װ���к���3����������Ӧ��λ���ϵ���
						entities.add(new Pig(j * blockSize, i * blockSize, pigSpeed));
					if (tabMap[i][j] == 2) // ��������һ��2������Ӧ��λ��������һ����
						entities.add(new Block(j * blockSize, i * blockSize, blockSize, blockSize));
					if (tabMap[i][j] == 1) // ��������һ��1���ϴ�������Ӧ��λ���ϵĲݿ�
						entities.add(new Grass(j * blockSize, i * blockSize, blockSize, blockSize));
				}
			}
		}
		// correspondant ���������ͼ����һ��û�ж�Ӧ���ı��ļ��ļ���
		catch (Exception e) {
			isLoaded = false;
		}
	}

	public Image getImage() {
		return image;
	}

	public Image getGrass() {
		return grass;
	}

	public Image getBlock() {
		return block;
	}

	public int[][] getTabMap() {
		return tabMap;
	}

	public int getTabMapSizeX() {
		return tabMapSizeX;
	}

	public int getTabMapSizeY() {
		return tabMapSizeY;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public ArrayList<Entity> getEntityList() {
		return entities;
	}

	public boolean isLoaded() {
		return isLoaded;
	}

	public void setTabMap(int[][] tabMap) {
		this.tabMap = tabMap;
	}
}
