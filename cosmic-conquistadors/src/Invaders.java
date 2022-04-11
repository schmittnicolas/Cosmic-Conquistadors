import java.awt.event.KeyEvent;

public class Invaders {
    public static void main(String args[]){

        StdDraw.setCanvasSize(InvaderGameState.width, InvaderGameState.height);
        StdDraw.setScale(0, InvaderGameState.scale);
        StdDraw.enableDoubleBuffering();

        InvaderGameState game = new InvaderGameState();
        game.Loop();

    }
}
