package CourseWork.views;


import CourseWork.BankCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {
    JTable table;
    public Display(ArrayList<BankCard> cards){
        super("Display");// set the window title
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1400, 700);// set the window size
        setLocationRelativeTo(null);// center the window
        setVisible(true);// make the window visible
        JPanel panel = new JPanel();
        String[] columnNames = {"Card Id", "Client Name", "Bank Account", "Balance", "Card Type"};
        String[][] data = new String[cards.size()][5];
        System.out.println(cards);
        System.out.println(cards.size());
        for (int i = 0; i < cards.size(); i++) {
            data[i][0] = String.valueOf(cards.get(i).getCardId());
            data[i][1] = String.valueOf(cards.get(i).getClientName());
            data[i][2] = String.valueOf(cards.get(i).getBankAccount());
            data[i][3] = String.valueOf(cards.get(i).getBalanceAmount());
            data[i][4] = cards.get(i) instanceof CourseWork.DebitCard ? "Debit Card" : "Credit Card";
        }
        GridBagConstraints abc = new GridBagConstraints();
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2)); // add a border
        abc.gridx = 0; // set the grid x position
        abc.gridy = 0; // set the grid y position
        abc.weightx = 1.0; // set the horizontal weight
        abc.weighty = 1.0; // set the vertical weight
        scrollPane.setPreferredSize(new Dimension(1300, 600));
//        abc.insets = new Insets(10, 100, 10, 0); // set the padding
        panel.add(scrollPane, abc);
        add(panel); // add the panel to the frame
    }

}
