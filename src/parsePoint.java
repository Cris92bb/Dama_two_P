/**
 * Created by cris on 2/10/15.
 */
public class parsePoint {
    private int x;
    private int y;
    private char t;

    public parsePoint(int x, int y, char c){
        for(int i=0; i<=40*8; i+=40){
            if(x>=i && x<=i+40)
                this.x = i;
            if(y>=i && y<=i+40)
                this.y=i;
        }
        t=c;
    }
    public parsePoint(int x, int y){
        for(int i=0; i<=40*8; i+=40){
            if(x>=i && x<=i+40)
                this.x = i;
            if(y>=i && y<=i+40)
                this.y=i;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public char getT(){ return t;}
    public void seT(char c){
        t=c;
    }
}

