package stock.gui.panel;

import stock.Stock;
import stock.gui.frame.StockGUI;

import javax.swing.*;
import java.awt.*;

// 주식의 간단한 정보를 나타내는 Panel
public class StockPanel extends JPanel {

    private Stock stock;

    public StockPanel(Stock stock) {
        this.stock = stock;

        setLayout(null);
        setPreferredSize(new Dimension(150, 100));

        JButton detailButton = new JButton("차트 확인");
        detailButton.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> {
                StockGUI stockGUI = new StockGUI(stock);
            });
        });
        detailButton.setBounds(0, 69, 160, 30);

        add(detailButton, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 테두리 그리기
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        // 주식 정보 그리기
        g.setColor(Color.BLACK);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        g.setFont(font);

        String nameText = "주식명: " + stock.getName();
        String descriptionText = "설명: " + stock.getDescription();
        String priceText;

        if (stock.isDelisted()) {
            priceText = "(상장 폐지)";
        } else {
            priceText = "가격: " + stock.getPrice();
        }

        int textX = 10;
        int textY = 20;

        g.drawString(nameText, textX, textY);
        g.drawString(descriptionText, textX, textY + 20);
        g.drawString(priceText, textX, textY + 40);
    }

}
