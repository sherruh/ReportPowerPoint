package Work;

public class App 
{
    public static void main( String[] args )
    {
        CreateFilePowerPoint file=new CreateFilePowerPoint("Test1");
        CreateSlide slide1=new CreateSlide(file.getFile());
    }
}
