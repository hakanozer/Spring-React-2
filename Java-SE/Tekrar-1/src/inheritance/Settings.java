package inheritance;


import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {

    public Settings() {
        setTitle("");
        setBackground(null);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle("App Title");
    }

    @Override
    public void setBackground(Color bgColor) {
        this.getContentPane().setBackground(Color.darkGray);
    }
}
