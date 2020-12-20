package lab3.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader
{
    private String _path;

    public  FileReader(String path)
    {
        _path = path;
    }

    public byte[] getBytes()
    {
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream(_path);
            return fis.readAllBytes();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }
}
