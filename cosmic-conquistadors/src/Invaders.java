import java.awt.event.KeyEvent;

public class Invaders {
    public static void main(String[] args){

        // Parameters of the game window
        StdDraw.setCanvasSize(InvaderGameState.width, InvaderGameState.height);
        StdDraw.setScale(0, InvaderGameState.scale);
        StdDraw.enableDoubleBuffering();

        // Game start
        InvaderGameState game = new InvaderGameState();
        game.Loop();

    }
}
