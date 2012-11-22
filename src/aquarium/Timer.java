package aquarium;

/**
 * The global game timer.
 *
 * @author billy
 *
 */
public class Timer {
    private final Aquarium aquarium;
    // Time in msecs that timer started.
    private long startTime;
    // Use to hold total time of run so far, useful in conjunction with pause
    // and continueRunning
    private final long timeSoFar;
    private boolean running;
    // Location of timer output
    private final int x, y;

    /**
     * Constructor.
     *
     * @param aquarium
     *            The aquarium.
     * @param inX
     *            The position of the timer in the x axis.
     * @param inY
     *            The position of the timer in the y axis.
     */
    Timer(Aquarium aquarium, int x, int y) {
        this.aquarium = aquarium;
        this.x = x;
        this.y = y;
        this.running = false;
        this.timeSoFar = 0;
    }

    int currentTime() {
        if (running)
            return ((int) ((aquarium.millis() - startTime) / 1000.0));
        else
            return ((int) (timeSoFar / 1000.0));
    }

    void start() {
        running = true;
        startTime = aquarium.millis();
    }

    /**
     * Resets the timer to zero and restart; identical to start.
     */
    void restart() {
        start();
    }

    /**
     * Called after stop to restart the timer running no effect if already
     * running.
     */
    void continueRunning() {
        if (!running) {
            startTime = aquarium.millis() - timeSoFar;
            running = true;
        }
    }

    void DisplayTime() {
        int theTime;
        String output = "";

        theTime = currentTime();
        output = output + theTime;

        // println("output = " + output) ;
        // aquarium.fill(150,0,200) ;
        // aquar font ;
        // aquarium.font = aquarium.loadFont("Arial-Black-48.vlw") ;
        // aquarium.textFont(font) ;
        // aquarium.text(output,x,y) ;
    }
}
