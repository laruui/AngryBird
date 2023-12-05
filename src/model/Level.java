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

public class Level { // 自定义一个Level类
	private String backgroundImagePath = "res/images/background.png"; // 定义背景图片路径
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


	// 等级建设者采取相应的文本文件和难度
	public Level(String fileMapPath, String difficulty) {
		ImageIcon ii = new ImageIcon(backgroundImagePath);
		image = ii.getImage();
		ImageIcon gr = new ImageIcon(grassImagePath);
		grass = gr.getImage();
		ImageIcon bl = new ImageIcon(blockImagePath);
		block = bl.getImage();


		// 猪的速度是固定的依赖于困难
		if (difficulty == "easy")
			pigSpeed = 0;
		if (difficulty == "medium")
			pigSpeed = 1;
		if (difficulty == "hard")
			pigSpeed = 2;
		if (difficulty == "extreme")
			pigSpeed = 3;

		entities = new ArrayList<Entity>();


		// 加载该文件，我们创建的水平的特性
		try {
			FileInputStream ips = new FileInputStream(fileMapPath);
			isLoaded = true;
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			line = br.readLine();
			while (!line.equals("Map")) { 
				
				if (line.equals("Pigeon")){ //创建鸽子
					entities.add(new Pigeon());
				}
				if (line.equals("Humming Bird")){ //创建蜂鸟
					entities.add(new HummingBird());
				}
				if (line.equals("Sparrow")){ //创建麻雀
					entities.add(new Sparrow());
				}
				line = br.readLine();
			}


			// tabMap
			// 通过一个读文本文件一的人物和更新tabMap
			tabMap = new int[tabMapSizeY][tabMapSizeX];

			for (int i = 0; i < tabMapSizeY; i++) {
				line = br.readLine();

				for (int j = 0; j < tabMapSizeX; j++) {
					// 但是，皮筋在哪里。。。。
					// 这里就是地图，1,2,3的处理，0就不处理，其他东西的实体就是靠这个来定义，然后加载到处理的类里面去执行响应的操作，这里就是源头
					char car = line.charAt(j);
					String st = String.valueOf(car);
					tabMap[i][j] = Integer.parseInt(st);
					if (tabMap[i][j] == 3) // 如果包装盒中含有3，它会在相应的位置上的猪
						entities.add(new Pig(j * blockSize, i * blockSize, pigSpeed));
					if (tabMap[i][j] == 2) // 如果框包含一个2将在相应的位置来创建一个礅
						entities.add(new Block(j * blockSize, i * blockSize, blockSize, blockSize));
					if (tabMap[i][j] == 1) // 如果框包含一个1点上创建在相应的位置上的草块
						entities.add(new Grass(j * blockSize, i * blockSize, blockSize, blockSize));
				}
			}
		}
		// correspondant 如果我们试图创建一个没有对应的文本文件的级别
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
