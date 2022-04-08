public class DefaultCritter {

    // Position
    private int X;
    private int Y;
    private int height;
    private int width;

    // Get
    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public int getHeight(){ return height;}

    public int getWidth(){ return width;}

    // Set
    public void setX(int x){
        X = x;
    }

    public void setY(int y){
        Y = y;
    }

    public void setHeight(int Height){ height = Height;}

    public void setWidth(int Width){ width = Width;}

    //Methods
    public void goLeft(){
        X -= 1;
    }

    public void goRight(){
        X += 1;
    }

    public void goUp(){
        Y +=1 ;
    }

    public void goDown(){
        Y -= 1;
    }
}
