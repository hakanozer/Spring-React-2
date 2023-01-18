package inheritance;

import javax.swing.*;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Draw kare = new Kare();
        Draw dikdortgen = new Dikdortgen();
        Draw ucgen = new Ucgen();

        action(kare);
        action(dikdortgen);
        action(ucgen);

        Settings jFrame = new Settings();
        jFrame.setSize(300,300);
        jFrame.setVisible(true);


    }

    public static void action( Draw draw ) {
        draw.ciz();
    }

}
