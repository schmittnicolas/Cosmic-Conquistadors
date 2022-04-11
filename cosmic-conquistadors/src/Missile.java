public class Missile extends DefaultCritter{

    public Missile(double x, double y){
        super(x, y, 1.5, 5, 0,  "images/missile.png");
    }

    public boolean Move(){
        double newY = this.Y + this.Speed;
        if (newY <= InvaderGameState.scale){
            this.Y = newY;
            return true;
        }

        return false;
    }
}
