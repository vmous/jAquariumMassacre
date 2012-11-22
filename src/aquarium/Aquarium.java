package aquarium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import processing.core.*;

/**
 * The Aquarium class. Extends the {@link PApplet} class in order to inherit the
 * functions of a Processing enabled applet.
 *
 * @author billy
 *
 */
public class Aquarium extends PApplet {
    private static final long serialVersionUID = 8848462865975991019L;

    // Setting constant variables
    public static final int AQUARIUM_WIDTH = 800;
    public static final int AQUARIUM_HEIGHT = 600;

    public int greenFishNum;
    public int yellowFishNum;
    public int blueFishNum;
    public int enemyFishNum;
    public int bubbleNum;

    // Creating arrays for the various fish inhabiting the aquarium...
    private final BlueFish blueFishes[];
    private final YellowFish yellowFishes[];
    private final GreenFish greenFishes[];
    private final EnemyFish enemyFishes[];

    // ... the bubbles floating...
    private final Bubble bubbles[];

    // ... and the terror lurking!
    private PredatorFish predator;

    // Boolean variable indicating state of the the game
    private boolean loseGame;

    /**
     * Constructor.
     */
    public Aquarium() {
        Properties prop = new Properties();

        try {
            // Try initializing some game properties by loading from a
            // configuration file.
            prop.load(new FileInputStream("config.properties"));

            greenFishNum = Integer
                    .parseInt(prop.get("greenFishNum").toString());
            yellowFishNum = Integer.parseInt(prop.get("yellowFishNum")
                    .toString());
            blueFishNum = Integer.parseInt(prop.get("blueFishNum").toString());
            enemyFishNum = Integer
                    .parseInt(prop.get("enemyFishNum").toString());
            bubbleNum = Integer.parseInt(prop.get("bubbleNum").toString());

        } catch (IOException ioe) {
            // ioe.printStackTrace();
            System.out
                    .println("I cannot read the config.properties file. Please check the file exists and you have the access rights to read it. Loading defaults!");

            // In case of failing to load from the file, initialize them
            // manually.
            greenFishNum = 30;
            yellowFishNum = 30;
            blueFishNum = 15;
            enemyFishNum = 5;
            bubbleNum = 20;
        }

        // Acquire space for the objects.
        blueFishes = new BlueFish[blueFishNum];
        yellowFishes = new YellowFish[yellowFishNum];
        greenFishes = new GreenFish[greenFishNum];
        enemyFishes = new EnemyFish[enemyFishNum];
        bubbles = new Bubble[bubbleNum];

    }

    @Override
    public void setup() {

        // Static background with window size, gradient and static objects.
        size(AQUARIUM_WIDTH, AQUARIUM_HEIGHT);
        smooth();
        strokeWeight(1);

        float r = 129;
        float g = 190;
        float b = 247;
        for (float i = 0; i < AQUARIUM_HEIGHT; i++) {
            stroke(r, g, b);
            line(0, i, AQUARIUM_WIDTH, i);
            if (r > 7) {
                r = r - 0.5f;
            }
            if (g > 56) {
                g = g - 0.5f;
            }
            if (b > 100) {
                b = b - 0.5f;
            }
        }

        // Static objects.
        drawSand();
        drawTreasureChest();
        drawSandOther();
        drawBoat();
        drawAnchor();

        // Looping to draw underwater plants...
        for (int i = 0; i < 90; i++) {
            drawAlgae();
            drawAlgaeOther();
        }
        // ... and gold!
        for (int i = 0; i < 40; i++) {
            drawGold(random(130, 210), random(430, 440));
        }

        // Storing static elements
        loadPixels();

        // Fish.
        // Set where they are drawn and how they move.
        for (int i = 0; i < blueFishNum; i++) {
            // blueFishes[i] = new BlueFish(this, random(0, AQUARIUM_WIDTH),
            // random(100, 400), random(-3, -1), random(-0.2f, 0));
            blueFishes[i] = new BlueFish(this, random(0, AQUARIUM_WIDTH),
                    random(100, 400), random(-4, -2), random(-0.4f, 0));
        }

        for (int i = 0; i < yellowFishNum; i++) {
            yellowFishes[i] = new YellowFish(this, random(0, AQUARIUM_WIDTH),
                    random(100, 400), random(-4, -2), random(-0.4f, 0));
        }

        for (int i = 0; i < greenFishNum; i++) {
            // greenFishes[i] = new GreenFish(this, random(0, AQUARIUM_WIDTH),
            // random(100, 400), random(-5, -3), random(-0.3f, 0));
            greenFishes[i] = new GreenFish(this, random(0, AQUARIUM_WIDTH),
                    random(100, 400), random(-4, -2), random(-0.4f, 0));
        }

        for (int i = 0; i < enemyFishNum; i++) {
            enemyFishes[i] = new EnemyFish(this, random(0, AQUARIUM_WIDTH),
                    random(100, 400), random(-3, -1), random(-0.2f, 0));
        }

        for (int i = 0; i < bubbleNum; i++) {
            bubbles[i] = new Bubble(this, random(115, 195), random(50, 420),
                    random(5, 25));
        }

        predator = new PredatorFish(this, 50, AQUARIUM_HEIGHT / 2, 0, 0);

    }

