public class DefaultCritter implements Critter{

    // Fields
    public double X, Y, Speed, Size;
    public String Picture;

    // Constructor
    public DefaultCritter(double x, double y, double speed, double size, String picture){
        X = x;
        Y = y;
        Speed = speed;
        Size = size;
        Picture = picture;
    }

    // Draw
    public void Draw(){
        StdDraw.picture(X, Y, Picture, 0);
    }

    // Return True if this and critter are in contact, false otherwise
    public boolean IsContact(DefaultCritter critter){
        if (this.X + this.Size >= critter.X + critter.Size && this.Y + this.Size >= critter.Y + critter.Size){
            return true;
        }
        return false;
    }
}