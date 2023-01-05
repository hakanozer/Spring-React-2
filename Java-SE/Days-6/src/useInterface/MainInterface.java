package useInterface;

public class MainInterface {

    public static void main(String[] args) {

        UserImpl user = new UserImpl();
        user.userAge(30);

        IUser user1 = new UserImpl();
        user1.userName(10);

        IProfile user3 = new UserImpl();
        user3.userProfileName(10);

    }

}
