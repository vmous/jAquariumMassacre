package aquarium;

/**
 * Represents a fish.
 * 
 * @author billy
 * 
 */
public class Fish {
    // Denoting that all fish live in this aquarium.
    protected Aquarium aquarium;

    protected boolean alive;

    protected int r;
    protected int g;
    protected int b;

    protected float x;
    protected float y;

    protected float stepX;
    protected float stepY;

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
    Fish(Aquarium aquarium, int r, int g, int b, float x, float y, float stepX,
            float stepY) {
        this.aquarium = aquarium;
        this.alive = true;
        this.r = r;
        this.g = g;
        this.b = b;
        this.x = x;
        this.y = y;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    /**
     * Fish movement.
     */
    public void move() {
        x += stepX;
        y += stepY;

        // What happens on impact!
        // 78 is the distance from the center of the predator to the left edge +
        // half its length.
        if (x < 78 && x > 76) {
            if (y > aquarium.mouseY - 20 && y < aquarium.mouseY + 20) {
                // The consequence of the impact!
                // Same principle as in the ping-pong (ball hits paddle).
                alive = false;
            }

        }

        if (x < -50 && alive) {
            // What happens when the fish come through alive.
            x = Aquarium.AQUARIUM_WIDTH + 50;
            y = aquarium.random(20, 400);
        }
    }

    public void draw() {
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
