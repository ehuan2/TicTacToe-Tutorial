import javax.swing.*;

public class GUI {

    JFrame frame;
    JPanel panel;
    static TicButton[][] allButton;

    public void setup(){
        frame = new JFrame("TicTacToe");
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GUI(){

        setup();
        frame.setSize(430, 430);
        allButton = new TicButton[3][3];
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++) {
                allButton[i][j] = new TicButton(i,j);
                panel.add(allButton[i][j]);
                allButton[i][j].setBounds(50+100*i, 50 + 100*j, 100, 100);
            }
        }

    }


    public GUI(int x){

        setup();
        frame.setSize(100*(x+1)+30, 100*(x+1)+30);
        allButton = new TicButton[x][x];
        for(int i = 0; i <= x-1; i++){
            for(int j = 0; j <= x-1; j++) {
                allButton[i][j] = new TicButton(i,j);
                panel.add(allButton[i][j]);
                allButton[i][j].setBounds(50+100*i, 50 + 100*j, 100, 100);
            }
        }


    }


}
