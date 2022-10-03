import java.util.HashMap;

public class Model {

    private double tunerOffset;
    private HashMap<String, Double> hzMap = new HashMap<String, Double>();

    public Model(double chamberA) {
        tunerOffset = chamberA - 440.00;

        hzMap.put("C", 261.63);
        hzMap.put("C#", 277.18);
        hzMap.put("D", 293.66);
        hzMap.put("D#", 311.13);
        hzMap.put("E", 329.63);
        hzMap.put("F", 349.23);
        hzMap.put("F#", 369.99);
        hzMap.put("G", 392.00);
        hzMap.put("G#", 415.30);
        hzMap.put("A", 440.00);
        hzMap.put("A#", 466.16);
        hzMap.put("B", 493.88);

        updateHz();
        // printHz();
    }


    private void updateHz() {
        for (String note: hzMap.keySet()) {
            hzMap.put(note, hzMap.get(note) + tunerOffset);
        }
    }

    private void printHz() {
        for (String note: hzMap.keySet()) {
            System.out.println("Note: " + note + " Hz: " + hzMap.get(note));
        }
    }

    protected double findHz(String note) {
        return hzMap.get(note);
    }

    protected String findNote(double hz) {
        return "";
    }

}
