package bases;

public class FrameCounter {
    int count;
    int countMax;

    public FrameCounter(int countMax) {
        this.countMax = countMax;
    }

    public boolean run() {
        if (this.count >= countMax) {
            return true;
        } else {
            this.count += 1;
            return false;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
