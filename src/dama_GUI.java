import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cris on 2/10/15.
 */
public class dama_GUI extends JFrame implements MouseListener {
    //private int[][] scacchiera = new int[7][7];
    private ArrayList<parsePoint> puntiW = new ArrayList<parsePoint>();
    private ArrayList<parsePoint> puntiB = new ArrayList<parsePoint>();
    private parsePoint puntato;

    public dama_GUI(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(320,320));

        setPreferredSize(new Dimension(320,320));

        this.addMouseListener(this);

        Util.setPedineIniziali(puntiW,puntiB);
        pack();
        setResizable(false);
        setVisible(true);
    }


    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Util.traccia(g2);
        Iterator<parsePoint> puntIT = puntiW.iterator();
        if(puntiW != null){
            while(puntIT.hasNext()){

                Util.disegnaPedinaW(g2,puntIT.next());
            }}
        puntIT = puntiB.iterator();
        if(puntiB != null){
            while(puntIT.hasNext()){

                Util.disegnaPedinaB(g2, puntIT.next());
            }}

    }

    public static void main(String[] args){
        new dama_GUI();
    }

    
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x= mouseEvent.getX();
        int y= mouseEvent.getY();
        if(puntato==null){
         if(exist(new parsePoint(x,y))){
            puntato= new parsePoint(x,y);
            togli(puntato);
         }
        }
        else if(exist(new parsePoint(x,y))){

            if(mangia(new parsePoint(x,y))){
                togli(new parsePoint(x,y));
                puntato=null;}
        }else{
            if(sposta(puntato, new parsePoint(x, y)))
                puntato=null;

            else
                System.out.println("mossa non valida");


        }
    }
    public boolean mangia(parsePoint n){
        if(puntato.getT()=='w'){

            if(n.getX()==puntato.getX()+40){
                System.out.println("->w");
                if(sposta(n, new parsePoint(n.getX()+40,n.getY()+40)))
                    return true;
            }
            else if(n.getX()==puntato.getX()-40){
                    System.out.println("w<-");
                    if(sposta(n,new parsePoint(n.getX()-40,n.getY()+40)))
                     return  true;
                }
        }
        else  if(puntato.getT()=='b'){

            if(n.getX()==puntato.getX()+40){
                System.out.println("->b");
                if(sposta(n, new parsePoint(n.getX()+40,n.getY()-40)))
                    return true;
            }
            else if(n.getX()==puntato.getX()-40){
                System.out.println("b<-");
                if(sposta(n,new parsePoint(n.getX()-40,n.getY()-40)))
                    return  true;
            }
        }
        return false;
    }







    public void togli(parsePoint n){
        //System.out.println("cerco di togliere:");
        if(puntiW.remove(exInW(n)))
            n.seT('w');
        if(puntiB.remove(exInB(n)))
            n.seT('b');
        repaint();
    }
    public boolean sposta(parsePoint old, parsePoint nuovo){
        int x=40; int y=40;
        if(!exist(nuovo)){

        if(old.getY()==nuovo.getY() && old.getX()==nuovo.getX()){
            if(puntato.getT()=='w')
                puntiW.add(old);
            else if(old.getT()=='b')
                puntiB.add(old);

            repaint();
            return true;

        }
        if(puntato.getT()=='w'){
           if(((nuovo.getX()==old.getX()+x) || (nuovo.getX()==old.getX()-x)) && (nuovo.getY()==old.getY()+y)){
               nuovo.seT('w');
               puntiW.add(nuovo);
            repaint();
            return true;
           }
        }
        else if(puntato.getT()== 'b'){
            if(((nuovo.getX()==old.getX()-x) || (nuovo.getX()==old.getX()+x)) && (nuovo.getY()==old.getY()-y)){
                nuovo.seT('b');
                puntiB.add(nuovo);
                repaint();
                return true;
            }
        }
        }
        System.out.println("mossa non valida");

        repaint();
        return false;
    }


    public boolean exist(parsePoint np){
        if(exInW(np) !=null)
            return true;
        else if(exInB(np)!= null)
            return true;
        else return false;
    }

    public parsePoint exInW(parsePoint n){
        for(parsePoint w: puntiW){
            if(w.getX()== n.getX() && w.getY()==n.getY())
                return w;
        }
        return null;
    }
    public parsePoint exInB(parsePoint n){
        for(parsePoint b: puntiB){
            if(b.getY()==n.getY() && b.getX()==n.getX()){
                return b;
            }
        }
        return null;
    }









    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
