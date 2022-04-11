public class Enemy extends DefaultCritter{
    private int state = 0;

    public Enemy(double x, double y){
        super(x, y, 5, 10, 0, "images/enemy.jpg");
    }

    public boolean Move(){
        if (state == 100){

            double newY = this.Y - this.Speed;
            if(newY < 10)
                return false;

            this.Y = newY;
            state = 0;
            return true;
        }
        else{

            state += 1;
            return true;
        }

    }
}
