package CourseWork.views;

import CourseWork.BankCard;
import CourseWork.CreditCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditCard extends JFrame {
    // Define a JTable instance variable
    JTable table;
    public DisplayCreditCard(ArrayList<BankCard> cards){
        super(" Display Credit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1450, 650);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        // Define the column names of the table
        String[] columnNames = {"Card Id", "Client Name",  "Card Type", "Bank Account", "Balance",  "CVC Number", "Interest Rate","Expiration Date","Credi Granted","Credit Limit","Grace Period"};
        // Create a new ArrayList to store the CreditCard objects
        ArrayList<CreditCard> creditCards =new ArrayList<>();

        // Iterate through the list of BankCard objects and add the CreditCard objects to the new ArrayList
        for (BankCard bankCard : cards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }

        // Create a 2D array to store the data for the table
        String[][] dataForCredit = new String[creditCards.size()][11];
        // Fill the 2D array with the data from the CreditCard objects
        for (int i = 0; i < creditCards.size(); i++) {
            dataForCredit[i][0] = String.valueOf(creditCards.get(i).getCardId());
            dataForCredit[i][1] = String.valueOf(creditCards.get(i).getClientName());
            dataForCredit[i][2] = "Credit Card";
            dataForCredit[i][3] = String.valueOf(creditCards.get(i).getBankAccount());
            dataForCredit[i][4] = String.valueOf(creditCards.get(i).getBalanceAmount());
            dataForCredit[i][5] = String.valueOf(creditCards.get(i).getCvcNumber());
            dataForCredit[i][6] = String.valueOf(creditCards.get(i).getInterestRate());
            dataForCredit[i][7] = String.valueOf(creditCards.get(i).getExpirationDate());
            dataForCredit[i][8] = String.valueOf(creditCards.get(i).isGranted());
            dataForCredit[i][9] = String.valueOf(creditCards.get(i).getCreditLimit());
            dataForCredit[i][10] = String.valueOf(creditCards.get(i).getGracePeriod());
        }
        // Create a JTable instance with the data and column names
        table = new JTable(dataForCredit, columnNames);
        // Create a JScrollPane instance and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel and add the panel to the frame
        panel.add(scrollPane);
        add(panel);
    }
}