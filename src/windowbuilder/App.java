package windowbuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        AlunoWindow main;
        try {
            main = new AlunoWindow();
            main.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
