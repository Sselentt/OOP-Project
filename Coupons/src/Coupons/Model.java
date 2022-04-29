package Coupons;

import java.awt.Image;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Model extends JPanel implements ActionListener {
	
	private Dimension d;
	private final Font smallFont = new Font ("Arial", Font.BOLD, 14);
	private boolean inGame = false;
	private boolean dying = false;
	
	private final int BLOCK_SIZE = 24;
	private final int N_BLOCKS = 15;
	private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
	private final int MAX_SECURITYMAN = 12;
	private final int SHE_SPEED = 6;
	
	private int N_SECURITYMAN =6;
	private int lives, score;
	private int [] dx, dy;
	private int [] securýtyman_x, securýtyman_y, securýtyman_dx, securýtyman_dy, securýtymanSpeed;
	
	private Image heart, securýtyman;
	private Image up, down, left, right;
	
	
	
	
	

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		
		
	}
}
