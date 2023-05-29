package CourseWork;

import CourseWork.views.Display;
import CourseWork.views.DisplayCreditCard;
import CourseWork.views.DisplayDebitCard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Font;


public class BankGUI extends JFrame {

    //     creating attribute array list
    private ArrayList<BankCard> cards;

    private JFrame frame;
    private JTabbedPane pane;


    //Attributes for Debit card
    private JLabel titleLabel, datetimeLabel, balanceAmountLabelOne, cardIdDebit, bankAccountLabelOne, issuerBankLabelOne, clientNameLabelOne, pinNumberLabelOne;
    private JTextField balanceAmountTextOne, cardIdTextOne, bankAccountTextOne, issuerBankTextOne, clientNameTextOne, pinNumberTextOne;
    private JButton clearDebitCardButton, submitButtonDebit, displayDebit;
    private JPanel panelDebit;

//    Attribute for CreditCard

    private JLabel dateCredit, titleCredit, cardIdLabelTwo, clientNameLabelTwo, issuerBankLabelTwo, bankAccountLabelTwo, balanceAmountLabelTwo, cvcNumberLabelTwo, intrestRatelabel, expirationDateLable;
    private JTextField cardIdTextTwo, clientNameTextTwo, issuerBankTextTwo, balanceAmountTextTwo, cvcNumberTextTwo, intrestRateField, bankAccountTextTwo;
    private JComboBox<String> expirationDateComboBox, expirationMonth, expirationYear;
    private JButton submitCreditButton, clearCreditButton, displayCredit;
    private JPanel panelCredit;

    //withdraw debit card
    private JLabel dateWithdraw, withdrawTitle, cardIdLabelThree, withdrawalAmountLabel, withdrawalDate, pinNumberLabelThree;
    private JPanel withdarawPanel;
    private JButton withdrawButton, cancelWithdrawButton;
    private JTextField cardIdTextThree, withdrawalAmountText, pinNumberTextThree;
    private JComboBox<String> withdrawalDateComboBox, withdrawalMonth, withdrawalYear;

    //set the credit limit
    private JLabel cardIdLabelFour, creditLimitLabel, gracePeriodLabel, setCreditLimitTitle, dateCreditLimit;
    private JTextField cardIdTextFour, creditLimitText, gracePeriodText;
    private JButton setCreditLimit;
    private JPanel setCreditLimitPanel;
    private JButton displayCards;

    //    attributes for cancel credit
    private JPanel cancelCredit;
    private JLabel cancelCreditDate, cancelCreditTitle;
    private JButton cancelCreditCardBotton, cancelCreditCardClear;
    private JLabel cancelCreditL;
    private JTextField cancelCreditTf;

    //    creating panels
    private JPanel panelOne, panelTwo, panelThree, panelFour, panelFive, panelSix;


//attributes for button


    public BankGUI() {
//         Creating a new JFrame
        frame = new JFrame("Banking System");

        cards = new ArrayList<BankCard>();


//       using grid-bag layout for the panelOne
        panelOne = new JPanel(new GridBagLayout());
//        providing border to the panelOne
        panelOne.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Debit Card Section"));

//         using GridBagLayout for the panelTwo
        panelTwo = new JPanel(new GridBagLayout());
//        providing border to the panelTwo
        panelTwo.setBorder(new TitledBorder(
                        new LineBorder(Color.black, 1),
                        "Credit Card Section"
                )
        );
        panelThree = new JPanel(new GridBagLayout());
        panelThree.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Withdraw Section "
        ));
        panelFour = new JPanel(new GridBagLayout());
        panelFour.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Set Credit Section "
        ));
        panelFive = new JPanel(new GridBagLayout());
        panelFive.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Cancel Credit Section"
        ));
        panelSix = new JPanel(new GridBagLayout());
        panelSix.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Display Section"
        ));
        panelDebit = new JPanel(new GridBagLayout());
        panelDebit.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Input Section"));
        panelCredit = new JPanel(new GridBagLayout());
        panelCredit.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Input Section"));
        withdarawPanel = new JPanel(new GridBagLayout());
        withdarawPanel.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Input Section"));
        setCreditLimitPanel = new JPanel(new GridBagLayout());
        setCreditLimitPanel.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Input Section"));
        cancelCredit = new JPanel(new GridBagLayout());
        cancelCredit.setBorder(new TitledBorder(
                new LineBorder(Color.black, 1),
                "Input Section"));


//          making new object of gridBagConstraints as abc
        GridBagConstraints abc = new GridBagConstraints();
        abc.fill = GridBagConstraints.HORIZONTAL;

