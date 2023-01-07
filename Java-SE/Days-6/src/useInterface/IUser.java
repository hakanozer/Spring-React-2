package useInterface;

public interface IUser {

    // interface
    // içerisinde gövdesiz methodlar kurgulanır
    // implements anahtar kelimesi ile normal sınıfa özellikleri aktarılmış olurlar.
    // dokümantasyonu kolay hale getirirler.
    // interfaceler içindeki methodlara erişim belirteci vermeye gerek yoktur, defaultta public'tir.

    String userName( int uid );
    int userAge( int uid );

    default boolean status(int uid) {
        if (uid == 10) {
            return true;
        }
        return false;
    }

}
