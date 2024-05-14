package stock.gui.frame;

import bank.gui.frame.BankAccountGUI;
import news.NewsScheduler;
import stock.Stock;
import stock.gui.panel.BuyButton;
import stock.gui.panel.SellButton;
import stock.gui.panel.StockGraphPanel;

import javax.swing.*;
import java.awt.*;

// 주가를 나타내는 GUI
public class StockGUI extends JFrame {

    private Stock stock;
    private JPanel mainPanel;
    private JPanel bottomPanel;

    public StockGUI(Stock stock) {
        super(stock.getName() + " - 차트");

        this.stock = stock;

        initMainPanel();
        initBottomPanel();

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // 60초마다 패널을 갱신하는 쓰레드 시작
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(NewsScheduler.REFRESH_TIME * 1000);
                    refreshPanel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.setDaemon(true); // 데몬 쓰레드로 설정하여 메인 쓰레드 종료 시 함께 종료
        updateThread.start();
    }

    private void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        StockGraphPanel graphPanel = new StockGraphPanel(stock);

        // 창에 그래프 패널 추가
        mainPanel.add(graphPanel);
        // 여백 추가
        mainPanel.add(Box.createHorizontalStrut(20));
    }
    
    private void initBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        JButton balanceButton = new JButton("현재 소지 금액: " + BankAccountGUI.userAccount.getKoreanBalance());
        balanceButton.setBackground(Color.decode("#F0E68C"));
        balanceButton.setForeground(Color.WHITE);
        balanceButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        balanceButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bottomPanel.add(balanceButton);

        bottomPanel.add(Box.createVerticalStrut(30));

        if (!stock.isDelisted()) {
            BuyButton buyButton = new BuyButton(this, stock);
            bottomPanel.add(buyButton);

            bottomPanel.add(Box.createVerticalStrut(30));

            JButton sellButton = new SellButton(this, stock);
            bottomPanel.add(sellButton);
        }

        JButton amountButton = new JButton("현재 보유 수량: " + BankAccountGUI.userAccount.getStockAmount(stock));
        amountButton.setBackground(Color.decode("#3CB371"));
        amountButton.setForeground(Color.WHITE);
        amountButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        amountButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bottomPanel.add(amountButton);

        mainPanel.add(bottomPanel);
    }

    public void refreshPanel() {
        mainPanel.removeAll();

        StockGraphPanel graphPanel = new StockGraphPanel(stock);

        mainPanel.add(graphPanel);
        mainPanel.add(Box.createHorizontalStrut(20));

        initBottomPanel();

        mainPanel.revalidate();
        mainPanel.repaint();
    }

}
