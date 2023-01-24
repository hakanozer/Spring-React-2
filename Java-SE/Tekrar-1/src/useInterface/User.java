package useInterface;

public class User implements IUser, IProfile {

    @Override
    public boolean userLogin(String email, String password) {
        if (password.length() > 0 && password.length() < 10) {

        }
        return false;
    }

    @Override
    public String userName(int userID) {
        return "Ali Bilmem";
    }


    @Override
    public String profileImage(int userID) {
        return null;
    }

    @Override
    public String address(int userID) {
        return null;
    }
}
