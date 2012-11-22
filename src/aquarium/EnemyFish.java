package aquarium;

/**
 * <p>
 * Represents an enemy fish.
 * </p>
 * 
 * <p>
 * Extends the {@link Fish} class.
 * </p>
 * 
 * @author billy
 * 
 */
public class EnemyFish extends Fish {

    public EnemyFish(Aquarium aquarium, float x, float y, float stepX,
            float stepY) {
        super(aquarium, 205, 0, 0, x, y, stepX, stepY);
    }

    @Override
    public void move() {
        x += stepX;
        y += stepY;

        if (x < -50 && alive) {
            x = Aquarium.AQUARIUM_WIDTH + 50;
            y = aquarium.random(20, 400);
        }

        // Test if the enemy fish got you.
        if (x < 78 && x > 76) {
            if (y > aquarium.mouseY - 20 && y < aquarium.mouseY + 20) {
                System.out.println("All Fish Alive - Try Again You Looser!");
                aquarium.setLoseGame(true);
            }
        }
    }

    @Override
    public void draw() {
        aquarium.strokeWeight(1);
        aquarium.stroke(0, 0, 0);
        aquarium.fill(r, g, b);
        aquarium.beginShape();
        aquarium.curveVertex(x, y);
        aquarium.curveVertex(x, y);
        aquarium.curveVertex(x + 70, y + 40);
        aquarium.curveVertex(x + 70, y - 50);
        aquarium.curveVertex(x, y);
        aquarium.endShape();
        aquarium.ellipse(x - 30, y, 100, 50);
        aquarium.fill(255, 215, 0);
        aquarium.ellipse(x - 65, y, 10, 10);
        aquarium.stroke(0, 0, 0);
        aquarium.point(x - 65, y);
        aquarium.fill(205, 0, 0);
        aquarium.beginShape();
        aquarium.curveVertex(x - 30, y + 10);
        aquarium.curveVertex(x - 30, y + 10);
        aquarium.curveVertex(x - 10, y + 30);
        aquarium.curveVertex(x - 10, y + 10);
        aquarium.curveVertex(x - 30, y + 10);
        aquarium.endShape();
        aquarium.fill(255, 215, 0);
        aquarium.ellipse(x - 40, y - 25, 9, 9);
        aquarium.ellipse(x - 30, y - 25, 12, 12);
        aquarium.ellipse(x - 20, y - 25, 15, 15);
        aquarium.ellipse(x - 5, y - 25, 18, 18);
        aquarium.ellipse(x + 10, y - 20, 20, 20);
    }
}