//        creating the object for labels and initializing them for debit
        clientNameLabelOne = new JLabel("Client Name  :");
        clientNameLabelOne.setFont(new Font("Arial", Font.BOLD, 15));
        cardIdDebit = new JLabel("Card I'D  :");
        cardIdDebit.setFont(new Font("Arial", Font.BOLD, 15));
        pinNumberLabelOne = new JLabel("Pin Number  :");
        pinNumberLabelOne.setFont(new Font("Arial", Font.BOLD, 15));
        issuerBankLabelOne = new JLabel("Issuer Bank  :");
        issuerBankLabelOne.setFont(new Font("Arial", Font.BOLD, 15));
        bankAccountLabelOne = new JLabel("Account Number  :");
        bankAccountLabelOne.setFont(new Font("Arial", Font.BOLD, 15));
        balanceAmountLabelOne = new JLabel("Balance Amount  :");
        balanceAmountLabelOne.setFont(new Font("Arial", Font.BOLD, 15));

//     Debit text area
        clientNameTextOne = new JTextField(20);
        cardIdTextOne = new JTextField(20);
        pinNumberTextOne = new JTextField(20);
        issuerBankTextOne = new JTextField(20);
        bankAccountTextOne = new JTextField(20);
        balanceAmountTextOne = new JTextField(20);
        //Debit  time
        datetimeLabel = new JLabel();
        // credit time
        dateCredit = new JLabel();
        dateWithdraw = new JLabel();
        dateCreditLimit = new JLabel();
        cancelCreditDate = new JLabel();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Thread datetimeThread = new Thread(() -> {
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                String datetimeString = formatter.format(now);
                datetimeLabel.setText(datetimeString);
                dateCredit.setText(datetimeString);
                dateWithdraw.setText(datetimeString);
                dateCreditLimit.setText(datetimeString);
                cancelCreditDate.setText(datetimeString);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        datetimeThread.start();

//     debitCard button

        submitButtonDebit = new JButton("Add Debit");
        clearDebitCardButton = new JButton("Clear");
        displayDebit = new JButton("Display");
        submitButtonDebit.setPreferredSize(new Dimension(100, 40));
        clearDebitCardButton.setPreferredSize(new Dimension(100, 40));
        displayDebit.setPreferredSize(new Dimension(100, 40));

//        adding feature in debit card gui buttons


        submitButtonDebit.addActionListener(e -> {
            try {
                String cardId = cardIdTextOne.getText();
                String clientName = clientNameTextOne.getText();
                String pinNumber = pinNumberTextOne.getText();
                String issuerBank = issuerBankTextOne.getText();
                String bankAccount = bankAccountTextOne.getText();
                String balanceAmount = balanceAmountTextOne.getText();

                if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issuerBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    double balance = Double.parseDouble(balanceAmount);
                    int card = Integer.parseInt(cardId);
                    int pin = Integer.parseInt(pinNumber);

                    for(BankCard existingCard: cards){
                        if(existingCard.getCardId()==card){
                            JOptionPane.showMessageDialog(null, "A debit card with the same Card ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                        }
                    }
                    if ((card < 0) || (card == 0)) {
                        JOptionPane.showMessageDialog(null, "Card I'D should not be 0 or not less than 0", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    DebitCard debitCard = new DebitCard(balance, card, bankAccount, issuerBank, clientName, pin);
                    cards.add(debitCard);
                    JOptionPane.showMessageDialog(null, "Debit Card added successfully");
                    debitClear();

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        clearDebitCardButton.addActionListener(e -> {
            debitClear();
        });
        displayCards = new JButton("CLICK HERE FOR DISPLAYING CARDS");
        displayDebit.addActionListener(e -> {
            new DisplayDebitCard(cards);
        });
//        creating the object for labels and initializing them for credit

//     credit labels

        cardIdLabelTwo = new JLabel("Card I'D  :");
        cardIdLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        cvcNumberLabelTwo = new JLabel("CVC Number  :");
        cvcNumberLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        clientNameLabelTwo = new JLabel("Client Name  :");
        clientNameLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        issuerBankLabelTwo = new JLabel("Issuer Bank  :");
        issuerBankLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        bankAccountLabelTwo = new JLabel("Account Number  :");
        bankAccountLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        balanceAmountLabelTwo = new JLabel("Balance Amount  :");
        balanceAmountLabelTwo.setFont(new Font("Arial", Font.BOLD, 15));
        expirationDateLable = new JLabel("Expiration Date  :");
        expirationDateLable.setFont(new Font("Arial", Font.BOLD, 15));
        intrestRatelabel = new JLabel("Interest rate  :");
        intrestRatelabel.setFont(new Font("Arial", Font.BOLD, 15));


//           credit text field

        cardIdTextTwo = new JTextField(20);
        cvcNumberTextTwo = new JTextField(20);
        clientNameTextTwo = new JTextField(20);
        issuerBankTextTwo = new JTextField(20);
        bankAccountTextTwo = new JTextField(20);
        balanceAmountTextTwo = new JTextField(20);
        intrestRateField = new JTextField(20);
        expirationDateComboBox = new JComboBox<>();
        expirationMonth = new JComboBox<>();
        expirationYear = new JComboBox<>();


//      credit card button
        submitCreditButton = new JButton("Add Credit");
        clearCreditButton = new JButton("Clear");
        displayCredit = new JButton("Display");
        submitCreditButton.setPreferredSize(new Dimension(100, 40));
        clearCreditButton.setPreferredSize(new Dimension(100, 40));
        displayCredit.setPreferredSize(new Dimension(100, 40));

// Add an action listener to the submitCreditButton
        submitCreditButton.addActionListener(e -> {
            try {
                // Get the input values from the corresponding text fields
                String cardId = cardIdTextTwo.getText();
                String clientName = clientNameTextTwo.getText();
                String issuerBank = issuerBankTextTwo.getText();
                String bankAccount = bankAccountTextTwo.getText();
                String balanceAmount = balanceAmountTextTwo.getText();
                String cvcNumber = cvcNumberTextTwo.getText();
                String interestRate = intrestRateField.getText();
                // Get the expiration date by combining the selected values from three combo boxes
                String expirationDate = expirationYear.getSelectedItem().toString() + "-" + expirationMonth.getSelectedItem().toString() + "-" + expirationDateComboBox.getSelectedItem().toString();
                // Check if any of the fields are empty
                if (cardId.equals("") || clientName.equals("") || issuerBank.equals("") || bankAccount.equals("") || balanceAmount.equals("") || cvcNumber.equals("") || interestRate.equals("")
                        || expirationYear.getSelectedItem().equals("Year") || expirationMonth.getSelectedItem().equals("Months") || expirationDateComboBox.getSelectedItem().equals("Date")
                ) {
                    // Display an error message if any field is empty
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Convert the input values to their appropriate data types
                    int card = Integer.parseInt(cardId);
                    double balance = Double.parseDouble(balanceAmount);
                    int cvc = Integer.parseInt(cvcNumber);
                    double interest = Double.parseDouble(interestRate);
                    // Check if a credit card with the same card ID already exists
                    for(BankCard existingCard: cards) {
                        if (existingCard.getCardId() == card) {
                            JOptionPane.showMessageDialog(null, "A debit card with the same Card ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    // Check if the card ID is not less than or equal to 0
                    if ((card < 0) || (card == 0)) {
                        JOptionPane.showMessageDialog(null, "Card I'D should not be 0 or not less than 0", "Error", JOptionPane.ERROR_MESSAGE);
                        // Exit the method if the card ID is invalid
                        return;
                    }
                    // Create a new CreditCard object and add it to the cards ArrayList
                    CreditCard creditCard = new CreditCard(card, clientName, issuerBank, bankAccount, balance, cvc, interest, expirationDate);
                    cards.add(creditCard);
                    // Display a success message and clear the input fields
                    JOptionPane.showMessageDialog(null, "Credit Card added successfully");
                    creditClear();
                }
            } catch (NumberFormatException ex) {
                // Display an error message if the user inputs an invalid number
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        clearCreditButton.addActionListener(e -> {
            //calling clear method for clearing credit
            creditClear();

        });

        displayCredit.addActionListener(e -> {
            //calling display method for displaying credit cards
            new DisplayCreditCard(cards);
        });
//        creating the object for labels and initializing them for withdraw from debit card


//      withdraw from debit label
        pinNumberLabelThree = new JLabel("Pin Number  :");
        pinNumberLabelThree.setFont(new Font("Arial", Font.BOLD, 15));
        withdrawalAmountLabel = new JLabel("Withdrawal Amount  :");
        withdrawalAmountLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cardIdLabelThree = new JLabel("Card I'D  :");
        cardIdLabelThree.setFont(new Font("Arial", Font.BOLD, 15));
        withdrawalDate = new JLabel("Date of Withdrawal  :");
        withdrawalDate.setFont(new Font("Arial", Font.BOLD, 15));

//     withdarw text field
        pinNumberTextThree = new JTextField(20);
        withdrawalAmountText = new JTextField(20);
        cardIdTextThree = new JTextField(20);
        withdrawalDateComboBox = new JComboBox<>();
        withdrawalMonth = new JComboBox<>();
        withdrawalYear = new JComboBox<>();

//     withdarw debit buttons
        withdrawButton = new JButton("Withdraw");
        cancelWithdrawButton = new JButton("Cancel Withdrawal");

        // Populate combo box with expiration date options and withdrawal date options

        // Add years to expiration
        int currentYear = LocalDate.now().getYear();
        expirationYear.addItem("Year");
        withdrawalYear.addItem("Year");

        for (int year = currentYear; year >= currentYear - 10; year--) {
            expirationYear.addItem(String.valueOf(year));
            withdrawalYear.addItem(String.valueOf(year));
        }

// Add months to monthComboBox

        expirationMonth.addItem("Month");
        withdrawalMonth.addItem("Month");
        for (int month = 1; month <= 12; month++) {
            expirationMonth.addItem(String.format("%02d", month));
            withdrawalMonth.addItem(String.format("%02d", month));
        }

// Add dates to dateComboBox

        expirationDateComboBox.addItem("Date");
        withdrawalDateComboBox.addItem("Date");

        YearMonth yearMonthObject = YearMonth.of(currentYear, 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int day = 1; day <= daysInMonth; day++) {
            expirationDateComboBox.addItem(String.format("%02d", day));
            withdrawalDateComboBox.addItem(String.format("%02d", day));

        }


        withdrawButton.addActionListener(e -> {
            String debitCardId = cardIdTextThree.getText();
            String debitWithdraw = withdrawalAmountText.getText();
            String debitPin = pinNumberTextThree.getText();
            String dateOfWithdrawal = withdrawalYear.getSelectedItem().toString() + "-" + withdrawalMonth.getSelectedItem().toString() + "-" + withdrawalDateComboBox.getSelectedItem().toString();
            // Check if any of the fields are empty

            try {
                if (cards.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Add DEBIT CARD in BANK A/C Firts", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (debitCardId.isEmpty() || debitWithdraw.isEmpty() || debitPin.isEmpty() || withdrawalYear.getSelectedItem().equals("Year") || withdrawalMonth.getSelectedItem().equals("Month") || withdrawalDateComboBox.getSelectedItem().equals("Day")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int cardId = Integer.parseInt(debitCardId);
                    int pinNumber = Integer.parseInt(debitPin);
                    int withdrawalAmount = Integer.parseInt(debitWithdraw);
                    boolean foundCard = false;
                    DebitCard debitCard = null;
                    //  It iterates over the "bankCards" ArrayList using the enhanced for loop syntax and checks each debit card object to find the one with the given card ID.

                    //usage of downcasting to access the object of bankcard
                    for (BankCard bankCard : cards) {
                        //usage of downcasting to access the object of bankcard
                        if (bankCard instanceof DebitCard) {
                            debitCard = (DebitCard) bankCard;
                            if (debitCard.getCardId() == cardId) {
                                foundCard = true;
                                break;
                            }
                        }
                    }

                    if (foundCard) {
                        if (withdrawalAmount < 0) {
                            JOptionPane.showMessageDialog(null, "The withdrawal amount must be greater than 0 and cannot be negative", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        withdraw(debitCard, withdrawalAmount, dateOfWithdrawal, pinNumber);
                    } else {
                        JOptionPane.showMessageDialog(null, "Card not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        cancelWithdrawButton.addActionListener(e -> {
            withDrawClear();
        });

//                    Set Credit Limit

//        creating the object for labels and initializing them for set Credit Limits

        cardIdLabelFour = new JLabel("Card I'D  :");
        cardIdLabelFour.setFont(new Font("Arial", Font.BOLD, 15));
        gracePeriodLabel = new JLabel("Grace Period  :");
        gracePeriodLabel.setFont(new Font("Arial", Font.BOLD, 15));
        creditLimitLabel = new JLabel("Credit Limit  :");
        creditLimitLabel.setFont(new Font("Arial", Font.BOLD, 15));


        cardIdTextFour = new JTextField(20);
        creditLimitText = new JTextField(20);
        gracePeriodText = new JTextField(20);


        setCreditLimit = new JButton("Set Credit Limit");
        setCreditLimit.setPreferredSize(new Dimension(100, 40));

        setCreditLimit.addActionListener(e -> {
            String setCreditCardId = cardIdTextFour.getText();
            String setCreditLimited = creditLimitText.getText();
            String gracedPeriod = gracePeriodText.getText();


            if (cards.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ADD CREDIT CARD in BANK A/C ", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (setCreditCardId.isEmpty() || setCreditLimited.isEmpty() || gracedPeriod.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int cardId = Integer.parseInt(setCreditCardId);
                    double newCreditLimit = Double.parseDouble(setCreditLimited);
                    int newGracePeriod = Integer.parseInt(gracedPeriod);
                    if (newGracePeriod < 0) {
                        JOptionPane.showMessageDialog(null, "Grace Period ", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    for (BankCard bankCard : cards) {
                        if (bankCard.getCardId() == cardId && bankCard instanceof CreditCard creditCard) {
                            if (newCreditLimit <= 2.3 * creditCard.getBalanceAmount()) {
                                creditCard.setCreditLimit(newCreditLimit, newGracePeriod);
                                cards.set(cards.indexOf(creditCard), creditCard); //??
                                JOptionPane.showMessageDialog(null, "New Credit Set");
                                setCreditClear();
                            } else {
                                JOptionPane.showMessageDialog(null, "Limit Breached!! Lower Set Amount of Your Credit Card", "Error", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Value", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        displayCards.addActionListener(e -> {
            new Display(cards);
        });
//            cancelCredit
        cancelCreditL = new JLabel("Card I'D :");
        cancelCreditL.setFont(new Font("Arial", Font.BOLD, 15));
        cancelCreditTf = new JTextField(20);
        cancelCreditCardBotton = new JButton("Cancel Credit");
        cancelCreditCardBotton.setPreferredSize(new Dimension(100, 40));
        cancelCreditCardClear = new JButton("Clear");
        cancelCreditCardClear.setPreferredSize(new Dimension(100, 40));

        cancelCreditCardBotton.addActionListener(e -> {
            //exception handling
            try {
                String cardIdForCreditCancel = cancelCreditTf.getText();

                //checks if the arraylist is empty
                if (cards.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please add credit card in Bank A/C first","Error",JOptionPane.ERROR_MESSAGE);
                } else if (cardIdForCreditCancel.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up the fields","Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    int cardID = Integer.parseInt(cardIdForCreditCancel);
                    boolean foundCardId = false;
                    CreditCard creditCard = null;
//                    It iterates over the "bankCards" ArrayList using the enhanced for loop syntax and checks each credit card object to find the one with the given card ID.
                    for (BankCard bankCard : cards) {
                        //usage of downcasting to access the object of bankcard
                        if (bankCard instanceof CreditCard) {
                            creditCard = (CreditCard) bankCard;
                            if (creditCard.getCardId() == cardID) {
                                foundCardId = true;
                                break;
                            }
                        }
                    }
                    if (foundCardId) {
                        //call the cancelcreditcard method from creditcard
                        cancelCreditCard(creditCard);
                        //updates the bankcard array with newly updated credit card object
                        cards.set(cards.indexOf(creditCard), creditCard);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the valid Card Id","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter the valid input","Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelCreditCardClear.addActionListener(e -> {
            cancelCreditCardClearOne();
        });


        //         Set JFrame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setting the size of frame
        frame.setSize(1500, 800);
//        frame.setResizable(false);
        //making the frame visible
        frame.setVisible(true);
//        setting the GridBag-layout in frame
        frame.setLayout(new

                GridBagLayout());
//        Center window on screen
        frame.setLocationRelativeTo(null);
//        adding the panelOne to frame
        frame.add(panelOne);
        //adding the panelTwo to frame
        frame.add(panelTwo);
        frame.add(panelThree);
        frame.add(panelFour);
        frame.add(panelFive);
        frame.add(panelSix);
        frame.add(panelDebit);
        frame.add(withdarawPanel);
        frame.add(panelCredit);
        frame.add(setCreditLimitPanel);

        titleLabel = new

                JLabel("Debit Card..");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new

                Font("Arial", Font.BOLD, 50));

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(90, 955, 0, 0);
        panelOne.add(datetimeLabel, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(10, 400, 5, 400);
        panelOne.add(titleLabel, abc);

//         adding paneldebit inside panel one

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(10, 10, 90, 10);
        panelDebit.setBackground(Color.LIGHT_GRAY);
        panelOne.add(panelDebit, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(30, 50, 20, 0);
        panelDebit.add(cardIdDebit, abc);

        abc.gridx = 1;
        abc.gridy = 0;
        abc.insets = new

                Insets(30, 10, 20, 50);
        panelDebit.add(cardIdTextOne, abc);

        abc.gridx = 2;
        abc.gridy = 0;
        abc.gridwidth = 1;
//         here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(30, 50, 20, 0);
        panelDebit.add(clientNameLabelOne, abc);

        abc.gridx = 3;
        abc.gridy = 0;
        abc.insets = new

                Insets(30, 10, 20, 50);
        panelDebit.add(clientNameTextOne, abc);


        abc.gridx = 0;
        abc.gridy = 1;
        abc.insets = new

                Insets(20, 50, 20, 0);
        panelDebit.add(pinNumberLabelOne, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(20, 10, 20, 50);
        panelDebit.add(pinNumberTextOne, abc);

        abc.gridx = 2;
        abc.gridy = 1;
        //         here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(20, 50, 20, 0);
        panelDebit.add(issuerBankLabelOne, abc);

        abc.gridx = 3;
        abc.gridy = 1;
        abc.insets = new

                Insets(20, 10, 20, 50);
        panelDebit.add(issuerBankTextOne, abc);

        abc.gridx = 0;
        abc.gridy = 2;
        //         here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(20, 50, 20, 0);
        panelDebit.add(bankAccountLabelOne, abc);

        abc.gridx = 1;
        abc.gridy = 2;
        abc.insets = new

                Insets(20, 10, 20, 50);
        panelDebit.add(bankAccountTextOne, abc);


        abc.gridx = 2;
        abc.gridy = 2;
        abc.insets = new

                Insets(20, 50, 20, 0);
        panelDebit.add(balanceAmountLabelOne, abc);

        abc.gridx = 3;
        abc.gridy = 2;
        abc.insets = new

                Insets(20, 10, 20, 50);
        panelDebit.add(balanceAmountTextOne, abc);

        abc.gridx = 0;
        abc.gridy = 3;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(30, 100, 40, 50);

        abc.anchor = GridBagConstraints.CENTER;
        panelDebit.add(submitButtonDebit, abc);

        abc.gridx = 2;
        abc.gridy = 3;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(30, 100, 40, 50);
        panelDebit.add(clearDebitCardButton, abc);

        abc.gridx = 0;
        abc.gridy = 4;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(5, 300, 20, -200);
        panelDebit.add(displayDebit, abc);

        //positioning and arranging labels for Credit card
        titleCredit = new

                JLabel("Credit Card..");
        titleCredit.setForeground(Color.BLUE);
        titleCredit.setFont(new

                Font("Arial", Font.BOLD, 50));

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(90, 980, 0, 0);
        panelTwo.add(dateCredit, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(10, 400, 0, 400);
        panelTwo.add(titleCredit, abc);


        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(20, 10, 90, 20);
        panelCredit.setBackground(Color.LIGHT_GRAY);
        panelTwo.add(panelCredit, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 1;
//         here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.HORIZONTAL;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(25, 40, 20, 0);
        panelCredit.add(cardIdLabelTwo, abc);

        abc.gridx = 1;
        abc.gridy = 0;
        abc.insets = new

                Insets(25, 5, 10, 40);
        panelCredit.add(cardIdTextTwo, abc);

        abc.gridx = 2;
        abc.gridy = 0;
        abc.gridwidth = 1;
        abc.anchor = GridBagConstraints.LINE_END;
        abc.fill = GridBagConstraints.BOTH;
        abc.insets = new

                Insets(25, 40, 10, 0);
        panelCredit.add(clientNameLabelTwo, abc);

        abc.gridx = 3;
        abc.gridy = 0;
        abc.insets = new

                Insets(25, 5, 10, 40);
        panelCredit.add(clientNameTextTwo, abc);


        abc.gridx = 0;
        abc.gridy = 1;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(cvcNumberLabelTwo, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(10, 5, 10, 40);
        panelCredit.add(cvcNumberTextTwo, abc);


        abc.gridx = 2;
        abc.gridy = 1;
        abc.fill = GridBagConstraints.BOTH;
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(issuerBankLabelTwo, abc);

        abc.gridx = 3;
        abc.gridy = 1;
        abc.insets = new

                Insets(10, 5, 10, 40);
        panelCredit.add(issuerBankTextTwo, abc);


        abc.gridx = 0;
        abc.gridy = 2;
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(bankAccountLabelTwo, abc);

        abc.gridx = 1;
        abc.gridy = 2;
        abc.insets = new

                Insets(10, 5, 10, 40);
        panelCredit.add(bankAccountTextTwo, abc);

        abc.gridx = 2;
        abc.gridy = 2;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(balanceAmountLabelTwo, abc);

        abc.gridx = 3;
        abc.gridy = 2;
        abc.insets = new

                Insets(10, 5, 10, 40);
        panelCredit.add(balanceAmountTextTwo, abc);

        abc.gridx = 0;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(intrestRatelabel, abc);

        abc.gridx = 1;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, 5, 10, 40);
        panelCredit.add(intrestRateField, abc);

        abc.gridx = 2;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, 40, 10, 0);
        panelCredit.add(expirationDateLable, abc);

        abc.gridx = 3;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, 5, 10, 175);
        panelCredit.add(expirationYear, abc);

        abc.gridx = 4;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, -175, 10, 105);
        panelCredit.add(expirationMonth, abc);

        abc.gridx = 5;
        abc.gridy = 3;
        abc.insets = new

                Insets(10, -105, 10, 40);
        panelCredit.add(expirationDateComboBox, abc);


        abc.gridx = 0;
        abc.gridy = 4;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(30, 100, 40, 50);

        abc.anchor = GridBagConstraints.CENTER;
        panelCredit.add(submitCreditButton, abc);

        abc.gridx = 2;
        abc.gridy = 4;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(30, 100, 40, 50);
        panelCredit.add(clearCreditButton, abc);

        abc.gridx = 0;
        abc.gridy = 5;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(5, 300, 20, -200);
        panelCredit.add(displayCredit, abc);


        //positioning and arranging labels for Withdraw from debit

        withdrawTitle = new

                JLabel("Withdraw Amount..");
        withdrawTitle.setForeground(Color.BLUE);
        withdrawTitle.setFont(new

                Font("Arial", Font.BOLD, 50));

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(90, 1055, 0, 0);
        panelThree.add(dateWithdraw, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(10, 400, 0, 400);
        panelThree.add(withdrawTitle, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(10, 80, 90, 80);
        withdarawPanel.setBackground(Color.LIGHT_GRAY);
        panelThree.add(withdarawPanel, abc);


        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(50, 50, 30, 0);
        withdarawPanel.add(cardIdLabelThree, abc);

        abc.gridx = 1;
        abc.gridy = 0;
        abc.insets = new

                Insets(50, 10, 30, 50);
        withdarawPanel.add(cardIdTextThree, abc);

        abc.gridx = 2;
        abc.gridy = 0;
        abc.insets = new

                Insets(50, 50, 30, 0);
        withdarawPanel.add(withdrawalAmountLabel, abc);

        abc.gridx = 3;
        abc.gridy = 0;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(50, 20, 30, 50);
        withdarawPanel.add(withdrawalAmountText, abc);


        abc.gridx = 0;
        abc.gridy = 1;
        abc.insets = new

                Insets(30, 50, 30, 0);
        withdarawPanel.add(pinNumberLabelThree, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(30, 20, 30, 50);
        withdarawPanel.add(pinNumberTextThree, abc);

        abc.gridx = 2;
        abc.gridy = 1;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(30, 50, 30, 0);
        withdarawPanel.add(withdrawalDate, abc);

        abc.gridx = 3;
        abc.gridy = 1;
        abc.insets = new

                Insets(30, 20, 30, 175);
        withdarawPanel.add(withdrawalYear, abc);

        abc.gridx = 4;
        abc.gridy = 1;
        abc.insets = new

                Insets(30, -175, 30, 105);
        withdarawPanel.add(withdrawalMonth, abc);

        abc.gridx = 5;
        abc.gridy = 1;
        abc.insets = new

                Insets(30, -105, 30, 40);
        withdarawPanel.add(withdrawalDateComboBox, abc);


        abc.gridx = 0;
        abc.gridy = 2;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(30, 100, 40, 50);
        withdarawPanel.add(withdrawButton, abc);
        withdrawButton.setPreferredSize(new

                Dimension(100, 40));

        abc.gridx = 2;
        abc.gridy = 2;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(30, 100, 40, 50);
        withdarawPanel.add(cancelWithdrawButton, abc);
        cancelWithdrawButton.setPreferredSize(new

                Dimension(100, 40));

        //positioning and arranging labels ,text and buttons for Set Credit Limit
        setCreditLimitTitle = new

                JLabel("Set Credit Limit..");
        setCreditLimitTitle.setForeground(Color.BLUE);
        setCreditLimitTitle.setFont(new

                Font("Arial", Font.BOLD, 50));

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(90, 1000, 10, 0);
        panelFour.add(dateCreditLimit, abc);


        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(-45, 400, -10, 400);
        panelFour.add(setCreditLimitTitle, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(0, 130, 90, 80);
        setCreditLimitPanel.setBackground(Color.LIGHT_GRAY);
        panelFour.add(setCreditLimitPanel, abc);

        abc.gridx = 1;
        abc.gridy = 0;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(40, 40, 20, 10);
        setCreditLimitPanel.add(cardIdLabelFour, abc);

        abc.gridx = 2;
        abc.gridy = 0;
        abc.insets = new

                Insets(40, -285, 20, 35);
        setCreditLimitPanel.add(cardIdTextFour, abc);

        abc.gridx = 0;
        abc.gridy = 1;
        abc.gridwidth = 1;
        //         here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(20, -100, 20, 0);
        setCreditLimitPanel.add(creditLimitLabel, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new Insets(40, 10, 40, 200);
        setCreditLimitPanel.add(creditLimitText, abc);


        abc.gridx = 2;
        abc.gridy = 1;
        abc.gridwidth = 1;
        abc.insets = new

                Insets(30, -125, 30, 0);
        setCreditLimitPanel.add(gracePeriodLabel, abc);

        abc.gridx = 3;
        abc.gridy = 1;
        abc.insets = new

                Insets(40, -10, 40, -60);
        setCreditLimitPanel.add(gracePeriodText, abc);


        abc.gridx = 1;
        abc.gridy = 3;
        abc.insets = new

                Insets(20, 90, 60, 0);
        setCreditLimitPanel.add(setCreditLimit, abc);


        cancelCreditTitle = new

                JLabel("Cancel Credit..");
        cancelCreditTitle.setForeground(Color.BLUE);
        cancelCreditTitle.setFont(new Font("Arial", Font.BOLD, 50));

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.insets = new

                Insets(90, 1000, 0, 0);
        panelFive.add(cancelCreditDate, abc);

        abc.gridx = 0;
        abc.gridy = 0;
        abc.gridwidth = 2;
        abc.anchor = GridBagConstraints.CENTER;
        abc.insets = new

                Insets(10, 450, 0, 400);
        panelFive.add(cancelCreditTitle, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(0, 90, 90, 80);
        cancelCredit.setBackground(Color.LIGHT_GRAY);
        panelFive.add(cancelCredit, abc);

        abc.gridx = 0;
        abc.gridy = 1;
        abc.gridwidth = 1;
        // here, fill resizes the component in both direction when the display area is larger than the component.
        abc.fill = GridBagConstraints.BOTH;
        //anchors columns at the end of the line
        abc.anchor = GridBagConstraints.LINE_END;
        abc.insets = new

                Insets(20, 100, 20, 0);
        cancelCredit.add(cancelCreditL, abc);

        abc.gridx = 1;
        abc.gridy = 1;
        abc.insets = new

                Insets(20, 10, 20, 200);
        cancelCredit.add(cancelCreditTf, abc);

        abc.gridx = 1;
        abc.gridy = 4;
        abc.insets = new Insets(20, -70, 10, 100);
        cancelCredit.add(cancelCreditCardBotton, abc);

        abc.gridx = 1;
        abc.gridy = 5;
        abc.insets = new
                Insets(20, -70, 10, 100);
        cancelCredit.add(cancelCreditCardClear, abc);


        abc.gridx = 0;
        abc.gridy = 0;
        abc.insets = new

                Insets(20, 20, 20, 20);

        abc.fill = GridBagConstraints.BOTH;
        displayCards.setFocusPainted(false);
        displayCards.setFont(new Font("Arial", 20, 30));
        displayCards.setBackground(new Color(128, 128, 128));
        displayCards.setForeground(Color.white);
        displayCards.setMargin(new Insets(10, 10, 10, 10));
        abc.weightx = 1.0;
        abc.weighty = 1.0;
        panelSix.add(displayCards, abc);


        //code to add tabs
        pane = new

                JTabbedPane();
        pane.setBounds(100, 100, 200, 200);
        pane.add("Debit Card ", panelOne);
        pane.add("Credit Card ", panelTwo);
        pane.add("Withdraw ", panelThree);
        pane.add("Set Credit ", panelFour);
        pane.add("Cancel Credit ", panelFive);
        pane.add("Display ", panelSix);
//        adding pane to frame
        frame.add(pane);

    }

    public void withdraw(DebitCard debitCard, int withdrawalAmount, String dateOfWithdrawal, int pinNumber) {
        if (debitCard.getPinNumber() == pinNumber) {
            if (debitCard.getBalanceAmount() < withdrawalAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            debitCard.withdraw(withdrawalAmount, dateOfWithdrawal, pinNumber);
            JOptionPane.showMessageDialog(null, "Withdrawal Successful" );
            withDrawClear();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Pin Number","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelCreditCard(CreditCard creditCard) {
        creditCard.cancelCreditCard();//calling the cancelcreditcard method from credit card
        JOptionPane.showMessageDialog(null, "Your credit card has been cancelled");
        cancelCreditCardClearOne();
    }

    public void cancelCreditCardClearOne() {
        cancelCreditTf.setText("");
    }

    public void debitClear() {
        cardIdTextOne.setText("");
        clientNameTextOne.setText("");
        pinNumberTextOne.setText("");
        issuerBankTextOne.setText("");
        bankAccountTextOne.setText("");
        balanceAmountTextOne.setText("");
    }

    public void creditClear() {
        cardIdTextTwo.setText("");
        clientNameTextTwo.setText("");
        issuerBankTextTwo.setText("");
        bankAccountTextTwo.setText("");
        balanceAmountTextTwo.setText("");
        cvcNumberTextTwo.setText("");
        intrestRateField.setText("");
        expirationMonth.setSelectedItem(0);
        expirationYear.setSelectedItem(0);
        expirationDateComboBox.setSelectedItem(0);
    }

    public void withDrawClear() {
        cardIdTextThree.setText("");
        withdrawalAmountText.setText("");
        pinNumberTextThree.setText("");
        withdrawalYear.setSelectedIndex(0);
        withdrawalMonth.setSelectedIndex(0);
        withdrawalDateComboBox.setSelectedItem(0);
    }

    public void setCreditClear() {
        cardIdTextFour.setText("");
        gracePeriodText.setText("");
        creditLimitText.setText("");
    }


    public static void main(String[] args) {
        new BankGUI();
    }

}