    /*
     * Drawing commands and animations for moving objects
     *
     * (non-Javadoc)
     *
     * @see processing.core.PApplet#draw()
     */
    @Override
    public void draw() {
        // Load the pixels once more.
        updatePixels();

        for (int i = 0; (i < blueFishNum); i++) {
            blueFishes[i].draw();
            blueFishes[i].move();
        }

        for (int i = 0; (i < yellowFishNum); i++) {
            yellowFishes[i].draw();
            yellowFishes[i].move();
        }

        for (int i = 0; (i < greenFishNum); i++) {
            greenFishes[i].draw();
            greenFishes[i].move();
        }

        for (int i = 0; i < enemyFishNum; i++) {
            enemyFishes[i].draw();
            enemyFishes[i].move();
        }

        for (int i = 0; i < bubbleNum; i++) {
            bubbles[i].draw();
            bubbles[i].move();
        }

        predator.draw();
        predator.move();

        // // Set the boolean value when the game is over.
        // // When endGame equals true the game is over!
        // boolean endGame = true;
        // for (int i = 0; (i < blueFishNum); i++) {
        // // As long as a fish is still alive, the game is not over.
        // if(blueFishes[i].isAlive()) {
        // endGame = false;
        // break;
        // }
        // }
        //
        // for (int i = 0; (i < yellowFishNum) && endGame; i++) {
        // if(yellowFishes[i].isAlive()) {
        // endGame = false;
        // break;
        // }
        // }
        //
        // for (int i = 0; (i < greenFishNum) && endGame; i ++) {
        // if(greenFishes[i].isAlive()) {
        // endGame = false;
        // break;
        // }
        // }

        // if(endGame || looseGame) {
        if (loseGame) {
            // Being here means that you have lost the game.
            // endGame means you have won the game!
            // endGame = false;
            // whereas loseGame means that you lost the game. Start all over
            // again.
            loseGame = false;
            for (int i = 0; i < blueFishNum; i++) {
                blueFishes[i].setAlive(true);
            }
            for (int i = 0; i < greenFishNum; i++) {
                greenFishes[i].setAlive(true);
            }
            for (int i = 0; i < yellowFishNum; i++) {
                yellowFishes[i].setAlive(true);
            }
        }
    }

    // -- Functions for static objects.

    void drawAlgae() {
        beginShape();
        smooth();
        stroke(random(0), random(240), random(0));
        strokeWeight(6);
        line(random(600, 650), random(600, 620), random(500, 700),
                random(400, 450));
        endShape();
    }

    void drawAlgaeOther() {
        beginShape();
        smooth();
        stroke(random(0), random(240), random(0));
        strokeWeight(6);
        line(random(700, 750), random(600, 670), random(600, 800),
                random(250, 400));
        endShape();
    }

    void drawGold(float x, float y) {
        stroke(0, 0, 0);
        strokeWeight(1);
        fill(238, 201, 0);
        ellipse(x, y, 10, 10);
    }

    void drawSand() {
        stroke(0, 0, 0);
        strokeWeight(2);
        fill(244, 164, 96);
        beginShape();
        curveVertex(0, 500);
        curveVertex(0, 500);
        curveVertex(100, 550);
        curveVertex(250, 520);
        curveVertex(400, 470);
        curveVertex(800, 300);
        curveVertex(800, 600);
        curveVertex(0, 600);
        curveVertex(0, 500);
        endShape();
    }

