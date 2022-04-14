public class Shooter extends DefaultCritter{

    // Constructor
    public Shooter(double x, double y){
        super(x, y, 1.5, 15, 0,"images/shooter.png");
    }

    // Update the x position of the shooter
    public void Move(double dir){
        double newX = dir * this.Speed + this.X;
        if (newX <= InvaderGameState.scale && newX >= 0){
            X = newX;
        }
    }

    // Update the rotation angle of the shooter
    public void Rotate(double dir){
        double newDegrees = dir * this.Speed + this.Degrees;
        if (newDegrees <= 90 && -90 <= newDegrees){
            this.Degrees = newDegrees;
        }
    }
}
