import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;


//make a description for each step, describing how each method works, etc.


public class Checkers extends JPanel {
	
	private boolean r, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11;
	private Rectangle red, red1, red2, red3, red4, red5, red6, red7, red8, red9, red10, red11 ;
	private boolean mover, move1r, move2r, move3r, move4r, move5r, move6r, move7r, move8r, move9r, move10r, move11r;
	private boolean movel, move1l, move2l, move3l, move4l, move5l, move6l, move7l, move8l, move9l, move10l, move11l;
	
	private boolean b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private Rectangle blue, blue1, blue2, blue3, blue4, blue5, blue6, blue7, blue8, blue9, blue10, blue11;
	private boolean movebr, move1br, move2br, move3br, move4br, move5br, move6br, move7br, move8br, move9br, move10br, move11br;
	private boolean movebl, move1bl, move2bl, move3bl, move4bl, move5bl, move6bl, move7bl, move8bl, move9bl, move10bl, move11bl;
	
	ArrayList<Rectangle> rectR;
	ArrayList<Rectangle> rectB;
	
	private boolean [] arrayB = {b, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11}; //highlight booleans
	private boolean [] arrayR = {r, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11}; //highlight booleans
	private boolean [] arrayMoveBr = {movebr, move1br, move2br, move3br, move4br, move5br, move6br, move7br, move8br, move9br, move10br, move11br};
	private boolean [] arrayMoveBl = {movebl, move1bl, move2bl, move3bl, move4bl, move5bl, move6bl, move7bl, move8bl, move9bl, move10bl, move11bl};
	
	private Rectangle leftIndicator, rightIndicator, leftIndicator2, rightIndicator2;
	private boolean skipR, skipL;
	
	private int redScore, blueScore;
	private Font redHeadliner, blueHeadliner, scoreR, scoreB;
	private JLabel redd, bluu;
	private JPanel panel;
	
	
	public Checkers()
	{
		red = new Rectangle(64, 0, 64, 64);
		red1 = new Rectangle(192, 0, 64, 64);
		red2 = new Rectangle(320, 0, 64, 64);
		red3 = new Rectangle(448, 0, 64, 64);
		red4 = new Rectangle(0, 64, 64,64);
		red5 = new Rectangle(128, 64, 64, 64);
		red6 = new Rectangle(256, 64, 64, 64);
		red7 = new Rectangle(384, 64, 64, 64);
		red8 = new Rectangle(64, 128, 64, 64);
		red9 = new Rectangle(192, 128, 64,64);
		red10 = new Rectangle(320, 128, 64,64);
		red11 = new Rectangle(448, 128, 64, 64);
		
		blue = new Rectangle(0, 320, 64,64);
		blue1 = new Rectangle(128,320, 64, 64);
		blue2 = new Rectangle(256, 320, 64, 64);
		blue3 = new Rectangle(384, 320, 64, 64);
		blue4 = new Rectangle(64, 384, 64, 64);
		blue5 = new Rectangle(192, 384, 64, 64);
		blue6 = new Rectangle(320, 384, 64,64);
		blue7 = new Rectangle(448, 384, 64, 64);
		blue8 = new Rectangle(0, 448, 64, 64);
		blue9 = new Rectangle(128, 448, 64, 64);
		blue10 = new Rectangle(256, 448, 64, 64);
		blue11 = new Rectangle(384, 448, 64, 64);
		
		leftIndicator = new Rectangle(0,0,64,64);
		rightIndicator = new Rectangle(0,0,64,64);
		leftIndicator2 = new Rectangle(0,0,64,64);
		rightIndicator2 = new Rectangle(0,0,64,64);
		
		rectR = new ArrayList<Rectangle>();
		rectR.add(red);
		rectR.add(red1);
		rectR.add(red2);
		rectR.add(red3);
		rectR.add(red4);
		rectR.add(red5);
		rectR.add(red6);
		rectR.add(red7);
		rectR.add(red8);
		rectR.add(red9);
		rectR.add(red10);
		rectR.add(red11);
		
		rectB = new ArrayList<Rectangle>();
		rectB.add(blue);
		rectB.add(blue1);
		rectB.add(blue2);
		rectB.add(blue3);
		rectB.add(blue4);
		rectB.add(blue5);
		rectB.add(blue6);
		rectB.add(blue7);
		rectB.add(blue8);
		rectB.add(blue9);
		rectB.add(blue10);
		rectB.add(blue11);
		
		redScore = 0;
		blueScore = 0;
		
		redHeadliner = new Font("Red Score", Font.PLAIN, 30);
		blueHeadliner = new Font("Blue Score", Font.PLAIN, 30);
		scoreR = new Font("---", Font.PLAIN, 30);
		scoreB = new Font("---", Font.PLAIN, 30);
		redd = new JLabel("");
		bluu = new JLabel("");
		
		
		
		
		addMouseListener(new CheckListener());
		
		setBackground(Color.red);
		setPreferredSize(new Dimension(1000,544));
		
		
		
	}
	

	public static boolean bound(int value, int left, int right) {
		boolean b;
		if ( value > left && value < right) {
			b = true;
		}
		else {
			b = false;
		}
		return b;
	}
	
	
	
	public void paint(Graphics g)
	{
		
		g.setFont(redHeadliner);
		g.drawString("Red Score", 600, 50);
		
		g.setFont(blueHeadliner);
		g.drawString("Blue Score", 800, 50);
		
		//g.setFont(scoreR);
		//g.drawString(redd.getText(), 650, 100);
		
		for (int col = 0; col < 8; col++) {//makes the checkers board
			int width = 64;
			int height = 64;
			int x = (col * 64)+16; 
			int y = 16;
			for (int row = 0; row < 8; row ++) {
				if (col % 2 ==0 && row % 2 ==0) {
					g.setColor(Color.white);
					g.fillRect(x, y, width, height);
					y = y + 64;
				}
				if (col % 2 == 0 && row % 2 !=0) {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(x, y, width, height);
					y = y + 64;
				}
				if (col % 2 !=0 && row % 2 ==0) {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(x, y, width, height);
					y = y + 64;
				}
				if (col % 2 != 0 && row % 2 != 0) {
					g.setColor(Color.white);
					g.fillRect(x, y, width, height);
					y = y + 64;
					
				}
			}
		}
				g.setColor(Color.red);
				g.fillOval(rectR.get(0).getX()+32, rectR.get(0).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(1).getX()+32, rectR.get(1).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(2).getX()+32, rectR.get(2).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(3).getX()+32, rectR.get(3).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(4).getX()+32, rectR.get(4).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(5).getX()+32, rectR.get(5).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(6).getX()+32, rectR.get(6).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(7).getX()+32, rectR.get(7).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(8).getX()+32, rectR.get(8).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(9).getX()+32, rectR.get(9).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(10).getX()+32, rectR.get(10).getY()+32, 32, 32);
				g.setColor(Color.red);
				g.fillOval(rectR.get(11).getX()+32, rectR.get(11).getY()+32, 32, 32);
				
				g.setColor(Color.blue);
				g.fillOval(rectB.get(0).getX()+32, rectB.get(0).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(1).getX()+32, rectB.get(1).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(2).getX()+32, rectB.get(2).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(3).getX()+32, rectB.get(3).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(4).getX()+32, rectB.get(4).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(5).getX()+32, rectB.get(5).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(6).getX()+32, rectB.get(6).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(7).getX()+32, rectB.get(7).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(8).getX()+32, rectB.get(8).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(9).getX()+32, rectB.get(9).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(10).getX()+32, rectB.get(10).getY()+32, 32, 32);
				g.setColor(Color.blue);
				g.fillOval(rectB.get(11).getX()+32, rectB.get(11).getY()+32, 32, 32);
				
				
				
				
			clickSquareRed(g);
			clickSquareBlue(g);
			updateRectBlue();
			updateRectRed();
			LabelRed(g);
			LabelBlue(g);
				
					
				}
	
	
	public void LabelRed(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(630, 60, 60, 60);
		g.setFont(scoreR);
		g.setColor(Color.RED);
		g.drawString(redd.getText(), 650, 100);
		
	}
	
