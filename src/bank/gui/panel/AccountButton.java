package bank.gui.panel;

import bank.BankAccount;
import bank.BankMessage;
import bank.gui.frame.BankAccountGUI;

import javax.swing.*;
import java.awt.*;

public class AccountButton extends JButton {

    public AccountButton(BankAccountGUI frame, String name, String dialogMessage, String toolTipMessage, BankAccount account, BankAccount opponentAccount) {
        super(name);

        addActionListener(event -> {
            String amountString = JOptionPane.showInputDialog(dialogMessage);

            if (amountString == null)
                return;
            try {
                int amount = Integer.parseInt(amountString);
                BankMessage bankMessage = account.transfer(opponentAccount, amount);

                if (bankMessage.isError()) {
                    JOptionPane.showMessageDialog(frame, bankMessage.getReason(), "한양은행 - 계좌", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, bankMessage.getReason(), "한양은행 - 계좌", JOptionPane.PLAIN_MESSAGE);
                    frame.refresh();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "입력값의 형식은 0보다 큰 자연수입니다.", "한양은행 - 계좌", JOptionPane.ERROR_MESSAGE);
            }
        });

        setToolTipText(toolTipMessage);

        setBackground(Color.decode("#F0E68C"));
        setForeground(Color.WHITE);
        setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setPreferredSize(new Dimension(200, 100));

    }

}
