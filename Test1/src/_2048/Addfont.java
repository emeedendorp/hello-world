package _2048;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;


public class Addfont {

private static Font ttfBase = null;
private static Font VarySharky = null;
private static InputStream myStream = null;
private static final String FONT_PATH_VarySharky = "BADABB__.ttf";

public Font createFont() {


        try {
            myStream = new BufferedInputStream(
                    new FileInputStream(FONT_PATH_VarySharky));
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            VarySharky = ttfBase.deriveFont(Font.PLAIN, 24);               
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Font not loaded.");
        }
        return VarySharky;
}
}