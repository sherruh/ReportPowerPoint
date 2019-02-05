package Work;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.*;

public class CreateSlide {
    private File file;
    private FileInputStream inputStream;
    private XMLSlideShow ppt;
    private CalcRectangleFor2Screenshots calcRectangleFor2Screenshots;
    public CreateSlide(File file){
        this.file=file;
        try {
            inputStream = new FileInputStream(this.file);
            ppt = new XMLSlideShow(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        calcRectangleFor2Screenshots=new CalcRectangleFor2Screenshots();
    }

    public void addEmptySlide(){
        ppt.createSlide();
        System.out.println("Added empty slides successfully!");
    }

    public void add2ScreenshotsSlide() {
        try {
            XSLFSlide slide = ppt.createSlide();
            for (int i = 1; i < 3; i++) {
                File image = new File(i + ".jpg");
                byte[] picture = new byte[0];
                picture = IOUtils.toByteArray(new FileInputStream(image));
                int idx = ppt.addPicture(picture, XSLFPictureData.PICTURE_TYPE_JPEG);
                XSLFPictureShape pic = slide.createPicture(idx);
                Rectangle rightRectangle= calcRectangleFor2Screenshots.getRightRectangle(pic.getAnchor(),i);
                pic.setAnchor(rightRectangle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
