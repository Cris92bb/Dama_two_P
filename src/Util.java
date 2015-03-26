import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by cris on 2/10/15.
 */
public class Util {

    //private Rectangle rect = new Rectangle(0,0,40,40);
    private static Ellipse2D pd= new Ellipse2D.Double(0,0,40,40);
    private static AffineTransform DEFAULT;


    public static void traccia(Graphics2D g){
        DEFAULT= g.getTransform();
        int k=1;
        for(int i=0; i<320; i+=40){
            for(int j=0; j<320; j+=40)
            {
                g.setColor(Color.lightGray);
                if(k%2==0)
                    g.fillRect(i,j,40,40);
                 else
                    g.drawRect(i,j,40,40);
                k++;
            }
            k++;


    }}
    public static void disegnaPedinaW(Graphics2D g,parsePoint x){

        g.setTransform(DEFAULT);
        AffineTransform pt= new AffineTransform();
        pt.translate(x.getX(),x.getY());
        g.transform(pt);
        g.setColor(Color.black);
        g.draw(pd);
        g.setColor(Color.white);

        g.fill(pd);

    }
    public static void disegnaPedinaB(Graphics2D g,parsePoint x){

        g.setTransform(DEFAULT);
        AffineTransform pt= new AffineTransform();
        pt.translate(x.getX(),x.getY());
        g.transform(pt);
        g.setColor(Color.white);
        g.draw(pd);
        g.setColor(Color.black);

        g.fill(pd);

    }
    public static void setPedineIniziali(ArrayList<parsePoint> w, ArrayList<parsePoint> b ){
        int k =3;

        for(int i=0; i<=320; i+=40){

            for(int j=0; j<120; j+=40){

                if(k%2==0)
                    w.add(new parsePoint(i,j,'w'));

                k++;

            }

        }



        for(int i=0; i<=320; i+=40){
            for(int j=200; j<320; j+=40)
            {

                if(k%2==0)
                    b.add(new parsePoint(i,j,'b'));

                k++;
            }

        }

    }





}
