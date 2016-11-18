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

class MainFrame extends JFrame{ //기본 프레임 (atmPanel, createAccountPanel, shopPanel으로 구성)
	private CardLayout cardLayout = new CardLayout(10, 10); //여백, #참고 1
	
	private MenuBar mb = new MenuBar(); //메뉴바 #참고 2
	
	private Menu move = new Menu("MOVE"); //atmPanel, shopPanel 사이 이동
	private Menu open = new Menu("OPEN"); //스마트폰 화면 열기
	
	private MenuItem moveToAtm = new MenuItem("ATM");
	private MenuItem moveToShop = new MenuItem("SHOP");
	
	static CheckboxMenuItem openSmart = new CheckboxMenuItem("Smart Phone", SE.smartState); 
			
	MainFrame(){ //디폴트 접근제한자 - 같은 패키지 + 자기 객체 내
		setSize(500, 400);
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //열려있는 모든 윈도우 종료
		
		setLayout(cardLayout); 
		
		atmPanel atm = new atmPanel();
		createAccountPanel ca = new createAccountPanel();
		shopPanel shop = new shopPanel();
		
		add(atm, "atm");
		add(ca, "ca");
		add(shop, "shop");
		
		setMenubar(); //메뉴바 붙여주기
		
		cardLayout.show(getContentPane(), "atm"); //기본 화면 띄우기
		
		setVisible(true);
	}
	
	private void setMenubar(){ //메뉴바 붙여주기
		setMenuBar(mb);
		
		mb.add(move);
		mb.add(open);
		
		move.add(moveToAtm);
		moveToAtm.addActionListener(new MoveMenuEvent()); //#참고3
		move.addSeparator(); //구분자
		move.add(moveToShop);
		moveToShop.addActionListener(new MoveMenuEvent());
		
		open.add(openSmart);
		openSmart.addItemListener(new OpenMenuEvent()); //#참고 4
	}
	
	private class MoveMenuEvent implements ActionListener{ //메뉴바 이벤트
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == moveToAtm){
				cardLayout.show(getContentPane(), "atm"); //화면 바꾸기
			}
			else if(e.getSource() == moveToShop){
				cardLayout.show(getContentPane(), "shop"); //화면 바꾸기
			}
		}
	}
	
	private class OpenMenuEvent implements ItemListener{ //#참고 4
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){ //on
				if(SE.smartState == false){ //닫혀있을 때
					SE.openSmart(); //스마트폰 열어주기
				}	
			}
			else if(e.getStateChange() == ItemEvent.DESELECTED){ //off
				if(SE.smartState == true){ //열려있을 때
					SE.closeSmart(); //스마트폰 닫아주기
				}
			}
		}
	}
}

/*
#참고 1 cardLayout 설명
	http://blog.naver.com/since890513/220181967925
#참고 2 메뉴바 만들기
	http://blog.naver.com/munjh4200/50176425790
#참고 3 이벤트 (내부/외부/무명)
	http://blog.naver.com/jjonghun1004/220759522958
#참고 4 comboboxMenu 이벤트
	http://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=64571626&qb=amF2YSBDaGVja2JveE1lbnVJdGVtIGV2ZW50&enc=utf8&section=kin&rank=1&search_sort=0&spq=0&pid=TuxKewoRR00ssuLBQcCsssssssK-199922&sid=QaqSsqKwAMCM4REhspuv5w%3D%3D
	
*/