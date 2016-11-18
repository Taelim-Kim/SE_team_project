package se;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class SmartPhoneFrame extends JFrame{ //����Ʈ�� ������, �޴����� ų �� �ִ�.
	SmartPhoneFrame(){ //����Ʈ ���������� - ���� ��Ű�� + �ڱ� ��ü ��
		setSize(300, 500);
		setTitle("SmartPhone");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //������ ���Ḧ ����! #���� 1
		
		SE.smartState(true); //�������� ������  ����, ���� ��Ű�� SE�� �޼ҵ� ���
		SE.mf.openSmart.setState(true); //���������� �޴� open
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){ //������ ���� �̺�Ʈ #���� 2
				closeSmart();
			}
		});
		
		setVisible(true);
	}
	
	void closeSmart(){ //���� �������� �޴����� ����ؼ� ������ ������
		SE.smartState(false); //����Ʈ�� ������ ����, ���� ��Ű�� SE�� �޼ҵ� ���
		SE.mf.openSmart.setState(false); //���������� �޴� open
		dispose(); //dispose = ���� ������ ����, exit = ��� ������ ����
	}
	
	void message(int money){ //shopPanel���� ������ ���
		System.out.println(money + " �˾�!");
	}
}

/*
#���� 1 setDefault ���� ����
	http://junside.tistory.com/11
	 
#���� 2 ���� â �ݱ�
	http://blog.naver.com/PostView.nhn?blogId=wcwtmt&logNo=10172572539
*/