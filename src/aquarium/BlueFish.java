package aquarium;

/**
 * <p>
 * Represents a blue fish.
 * </p>
 * 
 * <p>
 * Extends the {@link Fish} class.
 * </p>
 * 
 * @author billy
 * 
 */
public class BlueFish extends Fish {

    /**
     * Constructor.
     * 
     * @param aquarium
     *            The aquarium the fish inhabits.
     * @param x
     *            Position of blue fish in x axis.
     * @param y
     *            Position of blue fish in y axis.
     * @param stepX
     *            Speed of blue fish along the x axis.
     * @param stepY
     *            Speed of blue fish along the y axis.
     */
    public BlueFish(Aquarium aquarium, float x, float y, float stepX,
            float stepY) {
        super(aquarium, 0, 0, 132, x, y, stepX, stepY);
    }

    @Override
    public void draw() {
        if (alive) {
            // The fish is drawn as long as it is still alive.
            aquarium.fill(r, g, b);
            aquarium.noStroke();
            aquarium.ellipse(x, y, 40, 20);
            aquarium.beginShape();
            aquarium.curveVertex(x, y - 5);
            aquarium.curveVertex(x, y - 5);
            aquarium.curveVertex(x + 20, y - 15);
            aquarium.curveVertex(x + 20, y);
            aquarium.curveVertex(x + 15, y);
            aquarium.endShape();
            aquarium.beginShape();
            aquarium.curveVertex(x, y + 10);
            aquarium.curveVertex(x + 10, y + 5);
            aquarium.curveVertex(x, y + 10);
            aquarium.endShape();
            aquarium.fill(255, 255, 255);
            aquarium.ellipse(x - 7, y, 10, 10);
            aquarium.fill(0, 0, 0);
            aquarium.ellipse(x - 7, y, 2, 2);
            aquarium.endShape();
        } else {
            // Draw a blood splatter when the fish dies!
            for (int i = 1; i < 15; i++) {
                aquarium.fill(255, 0, 0);
                aquarium.ellipse(aquarium.random(x - 25, x + 25),
                        aquarium.random(y - 15, y + 15), aquarium.random(1, 5),
                        aquarium.random(1, 5));
            }

        }
    }
}
