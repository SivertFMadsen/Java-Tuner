import java.util.Scanner;

public class Tuner {

    public static void main(String[] args) {
        
        Model testModel = new Model(438);

        Scanner sc = new Scanner(System.in);

        String response = "";

        System.out.println("Type note name or 'q' to exit:");
        response = sc.nextLine();
        
        while (! response.equals("q")) {

            System.out.println(testModel.findHz(response));
            System.out.println("Type note name or 'q' to exit:");  
            response = sc.nextLine();
        }
    }
}