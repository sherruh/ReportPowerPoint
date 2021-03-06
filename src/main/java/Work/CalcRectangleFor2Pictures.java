package Work;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CalcRectangleFor2Pictures {

    public Rectangle getRightRectangle(Rectangle2D pictureRectangle,int numberOfPicture){
        double curWidth;
        double curHeight;
        final double rightWidth=355;
        final double rightHeight=350;
        final double centerOfSlide=360;
        double deltaX=numberOfPicture-1;
        curWidth=pictureRectangle.getWidth();
        curHeight=pictureRectangle.getHeight();
        double rate=curWidth/curHeight;
        while(!checkSize(curWidth,curHeight,rightWidth,rightHeight)){
            curWidth-=1;
            curHeight=curHeight-1/rate;
        }
        double xPosition=centerOfSlide*deltaX+Math.abs(centerOfSlide-curWidth)/2;
        return new Rectangle((int)xPosition,120,(int)curWidth,(int)curHeight);
    }

    protected boolean checkSize(double curWidth, double curHeight,double rightWidth,double rightHeight) {
        if (curWidth<=rightWidth && curHeight<=rightHeight){
            return true;
        }
        return false;
    }
}
