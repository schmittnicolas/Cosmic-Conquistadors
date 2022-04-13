public class Missile extends DefaultCritter{

    public Missile(double x, double y ,double angle){
        super(x, y, 1.5, 5, angle,  "images/missile.png");
    }

    // function to control movement of missile
    public boolean Move() {
        double myDegrees = this.Degrees / 180 * Math.PI; // convert to radians
        double newY = this.Y + (this.Speed*Math.sin(myDegrees + (Math.PI/2))); // calculate next y value
        double newX = this.X + (this.Speed*Math.cos(myDegrees + (Math.PI/2))); // calculate next x value
        if (newX < InvaderGameState.scale && newY < InvaderGameState.scale && newX > 0 && newY > 0) {
            this.Y = newY;
            this.X = newX;
            return true;
        }
        return false;
    }    
    
    /*public boolean Move(){
        double newY = this.Y + this.Speed;
        if (newY <= InvaderGameState.scale){
            this.Y = newY;
            return true;
        }

        return false;
    }*/
}
