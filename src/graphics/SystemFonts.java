package graphics;

import java.awt.Font;

public class SystemFonts extends Fonts
{

    public Font getFont(String style)
    {
        if(style=="Standard"){return new Font("Courier", Font.BOLD, 18);}
        if(style=="Debug"){return new Font("Courier", Font.BOLD, 18);}
        return new Font("MV Boli", Font.BOLD, 26);
    }
}