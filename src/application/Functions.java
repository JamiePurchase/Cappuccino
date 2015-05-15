package application;

import java.text.SimpleDateFormat;
import java.util.*;

public class Functions
{
    public static Object[] arrayAppend(Object[] array, Object append)
    {
        array[array.length] = append;
        return array;
    }
    
    public static Object[] arrayCombine(Object[] array, Object[] combine)
    {
        Object[] result = new String[array.length + combine.length];
        for(int x = 0; x < array.length; x++)
        {
            result[x] = array[x];
        }
        for(int x = 0; x < combine.length; x++)
        {
            arrayAppend(result, combine[x]);
        }
        return result;
    }
    
    public static String getTimestamp()
    {
        return new SimpleDateFormat("ddMMyyyy").format(new Date());
    }
}