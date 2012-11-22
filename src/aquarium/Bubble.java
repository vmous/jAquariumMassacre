package aquarium;

/**
 * Represents a bubble floating in the aquarium.
 *
 * @author billy
 *
 */
public class Bubble {
    // Denoting that the bubble "lives" in the aquarium.
    protected Aquarium aquarium;

    private float x;
    private float y;
    private final float size;

    /**
     * Constructor.
     *
     * @param aquarium
     *            The aquarium in which the bubble floats.
     * @param x
     *            Position of bubble in x axis.
     * @param y
     *            Position of bubble in y axis.
     * @param size
     *            The size of the bubble.
     */
    Bubble(Aquarium aquarium, float x, float y, float size) {
        this.aquarium = aquarium;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    /**
     * Defines the direction and movement of a bubble in the aquarium.
     */
    void move() {
        x += aquarium.random(-0.5f, 0.5f);
        y += aquarium.random(-2.5f);

        if (y < 0) {
            x = aquarium.random(115, 205);
            y = aquarium.random(420, 425);
        }
    }

    /**
     * Draws the bubble in the aquarium.
     */
    void draw() {
        aquarium.noStroke();
        aquarium.fill(255, 255, 255, 120);
        aquarium.ellipse(x, y, size, size);
    }
}
