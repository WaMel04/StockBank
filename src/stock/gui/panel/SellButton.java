package stock.gui.panel;

import bank.gui.frame.BankAccountGUI;
import stock.Stock;
import stock.gui.frame.StockGUI;

import javax.swing.*;
import java.awt.*;

public class SellButton extends JButton {

    public SellButton(StockGUI frame, Stock stock) {
        super("매도");

        setToolTipText("주식을 판매합니다.");
        setBackground(Color.decode("#1E90FF"));
        setForeground(Color.WHITE);
        setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        addActionListener(event -> {
            String amountString = JOptionPane.showInputDialog("판매할 수량을 입력해주세요: ");

            if (amountString == null)
                return;
            try {
                int amount = Integer.parseInt(amountString);
                int price = stock.getPrice() * amount;

                if (amount <= 0)
                    throw new NumberFormatException("");
                if (BankAccountGUI.userAccount.getStockAmount(stock) < amount) {
                    JOptionPane.showMessageDialog(frame, "소유 중인 주의 수량이 부족합니다.", stock.getName() + " - 판매", JOptionPane.ERROR_MESSAGE);
                } else {
                    BankAccountGUI.userAccount.deposit(price);
                    BankAccountGUI.userAccount.removeStock(stock, amount);
                    JOptionPane.showMessageDialog(frame, amount + "주 판매에 성공하였습니다.", stock.getName() + " - 판매", JOptionPane.PLAIN_MESSAGE);

                    frame.refreshPanel();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "입력값의 형식은 0보다 큰 자연수입니다.", "한양은행 - 계좌", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
