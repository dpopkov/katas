package learn.katas.corejava.tools.cloner;

public class CloneCount {
    private int numCloned;

    public int getNumCloned() {
        return numCloned;
    }

    public void increment() {
        numCloned++;
    }

    public String getStats() {
        if (numCloned == 0) {
            return "Nothing copied";
        } else {
            return "Number of files copied: " + numCloned;
        }
    }
}
