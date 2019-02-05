package Work;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CreateSlideFor3Operators extends CreateSlideFor2Operators {
    public CreateSlideFor3Operators(File file) {
        super(file);
    }

    @Override
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
        writeToFile("Added slide with 3 screenshots successfully!");
    }
}
