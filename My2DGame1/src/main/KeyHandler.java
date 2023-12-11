package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler  implements KeyListener{
	
	public boolean upPressed, downPressed, rightPressed, leftPressed;

	@Override
	public void keyTyped(KeyEvent e) { // no lo usamos	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); // devuelve el numero de la tecla presionada
		
		if (code == KeyEvent.VK_W) { // si esta pulsando la tecla w entramos en el if
			upPressed = true;
		}
		if (code == KeyEvent.VK_S) { 
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) { 
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) { 
			rightPressed = true;
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) { 
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) { 
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) { 
			rightPressed = false;
		}

		
	}

}
