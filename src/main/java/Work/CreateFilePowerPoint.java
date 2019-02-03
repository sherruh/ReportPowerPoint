package Work;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.*;

public class CreateFilePowerPoint {
    File file;

    public File getFile() {
        return file;
    }

    public CreateFilePowerPoint(String name){
        XMLSlideShow ppt = new XMLSlideShow();
        file = new File(name+".pptx");
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(file);
            ppt.write(out);
            System.out.println("Presentation created successfully");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
