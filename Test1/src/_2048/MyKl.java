package _2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKl implements KeyListener{

	Model model;
	View view;
	
	public MyKl(Model model, View view){
		this.model= model;
		this.view = view;
	}
	

	public void keyPressed(KeyEvent e) {
		model.links();
		view.repaint();
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {

	}
}


