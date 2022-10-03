import java.util.Scanner;

public class Tuner {

    public static void main(String[] args) {
        
        Model testModel = new Model(438);

        Scanner sc = new Scanner(System.in);

        String response = "";

        System.out.println("Type note name or 'q' to exit:");
        do {
            response = sc.nextLine();
            System.out.println(testModel.findHz(response));
            System.out.println("Type note name or 'q' to exit:");  

        } while (! response.equals("q"));

    }
}