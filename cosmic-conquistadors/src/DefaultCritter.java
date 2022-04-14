public class DefaultCritter implements Critter{

    // Fields
    // Position
    public double X, Y;

    // Parameter
    public double Speed, Size, Degrees;
    public String Picture;

    // Constructor for a default critter
    public DefaultCritter(double x, double y, double speed, double size, double degrees,  String picture){
        X = x;
        Y = y;
        Speed = speed;
        Size = size;
        Picture = picture;
        Degrees = degrees;
    }

    // The method is called at each update of the game to redraw the critter
    public void Draw(){
        StdDraw.picture(X, Y, Picture, Size, Size, Degrees);
    }

    // Return True if this and critter are in contact, false otherwise
    public boolean IsContact(DefaultCritter critter){
        double dist = (this.Size + critter.Size)/4;
        if (Math.abs(this.X - critter.X) <= dist && Math.abs(this.Y - critter.Y) <= dist){
            return true;
        }
        return false;
    }
}