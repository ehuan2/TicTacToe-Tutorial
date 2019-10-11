import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicButton extends JButton {

    int x,y;
    int state = 0; // 0 refers to the none at all, 1 refers to x, 2 refers to y
    boolean mutable = true;
    static boolean XorNot = true;
    public TicButton(){
        super();
    }
    public TicButton(int x, int y){
        this.x = x;
        this.y = y;

        this.addActionListener(e -> {
            if(mutable) {
                this.changeState(XorNot);
                this.setText(XorNot ? "X" : "O");
                XorNot = !XorNot;
                mutable = false;
            }
        });

    }

    public void changeState(boolean stte){
        state = stte? 1 : 2;
    }

    public static int checkWin(){ // return 0 is no end, return 1 is X win, return 2 is a Y win, return 3 is a tie


        return 0;

    }

}
