import java.util.HashMap;
import java.util.Scanner;

public class Tuner {

    public static void main(String[] args) {
        
        Model testModel = new Model(438);

        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> response = new HashMap<>();
        String strResponse = "";

        System.out.println("Type note name or 'q' to exit:");
        
        while (! strResponse.equals("q")) {

            System.out.println("Type hz or 'q' to exit:");  
        }
    }
}