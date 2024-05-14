package stock.gui.frame;

import bank.gui.frame.BankAccountGUI;
import news.News;
import news.NewsScheduler;
import stock.Stock;
import stock.gui.panel.NewsPanel;
import stock.gui.panel.StockPanel;
import util.FluxibleList;

import javax.swing.*;
import java.awt.*;

// 뉴스와 주식 목록을 나타내는 GUI
public class StockMarketGUI extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private FluxibleList newsPanels = new FluxibleList(NewsScheduler.SELECT_COUNT);

    public StockMarketGUI() {
        super("한양증권 - 메인");

        // 메인 패널 초기화
        initMainPanel();

        // 스크롤 가능한 창 생성
        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(700, 500));

        // 창에 스크롤 패널 추가
        add(scrollPane);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 500);
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

    private void initTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JButton balanceButton = new JButton("현재 소지 금액: " + BankAccountGUI.userAccount.getKoreanBalance());
        balanceButton.setBackground(Color.decode("#F0E68C"));
        balanceButton.setForeground(Color.WHITE);
        balanceButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        balanceButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        topPanel.add(balanceButton);

        topPanel.add(Box.createHorizontalStrut(10));

        JButton bankButton = new JButton("한양은행 바로가기");
        bankButton.setToolTipText("은행 계좌를 확인할 수 있는 창을 엽니다.");
        bankButton.setBackground(Color.decode("#F0E68C"));
        bankButton.setForeground(Color.WHITE);
        bankButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        bankButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bankButton.addActionListener(e -> {
            dispose();

            SwingUtilities.invokeLater(() -> {
                BankAccountGUI bankAccountGUI = new BankAccountGUI();
            });
        });
        topPanel.add(bankButton);

        mainPanel.add(topPanel);
    }

    private void initStockPanels() {
        for (int i=0; i<Stock.stocks.size(); i++) {
            Stock stock = (Stock) Stock.stocks.get(i);

            if (stock != null) {
                StockPanel stockPanel = new StockPanel(stock);
                mainPanel.add(stockPanel);
            }
        }
    }

    private void initMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        initTopPanel();

        if (NewsScheduler.selectedNewsList != null) {
            for (News news : NewsScheduler.selectedNewsList) {
                NewsPanel newsPanel = new NewsPanel(news);
                mainPanel.add(newsPanel);
                newsPanels.add(newsPanel);
            }
        }

        initStockPanels();
    }

    private void refreshPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        initTopPanel();

        if (NewsScheduler.selectedNewsList == null) {
            for (int i=0; i<newsPanels.size(); i++) {
                NewsPanel newsPanel = (NewsPanel) newsPanels.get(i);
                mainPanel.add(newsPanel);
            }
        } else {
            newsPanels.clear();

            for (News news : NewsScheduler.selectedNewsList) {
                NewsPanel newsPanel = new NewsPanel(news);
                mainPanel.add(newsPanel);
                newsPanels.add(newsPanel);
            }
        }

        initStockPanels();

        mainPanel.revalidate();
        mainPanel.repaint();
    }

}
