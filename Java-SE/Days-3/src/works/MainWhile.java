package works;


import java.util.Scanner;

public class MainWhile {
    public static void main(String[] args) {

        // While
        // while(boolean)

        String[] users = {"Ali", "Serkan", "Mehmet", "Ahmet"};
        for( String item : users ) {
            System.out.println(item);
        }

        System.out.println("==================");
        for( String item : users ) {
            System.out.println(item);
        }

        String data = "Bugün günlerden Pazar\nKahvaltı yapalım.\nSonra cinemaya gidelim";
        Scanner read = new Scanner(data);
        while( read.hasNext() ) {
            System.out.println( read.nextLine() );
        }
        System.out.println("--------------------------");
        while( read.hasNext() ) {
            System.out.println( read.nextLine() );
        }

        int i = 0;
        while( i < 10 ) {
            System.out.println("While : " + i);
            i++;
        }

        int x = 0;
        // do - while
        do {
            System.out.println("Do While : " + x);
            x++;
        }while ( x > 5 );


    }
}
