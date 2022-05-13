package Pacman;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Model extends JPanel implements ActionListener{

	private Dimension d;
	private final Font smallFont = new Font("Perpetua Titling MT", Font.BOLD, 14);
	private boolean inGame = false;
	private boolean dying = false;
	
	private final int BLOCK_SIZE = 24;
	private final int N_BLOCKS = 24;
	private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
	private final int MAX_GHOSTS = 14;
	private final int PACMAN_SPEED = 7;
	
	private int N_GHOSTS = 8;
	private int lives, score;
	private int [] dx, dy;
	private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghsotSpeed;
	
	private Image heart, ghsot;
	private Image up, down, left, right;
	
	private int pacman_x, pacman_y, pacmand_x, pacmand_y;
	private int req_dx, req_dy;
	
	private final int validSpeeds[] = {1,2,3,4,6,8};
	private final int maxSpeed = 6;
	private int currentSpeed = 3;
	private short [] screenData;
	private Timer timer;
	
	private final short leveData[] = {
			19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
	        17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
	        25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
	        0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
	        19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
	        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
	        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
	        17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
	        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
	        17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
	        21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
	        17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
	        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
	        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
	        25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
	};
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
