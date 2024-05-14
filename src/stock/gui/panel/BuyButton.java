package stock.gui.panel;

import bank.gui.frame.BankAccountGUI;
import stock.Stock;
import stock.gui.frame.StockGUI;

import javax.swing.*;
import java.awt.*;

public class BuyButton extends JButton {

    public BuyButton(StockGUI frame, Stock stock) {
        super("매수");

        setToolTipText("주식을 구매합니다.");
        setBackground(Color.decode("#DC143C"));
        setForeground(Color.WHITE);
        setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        addActionListener(event -> {
            String amountString = JOptionPane.showInputDialog("구매할 수량을 입력해주세요: ");

            if (amountString == null)
                return;
            try {
                int amount = Integer.parseInt(amountString);
                int price = stock.getPrice() * amount;

                if (amount <= 0)
                    throw new NumberFormatException("");
                if (BankAccountGUI.userAccount.getBalance() < price) {
                    JOptionPane.showMessageDialog(frame, "소지 금액이 부족합니다.", stock.getName() + " - 구매", JOptionPane.ERROR_MESSAGE);
                } else {
                    BankAccountGUI.userAccount.withdraw(price);
                    BankAccountGUI.userAccount.addStock(stock, amount);
                    JOptionPane.showMessageDialog(frame, amount + "주 구매에 성공하였습니다.", stock.getName() + " - 구매", JOptionPane.PLAIN_MESSAGE);

                    frame.refreshPanel();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "입력값의 형식은 0보다 큰 자연수입니다.", "한양은행 - 계좌", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
