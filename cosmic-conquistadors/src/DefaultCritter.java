public class DefaultCritter {

    // Position
    private int X = 0;
    private int Y;

    // Constructor
    public DefaultCritter(){
        X = 0;
        Y = 0;
    }
    public DefaultCritter(int x, int y){
        X = x;
        Y = y;
    }

    // Get
    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    // Set
    public void setX(int x){
        X = x;
    }

    public void setY(int y){
        Y = y;
    }
}
