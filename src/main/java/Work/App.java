package Work;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {
        CreateFilePowerPoint filePpt=new CreateFilePowerPoint("Test1");
        CreateSlide createSlide=new CreateSlide(filePpt.getFile());
        createSlide.addEmptySlide();
    }
}
