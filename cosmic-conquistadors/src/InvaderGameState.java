import java.util.List;

public class InvaderGameState {

    public static int width = 100;
    public static int height = 100;
    public static int updateTime = 100;

    public Missile[] missiles;
    public Enemy[] enemies;
    public Shooter shooter;
    public int score;

    // Constructor
    public InvaderGameState(){
        missiles = new Missile[100];
        enemies = new Enemy[100];
        shooter = new Shooter(width/2, 5, 1, 1, "shooter.png");
    }
}
