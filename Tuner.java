import java.util.HashMap;
import java.math.BigDecimal;
import java.util.Scanner;

public class Tuner {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Input preffered chamber A:");
        int chamberA = Integer.parseInt(sc.nextLine());

        Model testModel = new Model(chamberA);

        HashMap<String, BigDecimal> response = new HashMap<>();
        String strResponse = "";

        System.out.println("Type hz or 'q' to exit:");
        strResponse = sc.nextLine();

        while (! strResponse.equals("q")) {
            response = testModel.findNote(new BigDecimal(strResponse));

            for (String note : response.keySet()) {
                System.out.println("Note: "+ note + " offset: " + response.get(note) + "hz");
            }

            System.out.println("Type hz or 'q' to exit:");  
            strResponse = sc.nextLine();
        }

        sc.close();
    }
}