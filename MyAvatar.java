import java.applet.Applet;
import java.awt.*;

public class MyAvatar extends Applet {
	protected Font font = new Font("Arial", Font.BOLD, 13);

	public void init() {
	}

	public void paint(Graphics g) {
		/*
		 * //Background g.setColor(Color.MAGENTA); g.fillRect(0,0,360,360);
		 * g.setColor(Color.BLUE); g.fillRect(10,10,340,340);
		 */

		// long hair
		g.setColor(Color.BLACK);
		g.fillOval(65, 110, 60, 200);
		g.fillOval(215, 110, 60, 200);
		
								

		// ears
		Color c = new Color(255, 230, 180);
		Color c1 = new Color(233, 169, 105);
		g.setColor(c1);
		g.drawArc(85, 160, 30, 50, 0, 360);
		g.drawArc(225, 160, 30, 50, 0, 360);
		g.setColor(c);
		g.fillArc(85, 160, 30, 50, 0, 360);
		g.fillArc(225, 160, 30, 50, 0, 360);
		
		//inner ears
		g.setColor(c1);
		g.fillArc(90, 170, 20, 30, 0, 360);
		g.fillArc(230, 170, 20, 30, 0, 360);
		g.setColor(Color.BLACK);
		g.drawLine(99, 180, 99, 190);
		g.drawLine(242, 180, 242, 190);
			
		
		// Face
		g.setColor(c);
		g.fillArc(100, 100, 140, 180, 0, 360);

		// Faceline
		g.setColor(c1);
		g.drawArc(100, 100, 140, 180, 0, 360);

		/*
		//Bangs shadow
		Color c7 = new Color(98, 84, 53);
		g.setColor(c7);
		g.fillOval(130, 120, 20, 20);
		g.fillOval(190, 120, 20, 20);
		*/
		
		// Bangs
		g.setColor(Color.BLACK);
		g.fillOval(130, 80, 50, 50);
		g.fillOval(160, 80, 50, 50);
		g.fillOval(90, 85, 50, 50);
		g.fillOval(200, 85, 50, 50);
		
								
		//eyebrows
		g.setColor(Color.BLACK);
		g.fillRect(135,135,20,1);
		g.fillRect(185,135,20,1);
		g.fillRect(134,136,21,2);
		g.fillRect(185,136,21,2);
				
		//eyes shadows (not the cosmetics)
		Color c9 = new Color(95, 77, 59);
		g.setColor(c9);
		g.fillOval(130, 145, 30, 30);
		g.fillOval(180, 145, 30, 30);
		//I need to draw these because I haven't sleep much since I started this homework. ;p

		
		// eyes
		Color c2 = new Color(255, 255, 255);
		g.setColor(c2);
		g.fillOval(130, 140, 30, 30);
		g.fillOval(180, 140, 30, 30);

		// eyeballs
		Color c3 = new Color(38, 30, 11);
		g.setColor(c3);
		g.fillOval(140, 150, 10, 10);
		g.fillOval(190, 150, 10, 10);

		// mouth
		Color c5 = new Color(246, 147, 147);
		g.setColor(c5);
		g.fillArc(145, 210, 50, 50, 180, 180);
		Color c6 = new Color(250, 75, 75);
		g.setColor(c6);
		g.fillArc(155, 240, 30, 30, 0, 180);
		g.fillArc(155, 252, 30, 6, 180, 180);
		
		//cheeks
		g.setColor(Color.PINK);
		g.drawLine(130, 205, 125, 200);
		g.drawLine(130, 210, 125, 205);
		g.drawLine(215, 205, 210, 200);
		g.drawLine(215, 210, 210, 205);

		// nose
		Color c4 = new Color(233, 169, 105);
		g.setColor(c4);
		g.fillArc(145, 160, 50, 50, 240, 60);
		
		// nosetrils
		g.setColor(Color.BLACK);
		g.drawLine(167, 209, 165, 209);
		g.drawLine(175, 209, 173, 209);

		// my nickname
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Pie", 300, 300);

	}

}