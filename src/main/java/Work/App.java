package Work;

public class App
{
    public static void main( String[] args )
    {
        String name="Test1";//set by user
        int numberOfOperators=2;//set by user
        int numberOfPictures=2;//set by user
        CreateFilePowerPoint filePpt=new CreateFilePowerPoint(name);
        if(numberOfOperators==2){
            createReportFor2Operators(name,numberOfPictures,filePpt);
        }else if(numberOfOperators==3){
            //createReportFor3Operators();
        }
    }

    private static void createReportFor2Operators(String name,int numberOfPictures,CreateFilePowerPoint filePpt) {
        CreateSlideFor2Operators createSlideFor2Operators =new CreateSlideFor2Operators(filePpt.getFile());
        createSlideFor2Operators.addEmptySlide();
        createSlideFor2Operators.addPictresSlide(1,2);
    }
}
