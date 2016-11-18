package se;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class SmartPhoneFrame extends JFrame{ //스마트폰 프레임, 메뉴에서 킬 수 있다.
	SmartPhoneFrame(){ //디폴트 접근제한자 - 같은 패키지 + 자기 객체 내
		setSize(300, 500);
		setTitle("SmartPhone");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //완전한 종료를 위해! #참고 1
		
		SE.smartState(true); //스마프폰 프레임  상태, 같은 패키지 SE의 메소드 사용
		SE.mf.openSmart.setState(true); //메인프레임 메뉴 open
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){ //윈도우 종료 이벤트 #참고 2
				closeSmart();
			}
		});
		
		setVisible(true);
	}
	
	void closeSmart(){ //메인 프레임의 메뉴에서 사용해서 밖으로 빼놨음
		SE.smartState(false); //스마트폰 프레임 상태, 같은 패키지 SE의 메소드 사용
		SE.mf.openSmart.setState(false); //메인프레임 메뉴 open
		dispose(); //dispose = 지정 프레임 종료, exit = 모든 프레임 종료
	}
	
	void message(int money){ //shopPanel에서 결제시 사용
		System.out.println(money + " 팝업!");
	}
}

/*
#참고 1 setDefault 인자 설명
	http://junside.tistory.com/11
	 
#참고 2 서브 창 닫기
	http://blog.naver.com/PostView.nhn?blogId=wcwtmt&logNo=10172572539
*/