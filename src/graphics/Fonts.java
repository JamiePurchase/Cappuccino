package graphics;

import engine.Game;
import java.awt.Font;

public class Fonts
{
    public static Font getFont(String style)
    {
        //return Game.getModule().getFonts().getFont(style);
        
        // Temp to avoid error until fixed
        return new Font("Courier", Font.BOLD, 18);
    }
}