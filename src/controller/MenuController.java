package controller;

import main.GameFrame;
import model.GameModel;
import model.Level;
import model.Player;
import view.MenuDifficultyView;
import view.MenuHomeView;
import view.MenuLevelView;
import view.MenuLoadView;
import view.MenuNewView;
import view.MenuOptionsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MenuController implements KeyListener, ActionListener, MouseListener {

	private JTextField playerNameField;
	private JButton backfromNewButton, backfromLoadButton, backfromOptionsButton;
	private JButton backfromDifficultyButton, backfromLevelButton;
	private JButton newButton,loadButton,optionsButton,exitButton;
	private JButton okNewButton,okLoadButton,deleteButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private ArrayList<JButton> lvlButtons;
	private Player currentPlayer;
	@SuppressWarnings("unused")
	private ArrayList<Player> angryPlayers;
	private JComboBox playersList;
	private MenuHomeView angryMenuHomeView;
	private MenuNewView angryMenuNewView;
	private MenuLoadView angryMenuLoadView;
	private MenuOptionsView angryMenuOptionsView;
	private MenuDifficultyView angryMenuDifficultyView;
	private MenuLevelView angryMenuLevelView;
	private GameFrame angryFrame;
	private String difficulty = "";
	private GameModel angryModel;
	
	public MenuController(GameFrame frame){
		
		angryFrame = frame;
		angryModel = angryFrame.getAngryModel();
		angryPlayers = angryModel.getPlayers();
		
		
		angryMenuHomeView = frame.getAngryMenuHomeView();
		angryMenuNewView = frame.getAngryMenuNewView();
		angryMenuLoadView = frame.getAngryMenuLoadView();
		angryMenuOptionsView = frame.getAngryMenuOptionsView();
		angryMenuDifficultyView = frame.getAngryMenuDifficultyView();
		angryMenuLevelView = frame.getAngryMenuLevelView();
		
		// �ָ��˱�Ҫ�Ĳ˵���
		// ����������ӵ�ActionListener
		
		backfromNewButton = angryMenuNewView.getBackButton();
		backfromNewButton.addActionListener(this);
		backfromLoadButton = angryMenuLoadView.getBackButton();
		backfromLoadButton.addActionListener(this);
		backfromOptionsButton = angryMenuOptionsView.getBackButton();
		backfromOptionsButton.addActionListener(this);
		backfromDifficultyButton = angryMenuDifficultyView.getBackButton();
		backfromDifficultyButton.addActionListener(this);
		backfromLevelButton = angryMenuLevelView.getBackButton();
		backfromLevelButton.addActionListener(this);
		
		newButton = angryMenuHomeView.getNewButton();
		newButton.addActionListener(this);
		optionsButton = angryMenuHomeView.getOptionsButton();
		optionsButton.addActionListener(this);
		exitButton = angryMenuHomeView.getExitButton();
		exitButton.addActionListener(this);
		
		playerNameField = angryMenuNewView.getPlayerNameField();
		okNewButton = angryMenuNewView.getOkNewButton();
		okNewButton.addActionListener(this);
				
		playersList = angryMenuLoadView.getPlayersList();
		deleteButton = angryMenuLoadView.getDeleteButton();
		deleteButton.addActionListener(this);
		okLoadButton = angryMenuLoadView.getOkLoadButton();
		okLoadButton.addActionListener(this);
		
		easyButton = angryMenuDifficultyView.getEasyButton();
		easyButton.addActionListener(this);
		extremeButton = angryMenuDifficultyView.getExtremeButton();
		extremeButton.addActionListener(this);
		
		lvlButtons = angryMenuLevelView.getLvlButtons();
		for (JButton button : lvlButtons) {
			button.addActionListener(this);
		}
		
		JOptionPane.setDefaultLocale(Locale.CHINESE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//  ���ݰ�ť�ĵ�����ı�
		
		if(e.getSource().equals(backfromNewButton)||e.getSource().equals(backfromLoadButton)||e.getSource().equals(backfromOptionsButton))
		{
			angryFrame.setContentPane(angryMenuHomeView);
			angryMenuHomeView.requestFocus();
			angryFrame.setVisible(true);
		}
		if(e.getSource().equals(backfromDifficultyButton))
		{
			if(angryMenuDifficultyView.getParentPanel()=="newPanel")
			{
				angryFrame.setContentPane(angryMenuNewView);
				angryMenuNewView.requestFocus();
				angryFrame.setVisible(true);
			}
			else
			{
				angryFrame.setContentPane(angryMenuLoadView);
				angryMenuLoadView.requestFocus();
				angryFrame.setVisible(true);
			}
		}

		if(e.getSource().equals(backfromLevelButton))
		{
			angryFrame.setContentPane(angryMenuDifficultyView);
			angryMenuDifficultyView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		if (e.getSource().equals(newButton))
		{
			angryFrame.setContentPane(angryMenuNewView);
			angryMenuNewView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		if(e.getSource().equals(loadButton))
		{			
			if(angryFrame.getAngryModel().getPlayers().isEmpty())
			{
				javax.swing.JOptionPane.showMessageDialog(null, "�Ҳ��������ļ� !");
			}
			else
			{
				angryFrame.setContentPane(angryMenuLoadView);
				angryMenuLoadView.requestFocus();
				angryFrame.setVisible(true);
			}
		}
		
		if (e.getSource().equals(optionsButton))
		{
			angryFrame.setContentPane(angryMenuOptionsView);
			angryMenuOptionsView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		if (e.getSource().equals(exitButton))
		{
			int option = javax.swing.JOptionPane.showConfirmDialog(null, "��ȷ���� ��", "ȷ���˳�", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION)
			{
				System.exit(0);		
			}
		}
		
		if(e.getSource().equals(okNewButton))
		{			
			if (playerNameField.getText().equals(""))
			{
				javax.swing.JOptionPane.showMessageDialog(null, "����������ǳƣ�");
			}		
			else 
			{				
		        // ����һ���µĲ�����
		       	currentPlayer = new Player(playerNameField.getText());
		       	angryFrame.setCurrentPlayer(currentPlayer);
		       	angryFrame.setDifficulty("");
		       	angryFrame.setCurrentLevel(0);
				angryFrame.setCurrentHighScore();
			
				angryFrame.setContentPane(angryMenuDifficultyView);
				angryMenuDifficultyView.setParentPanel("newPanel");
				angryMenuDifficultyView.requestFocus();
				angryFrame.setVisible(true);
				
				// ���µ���������
				ArrayList<Player> players = new ArrayList<Player>();
				angryFrame.setPlayers(players);
				angryMenuLoadView.setPlayersList(players);
		        
			}
			
		}
		
		if(e.getSource().equals(okLoadButton))
		{
			// ������ѡ�Ĳ�����
			currentPlayer = (Player) playersList.getSelectedItem();
			angryFrame.setCurrentPlayer(currentPlayer);
			angryFrame.setDifficulty("");
			angryFrame.setCurrentLevel(0);
			angryFrame.setCurrentHighScore();

			angryFrame.setContentPane(angryMenuDifficultyView);
			angryMenuDifficultyView.setParentPanel("loadPanel");
			angryMenuDifficultyView.requestFocus();
			angryFrame.setVisible(true);
			
			// ���µ�����
			ArrayList<Player> players = new ArrayList<Player>();

			angryFrame.setPlayers(players);
			angryMenuLoadView.setPlayersList(players);
		}
		
		if(e.getSource().equals(deleteButton))
		{
			int option = javax.swing.JOptionPane.showConfirmDialog(null, "��ȷ����", "��ֹǰȷ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION)
			{
				// ɾ��ѡ�е��ļ�
				Player p = (Player) playersList.getSelectedItem();
				playersList.removeItem(p);
				
				// ���µ�����
				ArrayList<Player> players = new ArrayList<Player>();
				
				angryFrame.setPlayers(players);
				angryMenuLoadView.setPlayersList(players);
				
				angryFrame.setContentPane(angryMenuLoadView);
				angryMenuLoadView.requestFocus();
				angryFrame.setVisible(true);	
			}
		}
		

		// �Ѷȸ��µı���
		if (e.getSource().equals(easyButton))
		{
			difficulty = "easy";
			
		}
		
		if (e.getSource().equals(mediumButton))
		{
			difficulty = "medium";
			
		}
			
		if (e.getSource().equals(hardButton))
		{
			difficulty = "hard";
			
		}
		
		if (e.getSource().equals(extremeButton))
		{
			difficulty = "extreme";	
		}
		
		// ҳ������ʾ���ݱ��ݰ�ť���û�
		if (!difficulty.equals("") && (e.getSource().equals(easyButton) || e.getSource().equals(mediumButton) || e.getSource().equals(hardButton) || e.getSource().equals(extremeButton))) {
			for (int lvlNumber = 0; lvlNumber < lvlButtons.size(); ++lvlNumber) {
				lvlButtons.get(lvlNumber).setEnabled(false);
				
				if (currentPlayer.isFinished(lvlNumber, difficulty)) {
					lvlButtons.get(lvlNumber).setEnabled(true);
					if ((lvlNumber+1) < lvlButtons.size())
						lvlButtons.get(lvlNumber+1).setEnabled(true);
				}
			}
			lvlButtons.get(0).setEnabled(true);
			
			angryFrame.setDifficulty(difficulty);
			
			angryFrame.setContentPane(angryMenuLevelView);
			angryMenuLevelView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		//�����Ƴ���Ӧ����ѡ����
		for (int i = 0; i < lvlButtons.size(); ++i) {
			if(e.getSource().equals(lvlButtons.get(i))) {
				Level lvl = new Level("res/maps/lvl0" + (i+1) + ".txt", difficulty);
				if (lvl.isLoaded()) {
					angryFrame.getAngryView().setMap(lvl);
					angryFrame.getAngryModel().setMap(lvl);
					angryFrame.setCurrentHighScore();
					angryFrame.setGame();
					angryFrame.setCurrentLevel(i+1);
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(null, "û�ж�Ӧ�Ѷȵĵ�ͼ !");
				}
			}
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		
			case KeyEvent.VK_ESCAPE:
				if(angryFrame.getContentPane()==angryMenuHomeView)
				{
					int option = javax.swing.JOptionPane.showConfirmDialog(null, "��ȷ����", "�뿪ǰȷ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION)
					{
						System.exit(0);		
					}
				}
				if(angryFrame.getContentPane()==angryMenuNewView || angryFrame.getContentPane()==angryMenuLoadView || angryFrame.getContentPane()==angryMenuOptionsView)
				{
					angryFrame.setContentPane(angryMenuHomeView);
					angryMenuHomeView.requestFocus();
					angryFrame.setVisible(true);
				}
				if(angryFrame.getContentPane()==angryMenuDifficultyView)
				{
					if(angryMenuDifficultyView.getParentPanel()=="newPanel")
					{
						angryFrame.setContentPane(angryMenuNewView);
						angryMenuNewView.requestFocus();
						angryFrame.setVisible(true);
					}
					else
					{
						angryFrame.setContentPane(angryMenuLoadView);
						angryMenuLoadView.requestFocus();
						angryFrame.setVisible(true);
					}
				}
				if(angryFrame.getContentPane()==angryMenuLevelView)
				{
					angryFrame.setContentPane(angryMenuDifficultyView);
					angryMenuDifficultyView.requestFocus();
					angryFrame.setVisible(true);
				}
				break;
			default:
				System.out.println("����������в���!");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(angryFrame.getContentPane()==angryMenuNewView)
			angryMenuNewView.requestFocus();
		
		if(angryFrame.getContentPane()==angryMenuLoadView)
			angryMenuLoadView.requestFocus();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
