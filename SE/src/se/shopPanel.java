package se;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class shopPanel extends JPanel{ //MainFrame �Ҽ�
	JButton buy = new JButton("BUY!");
	
	shopPanel(){
		add(new JLabel("SHOP"));
		buy.addMouseListener(new BuyClicked());
		add(buy);
	}
	
	private class BuyClicked extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == buy){
				if(SE.smartState == true){ //����Ʈ���� �����־�� �Ѵ�.
					System.out.println("2000���� �����Ǿ����ϴ�.");
					SE.spf.message(2000); //����Ʈ���� ���� ���� �ѱ�
				}
			}
		}
	}
}
