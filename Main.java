import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FirstAction action = new ThirdAction();

        System.out.println("Что сделать?");
        System.out.println("1) add");
        System.out.println("2) delete");

        int x = s.nextInt();

        switch(x){
            case 1:
                action.add();
                break;
            case 2:
                action.delete();
                break;
            default:
                System.exit(0);
        }
    }
}