	public void LabelBlue(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(830, 60, 60, 60);
		g.setFont(scoreB);
		g.setColor(Color.BLUE);
		g.drawString(bluu.getText(), 850, 100);
	}
	
	public boolean noneTheSameRed(Rectangle r) { //Used in clickSquareRed, makes sure that indicator fields are not equal to any of the pieces
		int count = 0;
		boolean b = false;
		for (int i = 0; i < arrayB.length; i++) {
			if (r.equals(rectB.get(i))) {
				count++;
			}
		}
		if (count == 0) {
			b = true;
		}
		else
		{
			b = false;
		}
		
		return b;
	}
	
	public boolean noneTheSameBlue(Rectangle r) { //Used in clickSquareBlue, makes sure that indicator fields are not equal to any of the pieces
		int count = 0;
		boolean b = false;
		for (int i = 0; i < arrayB.length; i++) {
			if (r.equals(rectR.get(i))) {
				count++;
			}
		}
		if (count == 0) {
			b = true;
		}
		else
		{
			b = false;
		}
		
		return b;
	}
	
	
	
	
	public void isClicked(boolean [] arr, int n) { //fixes the multiple highlighting
		for (int i = 0; i < arr.length; i++) {
			if (i != n) {
				arrayB[i] = false;
				arrayR[i] = false;
			}
			else if (i == n && arr.equals(arrayB)) {
				arrayB[i] = true;
				arrayR[i] = false;
			}
			else if (i == n && arr.equals(arrayR)) {
				arrayR[i] = true;
				arrayB[i] = false;
			}
		}
	}
	

	
	public void clickSquareBlue(Graphics g) {
		for (int i = 0; i < arrayB.length; i++) {
			if (arrayB[i] == true) {
				g.setColor(Color.yellow);
				g.drawOval(rectB.get(i).getX()+32, rectB.get(i).getY()+32, 32, 32);
				g.setColor(Color.yellow);
				g.drawOval(rectB.get(i).getX()+96, rectB.get(i).getY()-32, 32, 32);
				rightIndicator.changeRect(rectB.get(i).getX() + 64, rectB.get(i).getY() - 64);
				rightIndicator2.changeRect(rectB.get(i).getX() + 128, rectB.get(i).getY() - 128);
				for (int j = 0; j < arrayB.length; j++) {
					if (rightIndicator.equals(rectR.get(j))) {
							if (noneTheSameBlue(rightIndicator2)) {
								g.setColor(Color.yellow);
								g.drawOval(rectB.get(i).getX()+160, rectB.get(i).getY()-96, 32, 32);
								g.setColor(Color.green);
								g.drawOval(rectB.get(i).getX()+96, rectB.get(i).getY()-32, 32, 32);	
								skipR = true;
								rectR.get(j).changeRect(rectR.get(j).getX()-10000, rectR.get(j).getY()-1000);
								blueScore++;
						}
					}
				}
				g.setColor(Color.yellow);
				g.drawOval(rectB.get(i).getX()-32, rectB.get(i).getY()-32, 32, 32);
				leftIndicator.changeRect(rectB.get(i).getX()-64, rectB.get(i).getY()-64);
				leftIndicator2.changeRect(rectB.get(i).getX()-128, rectB.get(i).getY()-128);
				for (int a = 0; a < arrayR.length; a++) {
					if (leftIndicator.equals(rectR.get(a))) {
							if(noneTheSameBlue(leftIndicator2)) {
								g.setColor(Color.yellow);
								g.drawOval(rectB.get(i).getX()-96, rectB.get(i).getY()-96, 32, 32);
								g.setColor(Color.green);
								g.drawOval(rectB.get(i).getX()-32, rectB.get(i).getY()-32, 32, 32);
								skipL = true;
								rectR.get(a).changeRect(rectR.get(a).getX()-1000, rectR.get(a).getY()-1000);
								blueScore++;
							}
					}
				}
			}
		}
		
	}
	
