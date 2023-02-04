package appPack;

import java.util.Locale;

public class MainApp {
    public static void main(String[] args) {

       String words = "Hello Word";
       String wordx = new String("Hello Word");
       String data = "Lorem İpsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem İpsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır.";
       String stNumber = "10";
       int number = 10;
       String java = " Java Programing    ";

       int size = data.length();
       System.out.println("Size : " + size);

       char[] arr = stNumber.toCharArray();
       boolean isDigit = true;
       for ( char item : arr ) {
           if ( !Character.isDigit(item) ) {
               System.out.println("isDigit : " + item);
               isDigit = false;
           }
       }
       System.out.println( "isDigit : " + isDigit );


       byte[] bytes = data.getBytes();
       System.out.println( bytes[0] );

       String lower = data.toLowerCase(new Locale("tr", "TR"));
       System.out.println( lower );
       String upper = data.toUpperCase(new Locale("tr", "TR"));
       System.out.println( upper );

       String[] wordArr =  data.split("\\.");
       System.out.println( wordArr.length );

       boolean status = data.contains("bask");
       System.out.println( status );

       int dizgiNumber = data.compareToIgnoreCase("dizgi");
       System.out.println( dizgiNumber );

       if ( "HellO word".equalsIgnoreCase(words) ) {
           System.out.println("equalsIgnoreCase True");
       }else {
           System.out.println("equalsIgnoreCase False");
       }

       int index = data.indexOf("dizgi");
       System.out.println( "index : " + index);

       String newString = data.replaceAll("Lorem", "***");
       System.out.println(newString);

       String subString = data.substring(index, index + "dizgi".length() );
       System.out.println(subString);

       java = java.trim();
       java = java.replaceAll(" " ,"");
       System.out.println( java );

    }
}
