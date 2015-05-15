/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import engine.Game;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileRead
{
	public String readPath;
	
	public FileRead(String newPath)
	{
		readPath = Game.getResourcePath() + "data/" + newPath;
	}
	
	public String[] FileReadData() throws IOException
	{
		FileReader fr = new FileReader(readPath);
		BufferedReader tr = new BufferedReader(fr);
		int lineCount = FileReadLines();
		String[] textData = new String[lineCount];
		for(int line = 0; line < lineCount; line++)
		{
                    String thisLine  = tr.readLine();
                    if(!thisLine.substring(0, 2).equals("!!"))
                    {
                        textData[line] = thisLine;
                    }
		}
		tr.close();
		return textData;
	}
	
	private int FileReadLines() throws IOException
	{
		FileReader fr = new FileReader(readPath);
		BufferedReader bf = new BufferedReader(fr);
		int lineCount = 0;
		while(bf.readLine() != null)
		{
                    if(bf.readLine().substring(0, 2).equals("!!"))
                    {
                        // Comments in froth files are marked with !!
                        // They are completely ignored by the system
                    }
                    else {lineCount += 1;}
		}
		bf.close();
		return lineCount;
	}

}