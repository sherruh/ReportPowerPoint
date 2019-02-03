package Work;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {
        CreateFilePowerPoint filePpt=new CreateFilePowerPoint("Test1");
        CreateSlide slide1=new CreateSlide(filePpt.getFile());
    }
}
