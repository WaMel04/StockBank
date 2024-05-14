package bank.gui.frame;

import bank.BankAccount;
import bank.gui.panel.AccountButton;
import bank.gui.panel.AccountPanel;
import stock.gui.frame.StockMarketGUI;

import javax.swing.*;
import java.awt.*;

// 은행 계좌를 나타내는 GUI (어드민 계좌, 내 계좌)
public class BankAccountGUI extends JFrame {

    public static BankAccount adminAccount;
    public static BankAccount userAccount;

    AccountPanel adminAccountPanel;
    AccountPanel userAccountPanel;

    public BankAccountGUI() {
        super("한양은행 - 계좌");

        // 계좌 패널 init
        adminAccountPanel = new AccountPanel(adminAccount);
        userAccountPanel = new AccountPanel(userAccount);

        setLayout(new FlowLayout());
        add(adminAccountPanel);
        add(userAccountPanel);

        // 입금 버튼
        AccountButton depositButton = new AccountButton(this, "입금", "입금할 금액을 입력해주세요:", "어드민 -> 유저 계좌로 돈을 송금합니다.", adminAccount, userAccount);
        add(depositButton);

        // 출금 버튼
        AccountButton withdrawButton = new AccountButton(this, "출금", "출금할 금액을 입력해주세요:", "유저 -> 어드민 계좌로 돈을 송금합니다.", userAccount, adminAccount);
        add(withdrawButton);

        // 주식 창 여는 버튼
        JPanel stockWarpPanel = new JPanel();
        JButton stockWarpButton = new JButton("한양증권 바로가기");
        stockWarpButton.setToolTipText("주식 투자를 할 수 있는 창을 엽니다.");
        stockWarpButton.setBackground(Color.decode("#4682B4"));
        stockWarpButton.setForeground(Color.WHITE);
        stockWarpButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        stockWarpButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        stockWarpButton.addActionListener(event -> {
            dispose();

            SwingUtilities.invokeLater(() -> {
                StockMarketGUI stockGUI = new StockMarketGUI();
            });
        });

        stockWarpPanel.add(stockWarpButton);
        add(stockWarpPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refresh() {
        adminAccountPanel.refresh();
        userAccountPanel.refresh();
    }

}