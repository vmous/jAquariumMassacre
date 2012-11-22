package aquarium;

/**
 * <p>
 * Represents the terror of the aquarium waters!
 * </p>
 *
 * <p>
 * Extends the {@link Fish} class.
 * </p>
 *
 * @author billy
 *
 */
public class PredatorFish extends Fish {

    /**
     * Constructor.
     *
     * @param aquarium
     *            The aquarium the fish inhabits.
     * @param r
     *            The red part of the fish's color.
     * @param g
     *            The green part of the fish's color.
     * @param b
     *            The blue part of the fish's color.
     * @param x
     *            Position of blue fish in x axis.
     * @param y
     *            Position of blue fish in y axis.
     * @param stepX
     *            Speed of blue fish along the x axis.
     * @param stepY
     *            Speed of blue fish along the y axis.
     */
    public PredatorFish(Aquarium aquarium, float x, float y, float stepX,
            float stepY) {
        super(aquarium, 238, 118, 0, x, y, stepX, stepY);
    }

    /*
     * Predator movement.
     *
     * (non-Javadoc)
     *
     * @see aquarium.Fish#move()
     */
    @Override
    public void move() {
        // Track down mouse up/down for y axis. x axis is always 0.
        y = aquarium.mouseY;
    }

    @Override
    public void draw() {
        aquarium.fill(r, g, b);
        aquarium.noStroke();
        aquarium.ellipse(x, y, 56, 30);
        aquarium.beginShape();
        aquarium.curveVertex(x, y - 20);
        aquarium.curveVertex(x, y - 20);
        aquarium.curveVertex(x - 15, y - 30);
        aquarium.curveVertex(x - 14, y - 10);
        aquarium.curveVertex(x + 5, y - 10);
        aquarium.curveVertex(x, y - 20);
        aquarium.endShape();
        aquarium.beginShape();
        aquarium.curveVertex(x - 25, y);
        aquarium.curveVertex(x - 25, y);
        aquarium.curveVertex(x - 40, y - 30);
        aquarium.curveVertex(x - 25, y);
        aquarium.curveVertex(x - 40, y + 30);
        aquarium.curveVertex(x - 25, y);
        aquarium.endShape();
        aquarium.beginShape();
        aquarium.curveVertex(x - 5, y + 15);
        aquarium.curveVertex(x - 5, y + 15);
        aquarium.curveVertex(x - 10, y + 15);
        aquarium.curveVertex(x - 10, y + 30);
        aquarium.curveVertex(x, y + 15);
        aquarium.curveVertex(x - 5, y + 15);
        aquarium.endShape();
        aquarium.fill(255, 255, 255);
        aquarium.ellipse(x + 16, y, 10, 10);
        aquarium.beginShape();
        aquarium.fill(255, 255, 255);

        if (!aquarium.mousePressed) {
            // Mouse click to move jaw offering the "eating" animation.
            // When mouse button is not pressed, the jaw stays where it is,
            // otherwise y value changed by +7
            aquarium.fill(0, 0, 0);
            aquarium.ellipse(x + 16, y, 2, 6);
            aquarium.noStroke();
            aquarium.fill(255, 255, 255);
            aquarium.vertex(x + 30, y + 14);
            aquarium.vertex(x + 30, y + 14);
            aquarium.vertex(x + 29, y);
            aquarium.vertex(x + 27, y + 14);
            aquarium.vertex(x + 26, y + 1);
            aquarium.vertex(x + 25, y + 14);
            aquarium.vertex(x + 24, y + 2);
            aquarium.vertex(x + 23, y + 14);
            aquarium.vertex(x + 22, y + 3);
            aquarium.vertex(x + 21, y + 14);
            aquarium.vertex(x + 30, y + 14);
            aquarium.endShape();
            aquarium.beginShape();
            aquarium.noStroke();
            aquarium.fill(238, 118, 0);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.curveVertex(x + 12, y + 15);
            aquarium.curveVertex(x + 30, y + 15);
            aquarium.curveVertex(x + 30, y + 13);
            aquarium.curveVertex(x + 18, y + 10);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.endShape();
        } else {
            aquarium.fill(0, 0, 0);
            aquarium.ellipse(x + 16, y, 3, 6);
            y = y + 7;
            aquarium.fill(255, 255, 255);
            aquarium.noStroke();
            aquarium.vertex(x + 30, y + 14);
            aquarium.vertex(x + 30, y + 14);
            aquarium.vertex(x + 29, y);
            aquarium.vertex(x + 27, y + 14);
            aquarium.vertex(x + 26, y + 1);
            aquarium.vertex(x + 25, y + 14);
            aquarium.vertex(x + 24, y + 2);
            aquarium.vertex(x + 23, y + 14);
            aquarium.vertex(x + 22, y + 3);
            aquarium.vertex(x + 21, y + 14);
            aquarium.vertex(x + 30, y + 14);
            aquarium.endShape();
            aquarium.beginShape();
            aquarium.noStroke();
            aquarium.fill(238, 118, 0);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.curveVertex(x + 12, y + 15);
            aquarium.curveVertex(x + 30, y + 15);
            aquarium.curveVertex(x + 30, y + 13);
            aquarium.curveVertex(x + 18, y + 10);
            aquarium.curveVertex(x + 12, y + 5);
            aquarium.endShape();

        }
    }
}
