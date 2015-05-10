package module.SteelSkirmish.graphics;

import graphics.Fonts;
import java.awt.Font;

public class ModuleFonts extends Fonts
{

    public Font getFont(String style)
    {
        if(style=="Debug"){return new Font("Courier", Font.BOLD, 18);}
        return new Font("MV Boli", Font.BOLD, 26);
    }
}