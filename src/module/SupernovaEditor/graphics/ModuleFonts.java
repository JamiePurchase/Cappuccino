package module.SupernovaEditor.graphics;

import graphics.Fonts;
import java.awt.Font;

public class ModuleFonts extends Fonts
{    
    public Font getFont(String style)
    {
        System.out.println("ModuleGame.getFont(" + style + ")");
        if(style.equals("FrameTitle")) {return new Font("MV Boli", Font.PLAIN, 28);}
        if(style.equals("Standard")) {return new Font("MV Boli", Font.PLAIN, 22);}
        return new Font("MV Boli", Font.PLAIN, 22);
    }
}