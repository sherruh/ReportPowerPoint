package Work;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CalcRectangleFor2Screenshots {
    private double curWidth;
    private double curHeight;
    final private double rightWidth=355;
    final private double rightHeight=350;


    public Rectangle getRightRectangle(Rectangle2D pictureRectangle){
        curWidth=pictureRectangle.getWidth();
        curHeight=pictureRectangle.getHeight();
        double rate=curWidth/curHeight;
        while(!checkSize(curWidth,curHeight)){

        }

        return new Rectangle();
    }

    private boolean checkSize(double curWidth, double curHeight) {
        return curWidth <= rightWidth && curHeight <= rightHeight;
    }
}
