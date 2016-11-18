package se;

public class SE { //Software Engineer
	static boolean smartState = false; //����Ʈ�� ������ ���� (���� �� or ����), �ٸ� Ŭ�������� ����Ϸ��� static�� �پ���Ѵ�.
	static MainFrame mf = null;
	static SmartPhoneFrame spf = null;
	
	public static void main(String[] args) {
		openSmart(); //����Ʈ�� ������ ����
		mf = new MainFrame(); //�⺻ ������ (atmPanel, createAccountPanel, shopPanel���� ����)
	}
	
	static void smartState(boolean state){ //����Ʈ�� ������ ���� �ٲٱ�, ����Ʈ ���������� - ���� ��Ű�� + �ڱ� ��ü �� #���� 1
		smartState = state;
	}
	
	static void openSmart(){ //����Ʈ�� ������ ����
		spf = new SmartPhoneFrame(); //���� �������� �޴����� ����Ѵ�.
	}
	
	static void closeSmart(){ //����Ʈ�� ������ �ݱ�
		spf.closeSmart();
	}
}

/*
���� 1 ���� ������ ����
	http://bvc12.tistory.com/139
*/