	   public void updateRectBlue() {
		   if (movebr == true) {
			   if (skipR == true) {
					rectB.get(0).changeRect(rectB.get(0).getX()+128, rectB.get(0).getY()-128);
					skipR = false;
					movebr = false;
					arrayB[0] = false;
					repaint();
				}
			   else {
				   	rectB.get(0).changeRect(rectB.get(0).getX()+64, rectB.get(0).getY()-64);
			   		movebr = false;
			   		arrayB[0] = false;
			   		repaint();
			   }
		   }
		   else if (movebl == true) {
			   if (skipL == true) {
					rectB.get(0).changeRect(rectB.get(0).getX()-128, rectB.get(0).getY()-128);
					skipL = false;
					movebl = false;
					arrayB[0] = false;
					repaint();
				}
			   else {
				   	rectB.get(0).changeRect(rectB.get(0).getX()-64, rectB.get(0).getY()-64);
			   		movebl = false;
			   		arrayB[0] = false;
			   		repaint();
			   }
		   }
		  //--------------------------------------------------------------------- 
		   
		   if (move1br == true) {
			   if (skipR == true) {
					rectB.get(1).changeRect(rectB.get(1).getX()+128, rectB.get(1).getY()-128);
					skipR = false;
					move1br = false;
					arrayB[1] = false;
					repaint();
				}
			   else {
				    rectB.get(1).changeRect(rectB.get(1).getX()+64, rectB.get(1).getY()-64);
			   		move1br = false;
			   		arrayB[1] = false;
			   		repaint();
			   }
		   }
		   else if (move1bl == true) {
			   if (skipL == true) {
					rectB.get(1).changeRect(rectB.get(1).getX()-128, rectB.get(1).getY()-128);
					skipL = false;
					move1bl = false;
					arrayB[1] = false;
					repaint();
				}
			   else {
				   	rectB.get(1).changeRect(rectB.get(1).getX()-64, rectB.get(1).getY()-64);
			   		move1bl = false;
			   		arrayB[1] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move2br == true) {
			   if (skipR == true) {
					rectB.get(2).changeRect(rectB.get(2).getX()+128, rectB.get(2).getY()-128);
					skipR = false;
					move2br = false;
					arrayB[2] = false;
					repaint();
				}
			   else {
				   	rectB.get(2).changeRect(rectB.get(2).getX()+64, rectB.get(2).getY()-64);
			   		move2br = false;
			   		arrayB[2] = false;
			   		repaint();
			   }
		   }
		   else if (move2bl == true) {
			   if (skipL == true) {
					rectB.get(2).changeRect(rectB.get(2).getX()-128, rectB.get(2).getY()-128);
					skipL = false;
					move2bl = false;
					arrayB[2] = false;
					repaint();
				}
			   else {
				   	rectB.get(2).changeRect(rectB.get(2).getX()-64, rectB.get(2).getY()-64);
			   		move2bl = false;
			   		arrayB[2] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move3br == true) {
			   if (skipR == true) {
					rectB.get(3).changeRect(rectB.get(3).getX()+128, rectB.get(3).getY()-128);
					skipR = false;
					move3br = false;
					arrayB[3] = false;
					repaint();
				}
			   else {
				   	rectB.get(3).changeRect(rectB.get(3).getX()+64, rectB.get(3).getY()-64);
			   		move3br = false;
			   		arrayB[3] = false;
			   		repaint();
			   }
		   }
		   else if (move3bl == true) {
			   if (skipL == true) {
					rectB.get(3).changeRect(rectB.get(3).getX()-128, rectB.get(3).getY()-128);
					skipL = false;
					move3bl = false;
					arrayB[3] = false;
					repaint();
				}
			   else {
				   	rectB.get(3).changeRect(rectB.get(3).getX()-64, rectB.get(3).getY()-64);
			   		move3bl = false;
			   		arrayB[3] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move4br == true) {
			   if (skipR == true) {
					rectB.get(4).changeRect(rectB.get(4).getX()+128, rectB.get(4).getY()-128);
					skipR = false;
					move4br = false;
					arrayB[4] = false;
					repaint();
				}
			   else {
				   	rectB.get(4).changeRect(rectB.get(4).getX()+64, rectB.get(4).getY()-64);
			   		move4br = false;
			   		arrayB[4] = false;
			   		repaint();
			   }
		   }
		   else if (move4bl == true) {
			   if (skipL == true) {
					rectB.get(4).changeRect(rectB.get(4).getX()-128, rectB.get(4).getY()-128);
					skipL = false;
					move4bl = false;
					arrayB[4] = false;
					repaint();
				}
			   else {
				   	rectB.get(4).changeRect(rectB.get(4).getX()-64, rectB.get(4).getY()-64);
			   		move4bl = false;
			   		arrayB[4] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move5br == true) {
			   if (skipR == true) {
					rectB.get(5).changeRect(rectB.get(5).getX()+128, rectB.get(5).getY()-128);
					skipR = false;
					move5br = false;
					arrayB[5] = false;
					repaint();
				}
			   else {
				   	rectB.get(5).changeRect(rectB.get(5).getX()+64, rectB.get(5).getY()-64);
			   		move5br = false;
			   		arrayB[5] = false;
			   		repaint();
			   }
		   }
		   else if (move5bl == true) {
			   if (skipL == true) {
					rectB.get(5).changeRect(rectB.get(5).getX()-128, rectB.get(5).getY()-128);
					skipL = false;
					move5bl = false;
					arrayB[5] = false;
					repaint();
				}
			   else {
				   	rectB.get(5).changeRect(rectB.get(5).getX()-64, rectB.get(5).getY()-64);
			   		move5bl = false;
			   		arrayB[5] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move6br == true) {
			   if (skipR == true) {
					rectB.get(6).changeRect(rectB.get(6).getX()+128, rectB.get(6).getY()-128);
					skipR = false;
					move6br = false;
					arrayB[6] = false;
					repaint();
				}
			   else {
				   	rectB.get(6).changeRect(rectB.get(6).getX()+64, rectB.get(6).getY()-64);
			   		move6br = false;
			   		arrayB[6] = false;
			   		repaint();
			   }
		   }
		   else if (move6bl == true) {
			   if (skipL == true) {
					rectB.get(6).changeRect(rectB.get(6).getX()-128, rectB.get(6).getY()-128);
					skipL = false;
					move6bl = false;
					arrayB[6] = false;
					repaint();
				}
			   else {
				   	rectB.get(6).changeRect(rectB.get(6).getX()-64, rectB.get(6).getY()-64);
			   		move6bl = false;
			   		arrayB[6] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move7br == true) {
			   if (skipR == true) {
					rectB.get(7).changeRect(rectB.get(7).getX()+128, rectB.get(7).getY()-128);
					skipR = false;
					move7br = false;
					arrayB[7] = false;
					repaint();
				}
			   else {
				   	rectB.get(7).changeRect(rectB.get(7).getX()+64, rectB.get(7).getY()-64);
			   		move7br = false;
			   		arrayB[7] = false;
			   		repaint();
			   }
		   }
		   else if (move7bl == true) {
			   if (skipL == true) {
					rectB.get(7).changeRect(rectB.get(7).getX()-128, rectB.get(7).getY()-128);
					skipL = false;
					move7bl = false;
					arrayB[7] = false;
					repaint();
				}
			   else {
				   	rectB.get(7).changeRect(rectB.get(7).getX()-64, rectB.get(7).getY()-64);
			   		move7bl = false;
			   		arrayB[7] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move8br == true) {
			   if (skipR == true) {
					rectB.get(8).changeRect(rectB.get(8).getX()+128, rectB.get(8).getY()-128);
					skipR = false;
					move8br = false;
					arrayB[8] = false;
					repaint();
				}
			   else {
				   	rectB.get(8).changeRect(rectB.get(8).getX()+64, rectB.get(8).getY()-64);
			   		move8br = false;
			   		arrayB[8] = false;
			   		repaint();
			   }
		   }
		   else if (move8bl == true) {
			   if (skipL == true) {
					rectB.get(8).changeRect(rectB.get(8).getX()-128, rectB.get(8).getY()-128);
					skipL = false;
					move8bl = false;
					arrayB[8] = false;
					repaint();
				}
			   else {
				   	rectB.get(8).changeRect(rectB.get(8).getX()-64, rectB.get(8).getY()-64);
			   		move8bl = false;
			   		arrayB[8] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move9br == true) {
			   if (skipR == true) {
					rectB.get(9).changeRect(rectB.get(9).getX()+128, rectB.get(9).getY()-128);
					skipR = false;
					move9br = false;
					arrayB[9] = false;
					repaint();
				}
			   else {
				   	rectB.get(9).changeRect(rectB.get(9).getX()+64, rectB.get(9).getY()-64);
			   		move9br = false;
			   		arrayB[9] = false;
			   		repaint();
			   }
		   }
		   else if (move9bl == true) {
			   if (skipL == true) {
					rectB.get(9).changeRect(rectB.get(9).getX()-128, rectB.get(9).getY()-128);
					skipL = false;
					move9bl = false;
					arrayB[9] = false;
					repaint();
				}
			   else {
				   	rectB.get(9).changeRect(rectB.get(9).getX()-64, rectB.get(9).getY()-64);
			   		move9bl = false;
			   		arrayB[9] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move10br == true) {
			   if (skipR == true) {
					rectB.get(10).changeRect(rectB.get(10).getX()+128, rectB.get(10).getY()-128);
					skipR = false;
					move10br = false;
					arrayB[10] = false;
					repaint();
				}
			   else {
				   	rectB.get(10).changeRect(rectB.get(10).getX()+64, rectB.get(10).getY()-64);
			   		move10br = false;
			   		arrayB[10] = false;
			   		repaint();
			   }
		   }
		   else if (move10bl == true) {
			   if (skipL == true) {
					rectB.get(10).changeRect(rectB.get(10).getX()-128, rectB.get(10).getY()-128);
					skipL = false;
					move10bl = false;
					arrayB[10] = false;
					repaint();
				}
			   else {
				   	rectB.get(10).changeRect(rectB.get(10).getX()-64, rectB.get(10).getY()-64);
			   		move10bl = false;
			   		arrayB[10] = false;
			   		repaint();
			   }
		   }
		   //--------------------------------------------------------------------- 
		   
		   if (move11br == true) {
			   if (skipR == true) {
					rectB.get(11).changeRect(rectB.get(11).getX()+128, rectB.get(11).getY()-128);
					skipR = false;
					move11br = false;
					arrayB[11] = false;
					repaint();
				}
			   else {
				   	rectB.get(11).changeRect(rectB.get(11).getX()+64, rectB.get(11).getY()-64);
			   		move11br = false;
			   		arrayB[11] = false;
			   		repaint();
			   }
		   }
		   else if (move11bl == true) {
			   if (skipL == true) {
					rectB.get(11).changeRect(rectB.get(11).getX()-128, rectB.get(11).getY()-128);
					skipL = false;
					move11bl = false;
					arrayB[11] = false;
					repaint();
				}
			   else {
				   	rectB.get(11).changeRect(rectB.get(11).getX()-64, rectB.get(11).getY()-64);
			   		move11bl = false;
			   		arrayB[11] = false;
			   		repaint();
			   }
		   }
		
	   }

	   
	   
		public void clickSquareRed(Graphics g) { // core part of the engine
			for (int i = 0; i < arrayR.length; i++) {
				if (arrayR[i] == true) {
					g.setColor(Color.yellow);
					g.drawOval(rectR.get(i).getX()+32, rectR.get(i).getY()+32, 32, 32);
					g.setColor(Color.yellow);
					g.drawOval(rectR.get(i).getX()+96, rectR.get(i).getY()+96, 32, 32);//make method here that highlights the respective moves
					rightIndicator.changeRect(rectR.get(i).getX() + 64, rectR.get(i).getY() + 64);
					rightIndicator2.changeRect(rectR.get(i).getX() + 128, rectR.get(i).getY()+128);
					for (int j = 0; j < arrayR.length; j++) {
						if (rightIndicator.equals(rectB.get(j))) {
								if (noneTheSameRed(rightIndicator2)) {
									g.setColor(Color.yellow);
									g.drawOval(rectR.get(i).getX()+160, rectR.get(i).getY() +160, 32, 32);
									g.setColor(Color.green);
									g.drawOval(rectR.get(i).getX()+96, rectR.get(i).getY()+96, 32, 32);	
									skipR = true;
									rectB.get(j).changeRect(rectB.get(j).getX()-10000, rectB.get(j).getY()-1000);
									redScore++;
							}
						}
					}
					g.setColor(Color.yellow);
					g.drawOval(rectR.get(i).getX()-32, rectR.get(i).getY()+96, 32, 32);
					leftIndicator.changeRect(rectR.get(i).getX()-64, rectR.get(i).getY()+64);
					leftIndicator2.changeRect(rectR.get(i).getX()-128, rectR.get(i).getY()+128);
					for (int a = 0; a < arrayB.length; a++) {
						if (leftIndicator.equals(rectB.get(a))) {
								if(noneTheSameRed(leftIndicator2)) {
									g.setColor(Color.yellow);
									g.drawOval(rectR.get(i).getX()-96, rectR.get(i).getY()+160, 32, 32);
									g.setColor(Color.green);
									g.drawOval(rectR.get(i).getX()-32, rectR.get(i).getY()+96, 32, 32);
									skipL = true;
									rectB.get(a).changeRect(rectB.get(a).getX()-1000, rectB.get(a).getY()-1000);
									redScore++;
								
								}
						}
					}
				}
			}
		}
		
		
		
		
		public void updateRectRed() {//updates the rectangles coordinates after every move
			if (mover == true) {
				if (skipR == true) {
					rectR.get(0).changeRect(rectR.get(0).getX()+128, rectR.get(0).getY() +128);
					skipR = false;
					mover = false;
					arrayR[0] = false;
					repaint();
				}
				else {
				rectR.get(0).changeRect(rectR.get(0).getX()+64, rectR.get(0).getY()+64);
				mover = false;
				arrayR[0] = false;
				repaint();
				}
			}
				else if (movel == true) {
					if (skipL == true) {
						rectR.get(0).changeRect(rectR.get(0).getX()-128, rectR.get(0).getY()+128);
						skipL = false;
						movel = false;
						arrayR[0] = false;
						repaint();
					}
					else {
						rectR.get(0).changeRect(rectR.get(0).getX()-64, rectR.get(0).getY()+64);
						movel = false;
						arrayR[0] = false;
						repaint();
					}
				}
			
			if (move1r == true) {
				if (skipR == true) {
					rectR.get(1).changeRect(rectR.get(1).getX()+128, rectR.get(1).getY() +128);
					skipR = false;
					move9r = false;
					arrayR[1] = false;
					repaint();
				}
				else {
					rectR.get(1).changeRect(rectR.get(1).getX()+64, rectR.get(1).getY()+64);
					move1r = false;
					arrayR[1] = false;
					repaint();
				}
			}
				else if (move1l == true) {
					if (skipL == true) {
						rectR.get(1).changeRect(rectR.get(1).getX()-128, rectR.get(1).getY()+128);
						skipL = false;
						move1l = false;
						arrayR[1] = false;
						repaint();
					}
					else {
						rectR.get(1).changeRect(rectR.get(1).getX()-64, rectR.get(1).getY()+64);
						move1l = false;
						arrayR[1] = false;
						repaint();
					}
				}
			
			if (move2r == true) {
				if (skipR == true) {
					rectR.get(2).changeRect(rectR.get(2).getX()+128, rectR.get(2).getY() +128);
					skipR = false;
					move2r = false;
					arrayR[2] = false;
					repaint();
				}
				else {
					rectR.get(2).changeRect(rectR.get(2).getX()+64, rectR.get(2).getY()+64);
					move2r = false;
					arrayR[2] = false;
					repaint();
				}
			}
				else if (move2l == true) {
					if (skipL == true) {
						rectR.get(2).changeRect(rectR.get(2).getX()-128, rectR.get(2).getY()+128);
						skipL = false;
						move2l = false;
						arrayR[2] = false;
						repaint();
					}
					else {
						rectR.get(2).changeRect(rectR.get(2).getX()-64, rectR.get(2).getY()+64);
						move2l = false;
						arrayR[2] = false;
						repaint();
					}
				}
			
			if (move3r == true) {
				if (skipR == true) {
					rectR.get(3).changeRect(rectR.get(3).getX()+128, rectR.get(3).getY() +128);
					skipR = false;
					move3r = false;
					arrayR[3] = false;
					repaint();
				}
				else {
					rectR.get(3).changeRect(rectR.get(3).getX()+64, rectR.get(3).getY()+64);
					move3r = false;
					arrayR[3] = false;
					repaint();
				}
			}
				else if (move3l == true) {
					if (skipL == true) {
						rectR.get(3).changeRect(rectR.get(3).getX()-128, rectR.get(3).getY()+128);
						skipL = false;
						move3l = false;
						arrayR[3] = false;
						repaint();
					}
					else {
						rectR.get(3).changeRect(rectR.get(3).getX()-64, rectR.get(3).getY()+64);
						move3l = false;
						arrayR[3] = false;
						repaint();
					}
				}
			
			if (move4r == true) {
				if (skipR == true) {
					rectR.get(4).changeRect(rectR.get(4).getX()+128, rectR.get(4).getY() +128);
					skipR = false;
					move4r = false;
					arrayR[4] = false;
					repaint();
				}
				else {
					rectR.get(4).changeRect(rectR.get(4).getX()+64, rectR.get(4).getY()+64);
					move4r = false;
					arrayR[4] = false;
					repaint();
				}
			}
				else if (move4l == true) {
					if (skipL == true) {
						rectR.get(4).changeRect(rectR.get(4).getX()-128, rectR.get(4).getY()+128);
						skipL = false;
						move4l = false;
						arrayR[4] = false;
						repaint();
					}
					else {
						rectR.get(4).changeRect(rectR.get(4).getX()-64, rectR.get(4).getY()+64);
						move4l = false;
						arrayR[4] = false;
						repaint();
					}
				}
			
			if (move5r == true) {
				if (skipR == true) {
					rectR.get(5).changeRect(rectR.get(5).getX()+128, rectR.get(5).getY() +128);
					skipR = false;
					move5r = false;
					arrayR[5] = false;
					repaint();
				}
				else {
					rectR.get(5).changeRect(rectR.get(5).getX()+64, rectR.get(5).getY()+64);
					move5r = false;
					arrayR[5] = false;
					repaint();
				}
			}
				else if (move5l == true) {
					if (skipL == true) {
						rectR.get(5).changeRect(rectR.get(5).getX()-128, rectR.get(5).getY()+128);
						skipL = false;
						move5l = false;
						arrayR[5] = false;
						repaint();
					}
					else {
						rectR.get(5).changeRect(rectR.get(5).getX()-64, rectR.get(5).getY()+64);
						move5l = false;
						arrayR[5] = false;
						repaint();
					}
				}
			if (move6r == true) {
				if (skipR == true) {
					rectR.get(6).changeRect(rectR.get(6).getX()+128, rectR.get(6).getY() +128);
					skipR = false;
					move6r = false;
					arrayR[6] = false;
					repaint();
				}
				else {
					rectR.get(6).changeRect(rectR.get(6).getX()+64, rectR.get(6).getY()+64);
					move6r = false;
					arrayR[6] = false;
					repaint();
				}
			}
				else if (move6l == true) {
					if (skipL == true) {
						rectR.get(6).changeRect(rectR.get(6).getX()-128, rectR.get(6).getY()+128);
						skipL = false;
						move6l = false;
						arrayR[6] = false;
						repaint();
					}
					else {
						rectR.get(6).changeRect(rectR.get(6).getX()-64, rectR.get(6).getY()+64);
						move6l = false;
						arrayR[6] = false;
						repaint();
					}
				}
			
			if (move7r == true) {
				if (skipR == true) {
					rectR.get(7).changeRect(rectR.get(7).getX()+128, rectR.get(7).getY() +128);
					skipR = false;
					move7r = false;
					arrayR[7] = false;
					repaint();
				}
				else {
					rectR.get(7).changeRect(rectR.get(7).getX()+64, rectR.get(7).getY()+64);
					move7r = false;
					arrayR[7] = false;
					repaint();
				}
			}
				else if (move7l == true) {
					if (skipL == true) {
						rectR.get(7).changeRect(rectR.get(7).getX()-128, rectR.get(7).getY()+128);
						skipL = false;
						move7l = false;
						arrayR[7] = false;
						repaint();
					}
					else {
						rectR.get(7).changeRect(rectR.get(7).getX()-64, rectR.get(7).getY()+64);
						move7l = false;
						arrayR[7] = false;
						repaint();
					}
				}
			
			if (move8r == true) {
				if (skipR == true) {
					rectR.get(8).changeRect(rectR.get(8).getX()+128, rectR.get(8).getY() +128);
					skipR = false;
					move8r = false;
					arrayR[8] = false;
					repaint();
				}
				else {
					rectR.get(8).changeRect(rectR.get(8).getX()+64, rectR.get(8).getY()+64);
					move8r = false;
					arrayR[8] = false;
					repaint();
				}
			}
			else if (move8l == true) {
				if (skipL == true) {
					rectR.get(8).changeRect(rectR.get(8).getX()-128, rectR.get(8).getY()+128);
					skipL = false;
					move8l = false;
					arrayR[8] = false;
					repaint();
				}
				else {
					rectR.get(8).changeRect(rectR.get(8).getX()-64, rectR.get(8).getY()+64);
					move8l = false;
					arrayR[8] = false;
					repaint();
				}
			}
			if (move9r == true) {
				if (skipR == true) {
					rectR.get(9).changeRect(rectR.get(9).getX()+128, rectR.get(9).getY() +128);
					skipR = false;
					move9r = false;
					arrayR[9] = false;
					repaint();
				}
				else {
					rectR.get(9).changeRect(rectR.get(9).getX()+64, rectR.get(9).getY()+64);
					move9r = false;
					arrayR[9] = false;
					repaint();
				}
			}
			else if (move9l == true) {
				if (skipL == true) {
					rectR.get(9).changeRect(rectR.get(9).getX()-128, rectR.get(9).getY()+128);
					skipL = false;
					move9l = false;
					arrayR[9] = false;
					repaint();
				}
				else {
					rectR.get(9).changeRect(rectR.get(9).getX()-64, rectR.get(9).getY()+64);
					move9l = false;
					arrayR[9] = false;
					repaint();
				}
			}
			
			if (move10r == true) {
				if (skipR == true) {
					rectR.get(10).changeRect(rectR.get(10).getX()+128, rectR.get(10).getY() +128);
					skipR = false;
					move10r = false;
					arrayR[10] = false;
					repaint();
				}
				else {
					rectR.get(10).changeRect(rectR.get(10).getX()+64, rectR.get(10).getY()+64);
					move10r = false;
					arrayR[10] = false;
					repaint();
				}
			}
				else if (move10l == true) {
					if (skipL == true) {
						rectR.get(10).changeRect(rectR.get(10).getX()-128, rectR.get(10).getY()+128);
						skipL = false;
						move10l = false;
						arrayR[10] = false;
						repaint();
					}
					else {
						rectR.get(10).changeRect(rectR.get(10).getX()-64, rectR.get(10).getY()+64);
						move10l = false;
						arrayR[10] = false;
						repaint();
					}
				}
			
			if (move11r == true) {
				if (skipR == true) {
					rectR.get(11).changeRect(rectR.get(11).getX()+128, rectR.get(11).getY() +128);
					skipR = false;
					move11r = false;
					arrayR[11] = false;
					repaint();
				}
				else {
					rectR.get(11).changeRect(rectR.get(11).getX()+64, rectR.get(11).getY()+64);
					move11r = false;
					arrayR[11] = false;
					repaint();
				}
			}
				else if (move11l == true) {
					if (skipL == true) {
						rectR.get(11).changeRect(rectR.get(11).getX()-128, rectR.get(11).getY()+128);
						skipL = false;
						move11l = false;
						arrayR[11] = false;
						repaint();
					}
					else {
						rectR.get(11).changeRect(rectR.get(11).getX()-64, rectR.get(11).getY()+64);
						move11l = false;
						arrayR[11] = false;
						repaint();
					}
				}
			
			
			
			
		}
		
		
		
		
	
		private class CheckListener implements MouseListener, ActionListener
		{
			
			
			
			public void mouseClicked(MouseEvent event) {
				
				//blue conditions
				
				if (bound(event.getX(), rectB.get(0).getX(), rectB.get(0).getX()+64) && 
					bound(event.getY(), rectB.get(0).getY(), rectB.get(0).getY()+64)) {
					arrayB[0] = true; // dont really need this statement, isClicked sets it to true but keep it for simplicity.
					isClicked(arrayB, 0);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(1).getX(), rectB.get(1).getX()+64) && 
					bound(event.getY(), rectB.get(1).getY(), rectB.get(1).getY()+64)) {
					arrayB[1] = true;
					isClicked(arrayB, 1);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(2).getX(), rectB.get(2).getX()+64) && 
					bound(event.getY(), rectB.get(2).getY(), rectB.get(2).getY()+64)) {
					arrayB[2] = true;
					isClicked(arrayB, 2);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(3).getX(), rectB.get(3).getX()+64) && 
					bound(event.getY(), rectB.get(3).getY(), rectB.get(3).getY()+64)) {
					arrayB[3] = true;
					isClicked(arrayB, 3);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(4).getX(), rectB.get(4).getX()+64) && 
					bound(event.getY(), rectB.get(4).getY(), rectB.get(4).getY()+64)) {
					arrayB[4] = true;
					isClicked(arrayB, 4);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(5).getX(), rectB.get(5).getX()+64) && 
					bound(event.getY(), rectB.get(5).getY(), rectB.get(5).getY()+64)) {
					arrayB[5] = true;
					isClicked(arrayB, 5);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(6).getX(), rectB.get(6).getX()+64) && 
					bound(event.getY(), rectB.get(6).getY(), rectB.get(6).getY()+64)) {
					arrayB[6] = true;
					isClicked(arrayB, 6);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(7).getX(), rectB.get(7).getX()+64) && 
					bound(event.getY(), rectB.get(7).getY(), rectB.get(7).getY()+64)) {
					arrayB[7] = true;
					isClicked(arrayB, 7);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(8).getX(), rectB.get(8).getX()+64) && 
					bound(event.getY(), rectB.get(8).getY(), rectB.get(8).getY()+64)) {
					arrayB[8] = true;
					isClicked(arrayB, 8);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(9).getX(), rectB.get(9).getX()+64) && 
					bound(event.getY(), rectB.get(9).getY(), rectB.get(9).getY()+64)) {
					arrayB[9] = true;
					isClicked(arrayB, 9);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(10).getX(), rectB.get(10).getX()+64) && 
					bound(event.getY(), rectB.get(10).getY(), rectB.get(10).getY()+64)) {
					arrayB[10] = true;
					isClicked(arrayB, 10);
					repaint();
				}
				
				if (bound(event.getX(), rectB.get(11).getX(), rectB.get(11).getX()+64) && 
					bound(event.getY(), rectB.get(11).getY(), rectB.get(11).getY()+64)) {
					arrayB[11] = true;
					isClicked(arrayB, 11);
					repaint();
				}
				
				
				if (arrayB[0] == true) {
					if (bound(event.getX(), rectB.get(0).getX()+64, rectB.get(0).getX()+128) &&
						bound(event.getY(), rectB.get(0).getY()-64, rectB.get(0).getY())) {
							movebr = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(0).getX()-64, rectB.get(0).getX()) && 
							 bound(event.getY(), rectB.get(0).getY()-64, rectB.get(0).getY())) {
								movebl = true;
								repaint();
					}
				}
				
				
				if (arrayB[1] == true) {
					if (bound(event.getX(), rectB.get(1).getX()+64, rectB.get(1).getX()+128) &&
						bound(event.getY(), rectB.get(1).getY()-64, rectB.get(1).getY())) {
							move1br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(1).getX()-64, rectB.get(1).getX()) && 
							 bound(event.getY(), rectB.get(1).getY()-64, rectB.get(1).getY())) {
								move1bl = true;
								repaint();
					}
				}
				
				if (arrayB[2] == true) {
					if (bound(event.getX(), rectB.get(2).getX()+64, rectB.get(2).getX()+128) &&
						bound(event.getY(), rectB.get(2).getY()-64, rectB.get(2).getY())) {
							move2br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(2).getX()-64, rectB.get(2).getX()) && 
							 bound(event.getY(), rectB.get(2).getY()-64, rectB.get(2).getY())) {
								move2bl = true;
								repaint();
					}
				}
				
				if (arrayB[3] == true) {
					if (bound(event.getX(), rectB.get(3).getX()+64, rectB.get(3).getX()+128) &&
						bound(event.getY(), rectB.get(3).getY()-64, rectB.get(3).getY())) {
							move3br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(3).getX()-64, rectB.get(3).getX()) && 
							 bound(event.getY(), rectB.get(3).getY()-64, rectB.get(3).getY())) {
								move3bl = true;
								repaint();
					}
				}
				
				if (arrayB[4] == true) {
					if (bound(event.getX(), rectB.get(4).getX()+64, rectB.get(4).getX()+128) &&
						bound(event.getY(), rectB.get(4).getY()-64, rectB.get(4).getY())) {
							move4br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(4).getX()-64, rectB.get(4).getX()) && 
							 bound(event.getY(), rectB.get(4).getY()-64, rectB.get(4).getY())) {
								move4bl = true;
								repaint();
					}
				}
				
				if (arrayB[5] == true) {
					if (bound(event.getX(), rectB.get(5).getX()+64, rectB.get(5).getX()+128) &&
						bound(event.getY(), rectB.get(5).getY()-64, rectB.get(5).getY())) {
							move5br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(5).getX()-64, rectB.get(5).getX()) && 
							 bound(event.getY(), rectB.get(5).getY()-64, rectB.get(5).getY())) {
								move5bl = true;
								repaint();
					}
				}
				
				if (arrayB[6] == true) {
					if (bound(event.getX(), rectB.get(6).getX()+64, rectB.get(6).getX()+128) &&
						bound(event.getY(), rectB.get(6).getY()-64, rectB.get(6).getY())) {
							move6br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(6).getX()-64, rectB.get(6).getX()) && 
							 bound(event.getY(), rectB.get(6).getY()-64, rectB.get(6).getY())) {
								move6bl = true;
								repaint();
					}
				}
				
				if (arrayB[7] == true) {
					if (bound(event.getX(), rectB.get(7).getX()+64, rectB.get(7).getX()+128) &&
						bound(event.getY(), rectB.get(7).getY()-64, rectB.get(7).getY())) {
							move7br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(7).getX()-64, rectB.get(7).getX()) && 
							 bound(event.getY(), rectB.get(7).getY()-64, rectB.get(7).getY())) {
								move7bl = true;
								repaint();
					}
				}
				
				if (arrayB[8] == true) {
					if (bound(event.getX(), rectB.get(8).getX()+64, rectB.get(8).getX()+128) &&
						bound(event.getY(), rectB.get(8).getY()-64, rectB.get(8).getY())) {
							move8br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(8).getX()-64, rectB.get(8).getX()) && 
							 bound(event.getY(), rectB.get(8).getY()-64, rectB.get(8).getY())) {
								move8bl = true;
								repaint();
					}
				}
				
				if (arrayB[9] == true) {
					if (bound(event.getX(), rectB.get(9).getX()+64, rectB.get(9).getX()+128) &&
						bound(event.getY(), rectB.get(9).getY()-64, rectB.get(9).getY())) {
							move9br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(9).getX()-64, rectB.get(9).getX()) && 
							 bound(event.getY(), rectB.get(9).getY()-64, rectB.get(9).getY())) {
								move9bl = true;
								repaint();
					}
				}
				
				if (arrayB[10] == true) {
					if (bound(event.getX(), rectB.get(10).getX()+64, rectB.get(10).getX()+128) &&
						bound(event.getY(), rectB.get(10).getY()-64, rectB.get(10).getY())) {
							move10br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(10).getX()-64, rectB.get(10).getX()) && 
							 bound(event.getY(), rectB.get(10).getY()-64, rectB.get(10).getY())) {
								move10bl = true;
								repaint();
					}
				}
				
				if (arrayB[11] == true) {
					if (bound(event.getX(), rectB.get(11).getX()+64, rectB.get(11).getX()+128) &&
						bound(event.getY(), rectB.get(11).getY()-64, rectB.get(11).getY())) {
							move11br = true;
							repaint();
					}
					else if (bound(event.getX(), rectB.get(11).getX()-64, rectB.get(11).getX()) && 
							 bound(event.getY(), rectB.get(11).getY()-64, rectB.get(11).getY())) {
								move11bl = true;
								repaint();
					}
				}
				
				
				
			//red conditions------------------------------------------------------------------------------------------------------
				
				
				if (bound(event.getX()-16, rectR.get(0).getX(), rectR.get(0).getX()+64) && 
					bound(event.getY()-16, rectR.get(0).getY(), rectR.get(0).getY()+64)) {
					arrayR[0] = true;
					isClicked(arrayR, 0);
					repaint();	
					}
				
				if (bound(event.getX()-16, rectR.get(1).getX(), rectR.get(1).getX()+64) && 
					bound(event.getY()-16, rectR.get(1).getY(), rectR.get(1).getY()+64)) {
					arrayR[1] = true;
					isClicked(arrayR, 1);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(2).getX(), rectR.get(2).getX()+64) && 
					bound(event.getY()-16, rectR.get(2).getY(), rectR.get(2).getY()+64)) {
					arrayR[2] = true;
					isClicked(arrayR, 2);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(3).getX(), rectR.get(3).getX()+64) && 
					bound(event.getY()-16, rectR.get(3).getY(), rectR.get(3).getY()+64)) {
					arrayR[3] = true;
					isClicked(arrayR, 3);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(4).getX(), rectR.get(4).getX()+64) && 
					bound(event.getY()-16, rectR.get(4).getY(), rectR.get(4).getY()+64)) {
					arrayR[4] = true;
					isClicked(arrayR, 4);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(5).getX(), rectR.get(5).getX()+64) && 
					bound(event.getY()-16, rectR.get(5).getY(), rectR.get(5).getY()+64)) {
					arrayR[5] = true;
					isClicked(arrayR, 5);
					repaint();
				}
				
				
				if (bound(event.getX()-16, rectR.get(6).getX(), rectR.get(6).getX()+64) && 
					bound(event.getY()-16, rectR.get(6).getY(), rectR.get(6).getY()+64)) {
					arrayR[6] = true;
					isClicked(arrayR, 6);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(7).getX(), rectR.get(7).getX()+64) && 
					bound(event.getY()-16, rectR.get(7).getY(), rectR.get(7).getY()+64)) {
					arrayR[7] = true;
					isClicked(arrayR, 7);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(8).getX(), rectR.get(8).getX()+64) && 
					bound(event.getY()-16, rectR.get(8).getY(), rectR.get(8).getY()+64)) {
					arrayR[8] = true;
					isClicked(arrayR, 8);
					repaint();
					}
				
				if (bound(event.getX()-16, rectR.get(9).getX(), rectR.get(9).getX()+64) && 
					bound(event.getY()-16, rectR.get(9).getY(), rectR.get(9).getY()+64)) {
					arrayR[9] = true;
					isClicked(arrayR, 9);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(10).getX(), rectR.get(10).getX()+64) && 
					bound(event.getY()-16, rectR.get(10).getY(), rectR.get(10).getY()+64)) {
					arrayR[10] = true;
					isClicked(arrayR, 10);
					repaint();
				}
				
				if (bound(event.getX()-16, rectR.get(11).getX(), rectR.get(11).getX()+64) && 
					bound(event.getY()-16, rectR.get(11).getY(), rectR.get(11).getY()+64)) {
					arrayR[11] = true;
					isClicked(arrayR, 11);
					repaint();
				}
				
				
			
				if (arrayR[0] == true) {
					if (bound(event.getX()-16, rectR.get(0).getX() + 64, rectR.get(0).getX() + 128) && 
						bound(event.getY()-16, rectR.get(0).getY() + 64, rectR.get(0).getY()+128)  ) {
							mover = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(0).getX()-64, rectR.get(0).getX()) && 
							 bound(event.getY()-16, rectR.get(0).getY()+64, rectR.get(0).getY()+128) ) {
								movel = true;
								repaint();
								
					}
				}
				
				if (arrayR[1] == true) {
					if (bound(event.getX()-16, rectR.get(1).getX() + 64, rectR.get(1).getX() + 128) && 
						bound(event.getY()-16, rectR.get(1).getY() + 64, rectR.get(1).getY()+128)  ) {
							move1r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(1).getX()-64, rectR.get(1).getX()) && 
							 bound(event.getY()-16, rectR.get(1).getY()+64, rectR.get(1).getY()+128) ) {
								move1l = true;
								repaint();
								
					}
				}
				
				if (arrayR[2] == true) {
					if (bound(event.getX()-16, rectR.get(2).getX() + 64, rectR.get(2).getX() + 128) && 
						bound(event.getY()-16, rectR.get(2).getY() + 64, rectR.get(2).getY()+128)  ) {
							move2r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(2).getX()-64, rectR.get(2).getX()) && 
							 bound(event.getY()-16, rectR.get(2).getY()+64, rectR.get(2).getY()+128) ) {
								move2l = true;
								repaint();
								
					}
				}
				
				if (arrayR[3] == true) {
					if (bound(event.getX()-16, rectR.get(3).getX() + 64, rectR.get(3).getX() + 128) && 
						bound(event.getY()-16, rectR.get(3).getY() + 64, rectR.get(3).getY()+128)  ) {
							move3r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(3).getX()-64, rectR.get(3).getX()) && 
							 bound(event.getY()-16, rectR.get(3).getY()+64, rectR.get(3).getY()+128) ) {
								move3l = true;
								repaint();
								
					}
				}
				
				if (arrayR[4] == true) {
					if (bound(event.getX()-16, rectR.get(4).getX() + 64, rectR.get(4).getX() + 128) && 
						bound(event.getY()-16, rectR.get(4).getY() + 64, rectR.get(4).getY()+128)  ) {
							move4r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(4).getX()-64, rectR.get(4).getX()) && 
							 bound(event.getY()-16, rectR.get(4).getY()+64, rectR.get(4).getY()+128) ) {
								move4l = true;
								repaint();
								
					}
				}
				
				if (arrayR[5] == true) {
					if (bound(event.getX()-16, rectR.get(5).getX() + 64, rectR.get(5).getX() + 128) && 
						bound(event.getY()-16, rectR.get(5).getY() + 64, rectR.get(5).getY()+128)  ) {
							move5r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(5).getX()-64, rectR.get(5).getX()) && 
							 bound(event.getY()-16, rectR.get(5).getY()+64, rectR.get(5).getY()+128) ) {
								move5l = true;
								repaint();
								
					}
				}
				
				if (arrayR[6] == true) {
					if (bound(event.getX()-16, rectR.get(6).getX() + 64, rectR.get(6).getX() + 128) && 
						bound(event.getY()-16, rectR.get(6).getY() + 64, rectR.get(6).getY()+128)  ) {
							move6r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(6).getX()-64, rectR.get(6).getX()) && 
							 bound(event.getY()-16, rectR.get(6).getY()+64, rectR.get(6).getY()+128) ) {
								move6l = true;
								repaint();
								
					}
				}
				
				if (arrayR[7] == true) {
					if (bound(event.getX()-16, rectR.get(7).getX() + 64, rectR.get(7).getX() + 128) && 
						bound(event.getY()-16, rectR.get(7).getY() + 64, rectR.get(7).getY()+128)  ) {
							move7r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(7).getX()-64, rectR.get(7).getX()) && 
							 bound(event.getY()-16, rectR.get(7).getY()+64, rectR.get(7).getY()+128) ) {
								move7l = true;
								repaint();
								
					}
				}
				
				if (arrayR[8] == true) {
					if (bound(event.getX()-16, rectR.get(8).getX() + 64, rectR.get(8).getX() + 128) && 
						bound(event.getY()-16, rectR.get(8).getY() + 64, rectR.get(8).getY()+128)  ) {
							move8r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(8).getX()-64, rectR.get(8).getX()) && 
							 bound(event.getY()-16, rectR.get(8).getY()+64, rectR.get(8).getY()+128) ) {
								move8l = true;
								repaint();
								
					}
				}
				
				if (arrayR[9] == true) {
					if (bound(event.getX()-16, rectR.get(9).getX() + 64, rectR.get(9).getX() + 128) && 
						bound(event.getY()-16, rectR.get(9).getY() + 64, rectR.get(9).getY()+128)  ) {
							move9r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(9).getX()-64, rectR.get(9).getX()) && 
							 bound(event.getY()-16, rectR.get(9).getY()+64, rectR.get(9).getY()+128) ) {
								move9l = true;
								repaint();
								
					}
				}
				
				if (arrayR[10] == true) {
					if (bound(event.getX()-16, rectR.get(10).getX() + 64, rectR.get(10).getX() + 128) && 
						bound(event.getY()-16, rectR.get(10).getY() + 64, rectR.get(10).getY()+128)  ) {
							move10r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(10).getX()-64, rectR.get(10).getX()) && 
							 bound(event.getY()-16, rectR.get(10).getY()+64, rectR.get(10).getY()+128) ) {
								move10l = true;
								repaint();
								
					}
				}
				
				if (arrayR[11] == true) {
					if (bound(event.getX()-16, rectR.get(11).getX() + 64, rectR.get(11).getX() + 128) && 
						bound(event.getY()-16, rectR.get(11).getY() + 64, rectR.get(11).getY()+128)  ) {
							move11r = true;
							repaint();
					}
					else if (bound(event.getX()-16, rectR.get(11).getX()-64, rectR.get(11).getX()) && 
							 bound(event.getY()-16, rectR.get(11).getY()+64, rectR.get(11).getY()+128) ) {
								move11l = true;
								repaint();
								
					}
				}
				
				
				redd.setText(Integer.toString(redScore));
				bluu.setText(Integer.toString(blueScore));
				

			}
			
			
			
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {		
			}
			public void mousePressed(MouseEvent event) {	
			}
			public void mouseReleased(MouseEvent arg0) {	
			}


			
			public void actionPerformed(ActionEvent event) {
				
				
			}


			
			
				
				
			
			
		}
		
			

		
		
		class Rectangle  {
			
			private int x;
			private int y;
			private int width;
			private int height;
			
			public Rectangle(int x, int y, int width, int height) {
				this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
			}
			


			public int getX() {
				return x;
			}
			
			public int getY() {
				return y;
			}
			
			public int getWidth() {
				return width;
			}
			
			public int getHeight() {
				return height;
			}
			
			public void changeRect(int x, int y) {
				this.x = x;
				this.y = y;
			}
			
			public boolean equals(Rectangle r) {
				if (getX() == r.getX() && getY() == r.getY()) {
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			

		}


}
		




