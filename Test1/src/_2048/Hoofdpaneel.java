package _2048;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Hoofdpaneel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public Hoofdpaneel(){
		setLayout(new BorderLayout());
		Settings settings= new Settings();
		Model model = new Model(settings);
		View view = new View(model);
		add(view,BorderLayout.CENTER);
		view.setFocusable(true);
		view.addKeyListener(new MyKl(model));
	}
}
