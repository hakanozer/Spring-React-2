package works;

public class Settings {

    public String profileName( int userID ) {
        String data = "";
        if ( userID == 10 ) {
            data = "Ali Bilmem";
        }else if ( userID == 20 ) {
            data = "Erkan Bilsin";
        }else if ( userID == 30 ) {
            data = "Zehra Bilki";
        }
        return data;
    }

}
