import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

public class Model {

    private double tunerOffset;
    private HashMap<String, Double> hzMap = new HashMap<>();

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

    protected HashMap<String, BigDecimal> findNote(BigDecimal hz) {

        String closest = "";
        int octave = 4;
        BigDecimal smallestOffset = new BigDecimal("100000"); 
        BigDecimal curOffset = new BigDecimal("100000"); 
        BigDecimal lowerBound = new BigDecimal("245.28");
        BigDecimal higherBound = new BigDecimal("508.56");

        HashMap<String, BigDecimal> closestWithOffset = new HashMap<>();

        while (hz.compareTo(lowerBound) < 0) {
            // TODO: create BigDecimal with value 2 as variable
            hz = hz.multiply(new BigDecimal("2"));
            octave -= 1;
        }

        while (hz.compareTo(higherBound) > 0) {
            hz = hz.divide(new BigDecimal("2"));
            octave += 1;
        }

        for (String note : hzMap.keySet()) {
            curOffset = hz.subtract(new BigDecimal(Double.toString(hzMap.get(note)))).abs();
            
            if (curOffset.compareTo(smallestOffset) < 0) {
                closest = note;
                smallestOffset = curOffset;
            }
        }

        if (octave < 4) {
            smallestOffset = smallestOffset.divide(new BigDecimal(Math.pow(2, 4 - octave)));
        } else if (octave > 4) {
            smallestOffset = smallestOffset.multiply(new BigDecimal(Math.pow(2, octave - 4)));
        }
        // smallestOffset = smallestOffset.multiply(new BigDecimal(octave));

        // TODO: Output offset in cents, not hz

        closestWithOffset.put(closest + octave, smallestOffset.setScale(1, RoundingMode.FLOOR));

        return closestWithOffset;
    }
}
