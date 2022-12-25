import java.util.Scanner;
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    class chatbot extends JFrame implements ActionListener {
        final String TITLE_OF_PROGRAM = "Chatter: chatbot";
        final int START_LOCATION = 300;
        final int WINDOW_WIDTH = 400;
        final int WINDOW_HEIGHT = 500;
        final String CHB_AI = "AI";
        final String BTN_ENTER = "Enter";

        JTextArea dialogue;
        JCheckBox ai;
        JTextField message;

        public static void main(String[] args) {
            new chatbot();
        }

        chatbot() {
            setTitle(TITLE_OF_PROGRAM);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);

            dialogue = new JTextArea();
            dialogue.setLineWrap(true);
            JScrollPane scrollBar = new JScrollPane(dialogue);

            JPanel dm = new JPanel();
            dm.setLayout(new BoxLayout(dm, BoxLayout.X_AXIS));
            ai = new JCheckBox(CHB_AI);
            message = new JTextField();
            message.addActionListener(this);
            JButton enter = new JButton(BTN_ENTER);
            enter.addActionListener(this);
            dm.add(ai);
            dm.add(message);
            dm.add(enter);
            add(BorderLayout.CENTER, scrollBar);
            add(BorderLayout.SOUTH, dm);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            if (message.getText().trim().length() > 0) {
                dialogue.append(message.getText() + "\n");

            }
            message.setText("");
            message.requestFocusInWindow();
        }
    }

