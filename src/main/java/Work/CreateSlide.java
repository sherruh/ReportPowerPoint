package Work;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.*;

public class CreateSlide {
    private File file;
    public CreateSlide(File file){
        this.file=file;
    }

    public void addEmptySlide(){
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(file);
            XMLSlideShow ppt = new XMLSlideShow(inputstream);
            XSLFSlide slide1 = ppt.createSlide();
            XSLFSlide slide2 = ppt.createSlide();
            FileOutputStream out = new FileOutputStream(file);
            ppt.write(out);
            System.out.println("Presentation edited successfully");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
