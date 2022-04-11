public class Shooter extends DefaultCritter{

    public Shooter(double x, double y){
        super(x, y, 1.5, 10, 0,"images/shooter.jpg");
    }

    public void Move(double dir){
        double newX = dir * this.Speed + this.X;
        if (newX <= InvaderGameState.scale && newX >= 0){
            X = newX;
        }
    }

    public void Rotate(double dir){
        double newDegrees = dir * this.Speed + this.Degrees;
        if (newDegrees <= 90 && -90 <= newDegrees){
            this.Degrees = newDegrees;
        }
    }
}
