package se;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class shopPanel extends JPanel{ //MainFrame 소속
	JButton buy = new JButton("BUY!");
	
	shopPanel(){
		add(new JLabel("SHOP"));
		buy.addMouseListener(new BuyClicked());
		add(buy);
	}
	
	private class BuyClicked extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == buy){
				if(SE.smartState == true){ //스마트폰이 열려있어야 한다.
					System.out.println("2000원이 결제되었습니다.");
					SE.spf.message(2000); //스마트폰에 결제 정보 넘김
				}
			}
		}
	}
}
