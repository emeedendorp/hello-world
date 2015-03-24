package _2048;

import java.awt.Color;
import java.awt.Font;

public class Settings {
	
	int rijen, kolommen,breedte, hoogte, xpos, ypos;
	Color background, foreground;
	Font font1;
	
	public Settings(){
		xpos = 20;
		ypos = 20;
		breedte = 400;
		hoogte = 400;
		rijen = 4;
		kolommen = 4;
		background = (Color.GRAY);
		foreground = (Color.BLACK);
		font1 = new Addfont().createFont();
	}

	public Font getFont1() {
		return font1;
	}

	public void setFont1(Font font1) {
		this.font1 = font1;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public void setRijen(int rijen) {
		this.rijen = rijen;
	}

	public void setKolommen(int kolommen) {
		this.kolommen = kolommen;
	}

	public int getRijen() {
		return rijen;
	}

	public int getKolommen() {
		return kolommen;
	}
}
