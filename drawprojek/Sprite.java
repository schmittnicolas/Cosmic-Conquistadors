/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Sprite {
    private double[] spi;
    private String[] animy;

    public Sprite(double[] info, String[] graphics) {
        spi = info;
        animy = graphics;

    }

    public void move(int go) {
        //format for spi array
        //0     sprite x position
        //1     sprite y position
        //2     sprite stage 0
        //3     sprite endreach 0
        //4     sprite animy 0
        //5     sprite hp 1
        //6     sprite start position limiter...same as x position

        //format for animy
        //0     animation1
        //1     animation2
        //2     animation3
        //3     animation4
        if (spi[5] == 0) {
            animy[0] = "WI1.png";
            animy[1] = "WI1.png";
            animy[2] = "WI2.png";
            animy[3] = "WI2.png";
            spi[5] -= 1;
        }

        if (spi[5] > -10) {
            StdDraw.filledSquare(spi[0], spi[1], 2.0);
            if (spi[0] >= spi[6] + 5) {
                spi[3] = 1;
            }
            if (spi[0] <= spi[6]) {
                spi[3] = 0;
            }
            if (spi[3] == 0) {
                spi[0] += 0.1;
            }
            if (spi[3] == 1) {
                spi[0] -= 0.1;
            }
            if (spi[3] == 0) {

                if (spi[2] == 1) {
                    StdDraw.picture(spi[0], spi[1], animy[0], 3.0, 3.0);
                    spi[2] = 0;
                }
                else {
                    StdDraw.picture(spi[0], spi[1], animy[1], 3.0, 3.0);
                    spi[2] = 1;
                }
            }
            if (spi[3] == 1) {
                if (spi[2] == 1) {
                    StdDraw.picture(spi[0], spi[1], animy[2], 3.0, 3.0);
                    spi[2] = 0;
                }
                else {
                    StdDraw.picture(spi[0], spi[1], animy[3], 3.0, 3.0);
                    spi[2] = 1;
                }
            }
            if (spi[5] < 0) {
                spi[5] -= 1;
            }
        }
        if (spi[5] == -10) {
            spi[5] -= 1;
            StdDraw.filledSquare(spi[0], spi[1], 2.0);
        }

    }


    public static void main(String[] args) {
        /*int gameongoing = 1;
        double movement = -10;
        int edgereach = 0;
        int spritestage = 0;
        while (gameongoing == 1) {
            StdDraw.pause(50);
            if (movement >= 10.0) {
                edgereach = 1;
            }
            if (movement <= -10.0) {
                edgereach = 0;
            }
            if (edgereach == 0) {
                movement += 0.1;
            }
            if (edgereach == 1) {
                movement -= 0.1;
            }
            if (edgereach == 0) {


                if (spritestage == 1) {
                    StdDraw.picture(movement, 5, "RedRightS1.png", 3.0, 3.0);
                    spritestage = 0;
                }
                else {
                    StdDraw.picture(movement, 5, "RedRightS2.png", 3.0, 3.0);
                    spritestage = 1;
                }
            }
            if (edgereach == 1) {
                if (spritestage == 1) {
                    StdDraw.picture(movement, 5, "RedLeftS1.png", 3.0, 3.0);
                    spritestage = 0;
                }
                else {
                    StdDraw.picture(movement, 5, "RedLeftS2.png", 3.0, 3.0);
                    spritestage = 1;
                }
            }
            if (StdDraw.isKeyPressed(69)) {
                gameongoing = 0;
                StdOut.println("dit stuur e");
            }

        }*/
    }
}
