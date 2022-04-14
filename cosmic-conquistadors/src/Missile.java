public class Missile extends DefaultCritter{

    // Fields
    private final double speedY, speedX;

    // Constructor
    public Missile(double x, double y, double degrees){
        super(x, y, 1.5, 8, degrees,  "images/missile.png");
        speedX = -Math.sin(Math.toRadians(degrees))*Speed;
        speedY = Math.cos(Math.toRadians(degrees))*Speed;
    }

    // Update the position of the enemy
    public boolean Move(){
        double newY = this.Y + speedY;
        double newX = this.X + speedX;
        if (newY <= InvaderGameState.scale && newX >= 0 && newX <= InvaderGameState.scale){
            this.Y = newY;
            this.X = newX;
            return true;
        }

        return false;
    }
}
