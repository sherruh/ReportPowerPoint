package Work;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CalcRectangleFor2Screenshots {
    private Rectangle2D rectangle2D;
    private double curWidth;
    private double curHeight;
    final private double rightWidth=355;
    final private double rightHeight=350;
    final private double centerOfSlide=360;


    public Rectangle getRightRectangle(Rectangle2D pictureRectangle,int numberOfPicture){
        numberOfPicture-=1;
        curWidth=pictureRectangle.getWidth();
        curHeight=pictureRectangle.getHeight();
        double rate=curWidth/curHeight;
        System.out.println("Initial: "+curWidth+" "+curHeight);
        while(!checkSize(curWidth,curHeight)){
            curWidth-=1;
            curHeight=curHeight-1/rate;
        }
        //double xPosition=

        //TODO calc x and y for rectangle
        System.out.println("Final: "+curWidth + " "+ curHeight);
        return new Rectangle(0,120,(int)curWidth,(int)curHeight);
    }

    private boolean checkSize(double curWidth, double curHeight) {
        if (curWidth<=rightWidth && curHeight<=rightHeight){
            return true;
        }
        return false;
    }
}
