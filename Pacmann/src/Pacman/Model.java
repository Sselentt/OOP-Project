package Pacman;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.ImageIcon;
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
	private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
	
	private Image heart, ghost;
	private Image up, down, left, right;
	
	private int pacman_x, pacman_y, pacmand_x, pacmand_y;
	private int req_dx, req_dy;
	
	private final int validSpeeds[] = {1,2,3,4,6,8};
	private final int maxSpeed = 6;
	private int currentSpeed = 3;
	private short [] screenData;
	private Timer timer;
	
	private final short levelData[] = {
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
	
	public Model() {
		loadImages();
		�nitVariables();
		addKeyListener(new TAdapter());
		setFocusable(true);
		initGame();
	}
	
	private void loadImages() {
		down = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();
		up = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();
		left = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();
		right = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();
		ghost = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();
		heart = new ImageIcon("C://Users//Hp//OneDrive//Masa�st�//images").getImage();	
	}
	
	private void �nitVariables() {
		screenData = new short[N_BLOCKS * N_BLOCKS];
		d = new Dimension(400,400);
		ghost_x = new int [MAX_GHOSTS];
		ghost_dx = new int [MAX_GHOSTS];
		ghost_y = new int [MAX_GHOSTS];
		ghost_dy = new int [MAX_GHOSTS];
		ghostSpeed = new int [MAX_GHOSTS];
		dx = new int[4];
		dy = new int [4];
		
		timer = new Timer(40, this);
		timer.restart();
	}
	
	
	private void initGame( ) {
		lives = 3;
		score = 0;
		initLevel();
		N_GHOSTS = 6;
		currentSpeed = 3;
	}
	
	private void initLevel() {
		int i;
		for (i = 0; i< N_BLOCKS * N_BLOCKS; i++) {
			screenData[i] = levelData[i];
		}
	}
	
    private void playGame(Graphics2D g2d) {
    	
    	
    	
    }
    
    
	private void continueLevel() {

    	int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {

            ghost_y[i] = 4 * BLOCK_SIZE; 
            ghost_x[i] = 4 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostSpeed[i] = validSpeeds[random];
        }

        pacman_x = 7 * BLOCK_SIZE; 
        pacman_y = 11 * BLOCK_SIZE;
        pacmand_x = 0;	
        pacmand_y = 0;
        req_dx = 0;		
        req_dy = 0;
        dying = false;
    }
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame) {
            playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();

	}
	
	class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    initGame();
                }
            }
        }
}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
