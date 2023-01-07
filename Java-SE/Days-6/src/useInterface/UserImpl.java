package useInterface;

public class UserImpl implements IUser, IProfile {

    @Override
    public String userName(int uid) {
        status(uid);
        userAge(10);
        return null;
    }

    @Override
    public int userAge(int uid) {
        return 0;
    }

    @Override
    public String userProfileName(int uid) {
        return null;
    }
}
