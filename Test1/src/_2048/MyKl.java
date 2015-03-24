package _2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKl implements KeyListener{

	Model model;
	public MyKl(Model model){
		this.model= model;
	}
	

	public void keyPressed(KeyEvent e) {
		model.links();
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {

	}
}


