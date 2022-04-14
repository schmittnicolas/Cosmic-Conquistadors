public class Enemy extends DefaultCritter{

    // Fields
    private int state = 0; // state is used to know when the enemy should update his position
    private int dir = 1; // represents the direction, if it is equal to 1 the enemy goes to the right and if it is equal to -1 the enemy goes to the left
    private final int moveTime = 300; // represents the end of the movement cycle of the enemy

    public Enemy(double x, double y){
        super(x, y, 5, 12, 0, "images/enemy.png");
    }

    public boolean Move(){

        if (state == moveTime){
            double newY = this.Y - this.Speed;
            if (newY < 10)
                return false;

            this.Y = newY;
            state = -49;
            dir = -dir;
        }
        else{
            if (state == moveTime/2){

                // the enemy changes its direction
                dir = -dir;
            }

            if (state % 50 == 0){

                // Update the position of the enemy
                this.X += this.Speed*dir;
            }
            state++;
        }

        return true;
    }
}
