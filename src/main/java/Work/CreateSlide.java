package Work;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.*;

public class CreateSlide {
    private File file;
    private FileInputStream inputStream;
    private XMLSlideShow ppt;
    public CreateSlide(File file){
        this.file=file;
        try {
            inputStream = new FileInputStream(this.file);
            ppt = new XMLSlideShow(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEmptySlide(){
        ppt.createSlide();
        System.out.println("Added empty slides successfully!");
    }

    public void add2ScreenshotsSlide(){
        ppt.createSlide();
        writeToFile("Added slide with 2 screenshots successfully!");

    }

    public void writeToFile(String message){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            ppt.write(out);
            System.out.println(message);
            out.close();
            openFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void openFile(){
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
