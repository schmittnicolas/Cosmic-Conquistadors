import java.awt.event.KeyEvent;
import java.util.ArrayList; // Array Lists can be resized compared to normal arrays that has a fixed width

public class InvaderGameState {

    // static variables
    public static int width = 500;
    public static int height = 500;
    public static double scale = 100;
    public static int updateTime = 10;

    // non-static variables
    public ArrayList<Missile> missiles; // ArrayList of type Missile
    public ArrayList<Enemy> enemies;
    public Shooter shooter;
    public int score;
    public int numberOfEnemies = 8;

    // Constructor
    public InvaderGameState(){
        missiles = new ArrayList<Missile>(); 
        enemies = new ArrayList<>();
        shooter = new Shooter(scale/2, 10);
        score = 0;
        Enemies(); // populate ArrayList enemies
        System.out.println("Game launched");
    }

    // populate ArrayList enemies in constructor
    public void Enemies(){
        double space = (scale-20)/numberOfEnemies;
        double x = 10;
        double y = 3*scale/4;
        for(int i = 0; i < numberOfEnemies; i++){
            enemies.add(new Enemy(x, y));
            x += space;
        }
    }

    public double GetNextMove(){
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            return 1;
        }

        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            return -1;
        }

        return 0;
    }

    public double GetRotation(){
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            return -1;
        }

        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            return 1;
        }

        return 0;
    }

    public void Update(){

        // Update the shooter
        shooter.Move(GetNextMove());
        shooter.Rotate(GetRotation());
        shooter.Draw();

        // Update the missiles
        if (StdDraw.isKeyPressed(KeyEvent.VK_X)){
            missiles.add(new Missile(shooter.X, shooter.Y));
        }
        for(int i = 0; i < missiles.size(); i++){

            Missile missile = missiles.get(i);
            if (missile.Move()){
                missile.Draw();
                for (int j = 0; j < enemies.size(); j++){
                    if (missile.IsContact(enemies.get(j))){
                        enemies.remove(j);
                    }
                }
            }else {
                missiles.remove(i);
            }
        }

        // Update the enemies
        for (int i = 0; i < enemies.size(); i++){
            Enemy enemy = enemies.get(i);
            if(enemy.Move()){
                enemy.Draw();
            }else{
                enemies.remove(i);
            }
        }

        // Draw the game
        StdDraw.show();
        StdDraw.pause(updateTime);
        StdDraw.clear();
    }

    // Game loop
    public void Loop(){
        while (!StdDraw.isKeyPressed(KeyEvent.VK_Q)){
            Update();
        }
    }
}
