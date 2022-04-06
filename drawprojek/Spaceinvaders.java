/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class Spaceinvaders {

    public static void sprites(double[] spi, String[] animy) {
        // format for spi array
        // 0     sprite x position
        // 1     sprite y position
        // 2     sprite stage 0
        // 3     sprite endreach 0
        // 4     sprite animy 0
        // 5     sprite hp 1
        // 6     sprite start position limiter...same as x position

        // format for animy
        // 0     animation1
        // 1     animation2
        // 2     animation3
        // 3     animation4
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

    public static void player(double[] spi, String[] animy) {
        // format for spi
        // 0     pacmanmovement 0

        // format for animy
        // 0     animation1 pacopen
        // 1     animation2
        // 2     animation3 pacshoot
        if (StdDraw.isKeyPressed(65)) {
            StdDraw.filledSquare(spi[0], -12.0, 3.0);
            spi[0] -= 0.2;
            StdDraw.picture(spi[0], -12.0, animy[0], 3.0, 3.0, 180.0);

        }
        if (StdDraw.isKeyPressed(68)) {
            StdDraw.filledSquare(spi[0], -12.0, 3.0);
            spi[0] += 0.2;
            StdDraw.picture(spi[0], -12.0, animy[0], 3.0, 3.0, 0.0);
        }
        if (StdDraw.isKeyPressed(87)) {
            StdDraw.filledSquare(spi[0], -12.0, 3.0);
            // StdAudio.play("packman_chomp.wav");

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(spi[0], -11.0, spi[0], 7.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.pause(10);
            StdDraw.filledRectangle(spi[0], -11.0, 3.0, 19.0);
            StdDraw.picture(spi[0], -12.0, animy[2], 3.0, 3.0, 90.0);

        }
    }

    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(-20.0, 20.0);
        StdDraw.setYscale(-20.0, 20.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(0.0, 0.0, 20.0);
        int gameongoing = 1;
        // double packmanmovement = 0;
        double[] sprite1 = { -10, 5, 0, 0, 0, 1, -10 };
        String[] sprite1G = {
                "RedRightS1.png", "RedRightS2.png", "RedLeftS1.png", "RedLeftS2.png"
        };
        double[] player1 = { 0 };
        String[] player1G = { "Packmanopen.png", "", "Packmanshoot.png" };
        double[] sprite2 = { -5, 5, 0, 0, 0, 1, -5 };
        String[] sprite2G = { "LB1.png", "LB2.png", "LB3.png", "LB4.png" };
        double[] sprite3 = { -0, 5, 0, 0, 0, 1, 0 };
        String[] sprite3G = { "OR1.png", "OR2.png", "OR3.png", "OR4.png" };
        double[] sprite4 = { 5, 5, 0, 0, 0, 1, 5 };
        String[] sprite4G = { "P1.png", "P2.png", "P3.png", "P4.png" };

        // Sprite SP1 = new Sprite(sprite1, sprite1G);
        // Sprite SP2 = new Sprite(sprite2, sprite2G);
        // Sprite SP3 = new Sprite(sprite3, sprite3G);
        // Sprite SP4 = new Sprite(sprite4, sprite4G);
        // System.out.println("gaan dit");
        while (gameongoing == 1) {
            StdDraw.pause(50);
            // SP1.move(1);
            // SP2.move(1);
            // SP3.move(1);
            // SP4.move(1);

            sprites(sprite1, sprite1G);
            sprites(sprite2, sprite2G);
            sprites(sprite3, sprite3G);
            sprites(sprite4, sprite4G);
            player(player1, player1G);
           /* StdDraw.filledSquare(movement, 5, 3.0);
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
            }*/
            /*if (StdDraw.isKeyPressed(65)) {
                StdDraw.filledSquare(packmanmovement, -12.0, 3.0);
                packmanmovement -= 0.2;
                StdDraw.picture(packmanmovement, -12.0, "Packmanopen.png", 3.0, 3.0, 180.0);

            }
            if (StdDraw.isKeyPressed(68)) {
                StdDraw.filledSquare(packmanmovement, -12.0, 3.0);
                packmanmovement += 0.2;
                StdDraw.picture(packmanmovement, -12.0, "Packmanopen.png", 3.0, 3.0, 0.0);
            }
            if (StdDraw.isKeyPressed(87)) {
                StdDraw.filledSquare(packmanmovement, -12.0, 3.0);
                //StdAudio.play("packman_chomp.wav");

                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(packmanmovement, -11.0, packmanmovement, 7.0);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.pause(10);
                StdDraw.filledRectangle(packmanmovement, -11.0, 3.0, 19.0);
                StdDraw.picture(packmanmovement, -12.0, "Packmanshoot.png", 3.0, 3.0, 90.0);

            }*/

            if (StdDraw.isKeyPressed(69)) {
                gameongoing = 0;
                StdOut.println("dit stuur e");
            }
            if (StdDraw.isKeyPressed(70)) {
                sprite1[5] = 0;
                StdOut.println("dit stuur f");
            }


        }















        /*double x = -10.0;
        for (int t = 0; t < 4; t++) {
            StdDraw.filledSquare(-10.0 + t, 5, 3.0);
            StdDraw.filledSquare(-5.0 + t, 5, 3.0);
            StdDraw.filledSquare(0.0 + t, 5, 3.0);
            StdDraw.filledSquare(5.0 + t, 5, 3.0);
            StdDraw.filledSquare(10.0 + t, 5, 3.0);


            StdDraw.picture(-10.0 + t, 5, "G1.jpg", 3.0, 3.0);
            StdDraw.picture(-5.0 + t, 5.0, "O1.jpg", 3.0, 3.0);
            StdDraw.picture(0.0 + t, 5.0, "P1.jpg", 3.0, 3.0);
            StdDraw.picture(5.0 + t, 5.0, "B1.jpg", 3.0, 3.0);
            StdDraw.picture(10.0 + t, 5.0, "Gr1.jpg", 3.0, 3.0);
            StdDraw.pause(1500);


        }*/
        /*StdDraw.picture( 3.0, 3.0);
        StdDraw.picture(-5.0, 5.0, "O1.jpg", 3.0, 3.0);
        StdDraw.picture(0.0, 5.0, "P1.jpg", 3.0, 3.0);
        StdDraw.picture(5.0, 5.0, "B1.jpg", 3.0, 3.0);
        StdDraw.picture(10.0, 5.0, "Gr1.jpg", 3.0, 3.0);*/


        //StdDraw.picture(0.0, 0.0, "spaceInvderGraphics.png");
        //System.out.println("hello ek werk");


    }
}
