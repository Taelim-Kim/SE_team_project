package se;

public class SE { //Software Engineer
	static boolean smartState = false; //스마트폰 프레임 상태 (실행 중 or 종료), 다른 클래스에서 사용하려면 static이 붙어야한다.
	static MainFrame mf = null;
	static SmartPhoneFrame spf = null;
	
	public static void main(String[] args) {
		openSmart(); //스마트폰 프레임 열기
		mf = new MainFrame(); //기본 프레임 (atmPanel, createAccountPanel, shopPanel으로 구성)
	}
	
	static void smartState(boolean state){ //스마트폰 프레임 상태 바꾸기, 디폴트 접근제한자 - 같은 패키지 + 자기 객체 내 #참고 1
		smartState = state;
	}
	
	static void openSmart(){ //스마트폰 프레임 열기
		spf = new SmartPhoneFrame(); //메인 프레임의 메뉴에서 사용한다.
	}
	
	static void closeSmart(){ //스마트폰 프레임 닫기
		spf.closeSmart();
	}
}

/*
참고 1 접근 제한자 설명
	http://bvc12.tistory.com/139
*/