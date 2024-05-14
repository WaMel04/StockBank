package bank.gui.panel;

import bank.BankAccount;

import javax.swing.*;
import java.awt.*;

public class AccountPanel extends JPanel {

    protected BankAccount account;
    private JTextField nameTextField;
    private JTextField balanceTextField;

    public AccountPanel(BankAccount account) {
        this.account = account;

        JLabel nameLabel = new JLabel("계좌명:");
        JLabel balanceLabel = new JLabel("금액:");

        nameTextField = new JTextField(account.getName());
        nameTextField.setColumns(10);
        nameTextField.setEditable(false);

        balanceTextField = new JTextField(account.getKoreanBalance());
        balanceTextField.setColumns(20);
        balanceTextField.setEditable(false);

        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameTextField);
        add(balanceLabel);
        add(balanceTextField);
    }

    public void refresh() {
        balanceTextField.setText(account.getKoreanBalance());
    }

}
