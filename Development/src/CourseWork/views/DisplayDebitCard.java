package CourseWork.views;

import CourseWork.BankCard;
import CourseWork.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

// Class to display Debit Card details in a JTable
public class DisplayDebitCard extends JFrame {
    JTable table;

    // Constructor that takes an ArrayList of BankCard objects
    public DisplayDebitCard(ArrayList<BankCard> cards){
        super("Display Debit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1450, 650);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Column names for the JTable
        String[] columnNames = {"Card Id","Client Name","Card Type", "Bank Account", "Balance",   "Pin", "Has Withdrawn","Last Withdrawal","Date Of Withdrawal"};
        // Column names for the JTable
        ArrayList<DebitCard> debitCards = new ArrayList<>();

        // Loop through the BankCard objects and add DebitCard objects to the ArrayList
        for (BankCard bankCard : cards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        // Create a two-dimensional array to store the JTable data

        String[][] data = new String[debitCards.size()][9];
        // Loop through the DebitCard objects and add their details to the data array
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getClientName());
            data[i][2] =  "Debit Card";
            data[i][3] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][4] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][5] = String.valueOf(debitCards.get(i).getPinNumber());
            data[i][6] = String.valueOf(debitCards.get(i).hasWithdrawn());
            data[i][7] = String.valueOf(debitCards.get(i).getLastWithdrawal());
            data[i][8] = String.valueOf(debitCards.get(i).getDateOfWithdrawal());

        }
        // Create the JTable with the data and column names, and add it to a JScrollPane
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}