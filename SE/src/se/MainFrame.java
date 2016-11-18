package se;

import java.awt.CardLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

class MainFrame extends JFrame{ //�⺻ ������ (atmPanel, createAccountPanel, shopPanel���� ����)
	private CardLayout cardLayout = new CardLayout(10, 10); //����, #���� 1
	
	private MenuBar mb = new MenuBar(); //�޴��� #���� 2
	
	private Menu move = new Menu("MOVE"); //atmPanel, shopPanel ���� �̵�
	private Menu open = new Menu("OPEN"); //����Ʈ�� ȭ�� ����
	
	private MenuItem moveToAtm = new MenuItem("ATM");
	private MenuItem moveToShop = new MenuItem("SHOP");
	
	static CheckboxMenuItem openSmart = new CheckboxMenuItem("Smart Phone", SE.smartState); 
			
	MainFrame(){ //����Ʈ ���������� - ���� ��Ű�� + �ڱ� ��ü ��
		setSize(500, 400);
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�����ִ� ��� ������ ����
		
		setLayout(cardLayout); 
		
		atmPanel atm = new atmPanel();
		createAccountPanel ca = new createAccountPanel();
		shopPanel shop = new shopPanel();
		
		add(atm, "atm");
		add(ca, "ca");
		add(shop, "shop");
		
		setMenubar(); //�޴��� �ٿ��ֱ�
		
		cardLayout.show(getContentPane(), "atm"); //�⺻ ȭ�� ����
		
		setVisible(true);
	}
	
	private void setMenubar(){ //�޴��� �ٿ��ֱ�
		setMenuBar(mb);
		
		mb.add(move);
		mb.add(open);
		
		move.add(moveToAtm);
		moveToAtm.addActionListener(new MoveMenuEvent()); //#����3
		move.addSeparator(); //������
		move.add(moveToShop);
		moveToShop.addActionListener(new MoveMenuEvent());
		
		open.add(openSmart);
		openSmart.addItemListener(new OpenMenuEvent()); //#���� 4
	}
	
	private class MoveMenuEvent implements ActionListener{ //�޴��� �̺�Ʈ
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == moveToAtm){
				cardLayout.show(getContentPane(), "atm"); //ȭ�� �ٲٱ�
			}
			else if(e.getSource() == moveToShop){
				cardLayout.show(getContentPane(), "shop"); //ȭ�� �ٲٱ�
			}
		}
	}
	
	private class OpenMenuEvent implements ItemListener{ //#���� 4
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){ //on
				if(SE.smartState == false){ //�������� ��
					SE.openSmart(); //����Ʈ�� �����ֱ�
				}	
			}
			else if(e.getStateChange() == ItemEvent.DESELECTED){ //off
				if(SE.smartState == true){ //�������� ��
					SE.closeSmart(); //����Ʈ�� �ݾ��ֱ�
				}
			}
		}
	}
}

/*
#���� 1 cardLayout ����
	http://blog.naver.com/since890513/220181967925
#���� 2 �޴��� �����
	http://blog.naver.com/munjh4200/50176425790
#���� 3 �̺�Ʈ (����/�ܺ�/����)
	http://blog.naver.com/jjonghun1004/220759522958
#���� 4 comboboxMenu �̺�Ʈ
	http://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=64571626&qb=amF2YSBDaGVja2JveE1lbnVJdGVtIGV2ZW50&enc=utf8&section=kin&rank=1&search_sort=0&spq=0&pid=TuxKewoRR00ssuLBQcCsssssssK-199922&sid=QaqSsqKwAMCM4REhspuv5w%3D%3D
	
*/