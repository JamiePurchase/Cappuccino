package module.AnticsEditor.graphics;

import graphics.Fonts;
import java.awt.Font;

public class ModuleFonts extends Fonts
{

    public Font getFont(String style)
    {
        if(style=="Title"){return new Font("MV Boli", Font.BOLD, 22);}
        if(style=="Standard"){return new Font("Times New Roman", Font.PLAIN, 18);}
        return new Font("MV Boli", Font.PLAIN, 14);
    }
}