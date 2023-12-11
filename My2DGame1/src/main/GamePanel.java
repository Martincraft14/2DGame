package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Currency;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable { // sub calse de JPanel
	// La pantalla del juego

	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16 x 16 tiles tamaño por defecto de jugadores np etc..
	final int scale = 3; // esto hara que se vea como un 48x48 en pantalla

	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16; // tamaño de la pantalla del juego por filas y columnas
	public final int maxScreenRow = 12; // 4:3
	public final int screeanWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	//FPS
	int FPS = 60;
	

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);

	public GamePanel() {

		this.setPreferredSize(new Dimension(screeanWidth, screenHeight)); // set the size of calss JPanel
		this.setBackground(Color.black); // color fondo
		this.setDoubleBuffered(true); // if true all drawing form this component wil be done in an offscreean painting
										// buffer
		this.addKeyListener(keyH); // the game panel recognice the key input
		this.setFocusable(true);

	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();

	}

	@Override
	public void run() { // es llamado automaticamente por el gameThread y se crea el Game Loop
		
		double drawInterval = 1000000000/FPS; // para el game loop vamos ha utilizar delta/accumulator metodo
		double delta = 0;						// las veces que se actualizara en nuestro caso 60FPS
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;						//comprobar FPS
		int drawCount = 0;
		
		
		
		while (gameThread != null) { // mientras el gameThread exista nos metomos aqui
				
			currentTime = System.nanoTime();					//al principio miramos el timpo actual
			
			delta += (currentTime - lastTime) / drawInterval;	//luego restamos el ultimo timepo por el actual para saber cuanto timepo ha pasado
			timer += (currentTime - lastTime);											
			lastTime = currentTime;									
			
			if (delta >= 1) {									//en cada bucle sumams el timpo pasado dividido por drawInterval a delta 
																//y cuando delta alcanze DrawInterval actualizamos y pintamos reeiniciando delta
				
				// 1 UPDATES: updte information such as character posicions
				update();

				// 2 DRAW: draw the screen with the updated information
				repaint(); // llama a paintComponente()
				
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}

	}

	public void update() {
		
		player.update();

	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}

}







