package Work;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.*;

public class CreateSlideFor2Operators {
    protected File file;
    protected FileInputStream inputStream;
    protected XMLSlideShow ppt;
    protected CalcRectangleFor2Pictures calcRectangleFor2Pictures =new CalcRectangleFor2Pictures();


    public CreateSlideFor2Operators(File file){
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
        ppt.setPageSize(new java.awt.Dimension(2048,1536));
        System.out.println("Added empty slides successfully!");
    }

    public void addPictresSlide(int startNumberOfPicture, int stopNumberOfPicture) {
        try {
            XSLFSlide slide = ppt.createSlide();
            for (int i = startNumberOfPicture; i <= stopNumberOfPicture; i++) {
                File image = new File(i + ".jpg");
                byte[] picture ;
                picture = IOUtils.toByteArray(new FileInputStream(image));
                int idx = ppt.addPicture(picture, XSLFPictureData.PICTURE_TYPE_JPEG);
                XSLFPictureShape pic = slide.createPicture(idx);
                Rectangle rightRectangle= calcRectangleFor2Pictures.getRightRectangle(pic.getAnchor(),i);
                pic.setAnchor(rightRectangle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile("Added slide with 2 screenshots successfully!");
    }

    void writeToFile(String message){
        FileOutputStream out;
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
