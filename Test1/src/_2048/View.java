package _2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class View extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Model model;
	Settings settings;
	int x, y, newx, newy;
	int breedte, hoogte;
	int rijen, kolommen;
	Color background, foreground;
	ArrayList<Integer> waarden;
	Font font;
	FontMetrics fm;
	
	public View(Model model){
		
		this.model = model;
		this.settings = model.getSettings();	
		this.x = settings.getXpos();
		this.y = settings.getYpos();
		this.breedte = settings.getBreedte();
		this.hoogte = settings.getHoogte();
		this.background = settings.getBackground();
		this.foreground = settings.getForeground();
		this.rijen = settings.getRijen();
		this.kolommen = settings.getKolommen();
		this.font = settings.getFont1();
		
		this.waarden = new ArrayList<Integer>(rijen*kolommen);
		for (int i = 0; i< rijen* kolommen; i++){
			waarden.add(0);
		}
			int beginwaarde1 = (int)(Math.random()*rijen*kolommen);
			waarden.set(beginwaarde1, 2);
			//voor een extra beginwaarde
			int beginwaarde2 = (int)(Math.random()*rijen*kolommen);
			while (beginwaarde1 == beginwaarde2)	
				beginwaarde2 = (int)(Math.random()*rijen*kolommen);
			waarden.set(beginwaarde2, 2);
	}
	

	public void paintComponent (Graphics g){
		super.paintComponent(g);
			teken(g);
			tekenhokjes(g);
	}
	
	
	public void teken(Graphics g){
		//achtergrond
		g.setColor(background);
		g.fillRect(x, y, breedte, hoogte);
		g.setColor(foreground);
		//horizontale lijnen
		for (int i = 0; i<= rijen; i++){
			g.drawLine(x, y+(i*hoogte/rijen), x+breedte, y+(i*hoogte/rijen));
		}
		//verticale lijnen
		for (int i = 0; i<= kolommen; i++){
			g.drawLine(x +(i*breedte/kolommen), y, x+(i*breedte/kolommen), y+hoogte);
		}
		if (model.isLost()){
			//TODO 
			System.out.println("Geen mogelijkheden meer!");
		}
			
	}
		

	public void tekenhokjes(Graphics g){
		int aantalhokjes = rijen * kolommen;
		int startx = x, starty = y;
		Font font1 = new Addfont().createFont();
		g.setFont(font1);
		fm = g.getFontMetrics();
		for (int i = 0; i < aantalhokjes; i++){
			g.setColor(Color.YELLOW);
			g.drawRect(startx, starty, breedte/kolommen, hoogte/rijen);
			if (waarden.get(i) !=0){
			//if (waarden[i] != 0){
				String word = ""+ waarden.get(i);

				int woordlengte = fm.stringWidth(word);
				int regelhoogte = fm.getHeight();
				int startpositiex = startx + (breedte/kolommen - woordlengte) / 2;
				int startpositiey = starty + (hoogte/rijen + regelhoogte) / 2;
				g.drawString(""+ waarden.get(i), startpositiex , startpositiey);
			}
			startx = startx + breedte/kolommen;
			if (i % kolommen == kolommen-1){
				startx = x;
				starty = starty + hoogte / rijen;
			}
		}
	}
}




	
	