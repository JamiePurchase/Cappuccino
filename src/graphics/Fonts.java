package graphics;

import java.awt.Font;

public class Fonts
{

	public static Font getFont(String style)
	{
		if(style=="Standard"){return new Font("Courier", Font.BOLD, 18);}
                // note: move these to modules
                if(style=="MinstrelTitle"){return new Font("MV Boli", Font.BOLD, 24);}
		return new Font("MV Boli", Font.BOLD, 26);
	}
}