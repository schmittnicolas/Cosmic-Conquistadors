import com.sun.nio.sctp.SendFailedNotification;

import java.awt.*;
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
    public int score;
    public int numberOfEnemies = 8;

    // Shooter
    public Shooter shooter;
    public boolean canShoot = true;
    public int timeBeforeNextShoot = 25;
    public int timer = 0;

    // Constructor
    public InvaderGameState(){

        StdDraw.setFont(new Font("Blackadder ITC", Font.PLAIN, 72));
        StdDraw.setPenColor(StdDraw.RED);
        missiles = new ArrayList<>();
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
            if (i % 2 == 0){
                y -= space;
            }
            else{
                y+=space;
            }
        }
    }

    /* Get the next move the player wants to apply to the shooter
       1  : go right
       -1 : go left
       0  : do not move
     */

    public double GetNextMove(){
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            return 1;
        }

        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            return -1;
        }

        return 0;
    }

    /* Get the rotation the player wants to apply to the shooter
       1  : rotate right
       -1 : rotate left
       0  : do not rotate
     */
    public double GetRotation(){
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            return -1;
        }

        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            return 1;
        }

        return 0;
    }

    // Update the game
    // Return true if the game is not finished, false otherwise
    public boolean Update(){

        // Draw the background
        StdDraw.picture(scale/2, scale/2, "images/background.png", scale, scale);

        // Update the shooter
        shooter.Move(GetNextMove());
        shooter.Rotate(GetRotation());
        shooter.Draw();
        if (!canShoot && timer >= timeBeforeNextShoot){
            canShoot = true;
            timer = 0;
        }

        // Update the missiles
        if (StdDraw.isKeyPressed(KeyEvent.VK_X) && canShoot){
            // If the player can shoot and wants to shoot, we instantiate a new missile
            missiles.add(new Missile(shooter.X, shooter.Y, shooter.Degrees));
            canShoot = false;
        }

        for(int i = 0; i < missiles.size(); i++){

            Missile missile = missiles.get(i);

            if (missile.Move()){
                missile.Draw();
                for (int j = 0; j < enemies.size(); j++){
                    if (missile.IsContact(enemies.get(j))){

                        // If the missile touches an enemy, we destroy both the missile and the enemy, and we update the score
                        enemies.remove(j);
                        missiles.remove(i);
                        score++;
                    }
                }
            }else {

                // if the missile can not move (because he will leave the area), we remove it
                missiles.remove(i);
            }
        }

        // Update the enemies
        for (int i = 0; i < enemies.size(); i++){

            Enemy enemy = enemies.get(i);

            if(enemy.Move()){
                enemy.Draw();
                if (enemy.IsContact(shooter)){

                    // If an enemy is in contact with the shooter, the game is finished
                    return false;
                }
            }
            else{

                // If the missile can not move (because he will leave the area), we remove it
                return false;
            }
        }

        // If there is no more enemies, the game is finished
        if (enemies.size() == 0)
            return false;

        timer++;

        // Draw the game
        StdDraw.text(20, 90, "Score:" + score);
        StdDraw.show();
        StdDraw.pause(updateTime);
        StdDraw.clear();

        return true; // The game is not finished.
    }


    // Reset all the parameters of the game
    public void Reset(){
        score = 0;
        enemies.clear();
        Enemies();
        missiles.clear();
        StdDraw.clear();
        shooter = new Shooter(scale/2, 10);
    }


    // Game loop
    public void Loop(){

        // Display the title screen
        while(!StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
            StdDraw.picture(scale/2, scale/2, "images/title.png", scale, scale);
            StdDraw.show();
            if (StdDraw.isKeyPressed(KeyEvent.VK_Q))
                System.exit(0);
        }

        // The game start
        // While the game is not finished, we call the method update
        while (Update()){
            if (StdDraw.isKeyPressed(KeyEvent.VK_Q))
                System.exit(0);
        }

        // Update the text in function of the results of the game
        String text = "Score: " + score;
        if(enemies.size() == 0){
            text = "Victory " + text;
        }
        else {
            text = "Defeat " + text;
        }

        // Display ending screen
        StdDraw.picture(scale/2, scale/2, "images/victory.png", scale, scale);
        StdDraw.text(scale/2, scale/2, text);
        StdDraw.show();
        StdDraw.pause(2000);

        // Restart the game
        Reset();
        Loop();
    }
}
