import javax.swing.*;

public class Main {
    static GUI a;
    public static void main(String[]args){

        a = new GUI(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the size of the dimensions")));

    }

}
