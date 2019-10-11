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
        this.setText("");
        this.addActionListener(e -> {
            if(mutable) {
                this.changeState(XorNot);
                this.setText(XorNot ? "X" : "O");
                XorNot = !XorNot;
                mutable = false;
            }
            int end = checkWin();
            if(end != 0){
                JOptionPane.showMessageDialog(null, end == 1? "X has won" : end == 2 ? "O has won" : "It's a tie");
                for(int i = 0; i <= GUI.allButton.length-1; i++){
                    for(int j = 0; j <= GUI.allButton.length-1; j++) {
                        GUI.allButton[i][j].setText("");
                        GUI.allButton[i][j].state = 0;
                        GUI.allButton[i][j].mutable = true;
                    }
                }
                XorNot = true;
            }
        });

    }

    public void changeState(boolean stte){
        state = stte? 1 : 2;
    }

    public static int checkWin(){ // return 0 is no end, return 1 is X win, return 2 is a Y win, return 3 is a tie
        int check = 0;
        int checkTwo = 0;
        boolean redo = true;
        boolean redoTwo = true;
        boolean redoThree = true;
        boolean redoFour = true;
        int checkThree = 0;
        int checkFour = 0;
        boolean filled = false;
        for(int i = 0; i <= GUI.allButton.length-1; i++){
            check = 0;
            checkTwo = 0;
            redo = true;
            redoTwo = true;
            int stateCheck = GUI.allButton[i][i].state;
            if(stateCheck != 0) {
                if (checkThree != stateCheck && redoThree) {
                    if (checkThree == 0) {
                        checkThree = stateCheck;
                    } else {
                        redoThree = false;
                    }
                }


                if (i == GUI.allButton.length - 1 && redoThree) {

                    return stateCheck;
                }
            } else {
                redoThree = false;
            }
            int stateCheckTwo = GUI.allButton[GUI.allButton.length-1-i][i].state;

            if(stateCheckTwo != 0) {
                if (checkFour != stateCheckTwo && redoFour) {
                    if (checkFour == 0) {
                        checkFour = stateCheckTwo;
                    } else {
                        redoFour = false;
                    }
                }

                if (i == GUI.allButton.length - 1 && redoFour) {

                    return stateCheckTwo;
                }
            } else {
                redoFour = false;
            }

            for(int j = 0; j <= GUI.allButton[i].length-1; j++){
                int state = GUI.allButton[i][j].state;
                if(state == 0){
                    filled = false;
                }
                if(state != 0 && redo) {

                    if(state != check){
                        if(check == 0){
                            check = state;
                        } else {
                            redo = false;
                        }
                    }
                    if (j == GUI.allButton[i].length - 1 && redo) {


                        return state;
                    }
                } else {
                    redo = false;
                }

                int stateTwo = GUI.allButton[j][i].state;
                if(stateTwo != 0 && redoTwo) {

                    if(stateTwo != checkTwo){
                        if(checkTwo == 0){
                            checkTwo = stateTwo;
                        } else {
                            redoTwo = false;
                        }

                    }
                    if (j == GUI.allButton[j].length - 1 && redoTwo) {

                        return stateTwo;
                    }
                } else {
                    redoTwo = false;
                }


                if(!redo && !redoTwo){
                    break;
                }
            }
        }


        return filled? 3 : 0;

    }

}
