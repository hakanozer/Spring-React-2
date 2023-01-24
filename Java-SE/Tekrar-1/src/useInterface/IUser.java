package useInterface;

public interface IUser {

    boolean userLogin( String email, String password );
    String userName( int userID );

    default int sum( int a, int b ) {
        return a + b;
    }

}
