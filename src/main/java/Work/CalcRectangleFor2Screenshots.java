package Work;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CalcRectangleFor2Screenshots {
    private Rectangle2D rectangle2D;
    private double curWidth;
    private double curHeight;
    final private double rightWidth=355;
    final private double rightHeight=350;


    public Rectangle getRightRectangle(Rectangle2D pictureRectangle){
        curWidth=pictureRectangle.getWidth();
        curHeight=pictureRectangle.getHeight();
        double rate=curWidth/curHeight;
        while(!checkSize(curWidth,curHeight)){
            curWidth-=10;
            curHeight=curHeight-10/rate;
        }

        return new Rectangle();
    }

    private boolean checkSize(double curWidth, double curHeight) {
        if (curWidth<=rightWidth && curHeight<=rightHeight){
            return true;
        }
        return false;
    }
}
