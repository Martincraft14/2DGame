package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame() ; // Asi se crea una ventana
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Podemos cerrar la ventana
		window.setResizable(false); // no redimensionable
		window.setTitle("2D Adventure"); // titulo
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();

		
		window.setLocationRelativeTo(null); // ventana en el centro de la pantalla
		window.setVisible(true);
		
		gamePanel.startGameThread();
		

	}

}