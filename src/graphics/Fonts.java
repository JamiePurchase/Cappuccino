package graphics;

import java.awt.Font;

public class Fonts
{

	public static Font getFont(String style)
	{
		if(style=="Standard"){return new Font("Courier", Font.BOLD, 18);}
		return new Font("MV Boli", Font.BOLD, 26);
	}
}