    void drawSandOther() {
        stroke(0, 0, 0);
        strokeWeight(2);
        fill(255, 206, 163);
        beginShape();
        curveVertex(0, 370);
        curveVertex(0, 370);
        curveVertex(200, 550);
        curveVertex(300, 600);
        curveVertex(0, 600);
        curveVertex(0, 370);
        endShape();
    }

    void drawBoat() {
        beginShape();
        stroke(0, 0, 0);
        strokeWeight(1.5f);
        fill(139, 69, 19);
        ellipse(100, 20, 700, 500);
        line(0, 5, 449, 5);
        line(0, 25, 449, 25);
        line(0, 45, 448, 45);
        line(0, 65, 444, 65);
        line(0, 85, 438, 85);
        line(0, 105, 428, 105);
        line(0, 125, 418, 125);
        line(0, 145, 403, 145);
        line(0, 165, 384, 165);
        line(0, 185, 362, 185);
        line(0, 205, 335, 205);
        line(0, 225, 300, 225);
        line(0, 245, 253, 245);
        line(25, 265, 174, 265);

        ellipse(100, 100, 80, 80);
        fill(0, 0, 0);
        ellipse(100, 100, 40, 40);
        fill(139, 69, 19);
        ellipse(250, 100, 80, 80);
        fill(0, 0, 0);
        ellipse(250, 100, 40, 40);
        endShape();
    }

    void drawTreasureChest() {
        stroke(0, 0, 0);
        strokeWeight(1);
        rectMode(CORNERS);
        fill(139, 35, 35);
        rect(100, 440, 230, 530);
        beginShape();
        curveVertex(100, 440);
        curveVertex(100, 440);
        curveVertex(155, 370);
        curveVertex(230, 410);
        curveVertex(100, 440);
        endShape();
    }

    void drawAnchor() {
        smooth();
        beginShape();
        stroke(0, 0, 0);
        strokeWeight(1);
        fill(0, 0, 0);
        ellipse(450, 420, 50, 50);
        fill(72, 185, 255);
        ellipse(450, 420, 30, 30);
        fill(0, 0, 0);
        ellipse(450, 480, 20, 90);
        ellipse(450, 535, 100, 20);
        triangle(400, 535, 380, 490, 420, 535);
        triangle(500, 535, 520, 490, 480, 535);
        triangle(380, 490, 380, 510, 400, 500);
        triangle(520, 490, 520, 510, 500, 500);
        endShape();

        beginShape();
        ellipse(450, 420, 20, 20);
        ellipse(471, 400, 10, 10);
        ellipse(470, 390, 10, 10);
        ellipse(473, 380, 10, 10);
        ellipse(470, 370, 10, 10);
        ellipse(473, 360, 10, 10);
        ellipse(470, 350, 10, 10);
        ellipse(473, 340, 10, 10);
        ellipse(470, 330, 10, 10);
        ellipse(465, 320, 10, 10);
        ellipse(470, 310, 10, 10);
        ellipse(465, 300, 10, 10);
        ellipse(470, 290, 10, 10);
        ellipse(465, 280, 10, 10);
        ellipse(460, 270, 10, 10);
        ellipse(455, 260, 10, 10);
        ellipse(450, 250, 10, 10);
        ellipse(445, 240, 10, 10);
        ellipse(450, 230, 10, 10);
        ellipse(445, 220, 10, 10);
        ellipse(450, 210, 10, 10);
        ellipse(445, 200, 10, 10);
        ellipse(450, 190, 10, 10);
        ellipse(445, 180, 10, 10);
        ellipse(450, 170, 10, 10);
        ellipse(445, 160, 10, 10);
        ellipse(440, 150, 10, 10);
        ellipse(435, 140, 10, 10);
        ellipse(430, 130, 10, 10);
        ellipse(425, 120, 10, 10);
        endShape();
    }

    public boolean isLoseGame() {
        return loseGame;
    }

    public void setLoseGame(boolean loseGame) {
        this.loseGame = loseGame;
    }
}
