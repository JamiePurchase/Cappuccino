package module.Minstrel.graphics;

import graphics.Fonts;
import java.awt.Font;

public class ModuleFonts extends Fonts
{

    public static Font getFont(String style)
    {
        if(style=="MinstrelTitle"){return new Font("MV Boli", Font.BOLD, 24);}
        return new Font("MV Boli", Font.BOLD, 26);
    }
}