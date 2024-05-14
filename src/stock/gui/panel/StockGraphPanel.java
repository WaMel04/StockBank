package stock.gui.panel;

import stock.Stock;
import util.FluxibleList;

import javax.swing.*;
import java.awt.*;

public class StockGraphPanel extends JPanel {

    private Stock stock;

    public StockGraphPanel(Stock stock) {
        this.stock = stock;

        setPreferredSize(new Dimension(820, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        FluxibleList priceLog = stock.getPriceLog();

        int dataSize = Math.min(priceLog.size(), 10); // 최대 10개의 주가만 표시

        int startX = 50;
        int baseY = 250;

        int firstPrice = (int) priceLog.get(priceLog.size() - dataSize);

        // 그래프 그리기
        for (int i = 0; i < dataSize; i++) {
            int price = (int) priceLog.get(priceLog.size() - dataSize + i);
            int percentChange = (int) calculatePercent(i, dataSize, firstPrice);

            int x = startX + i * 80;
            int y = baseY - percentChange * 5;

            g.setColor(Color.BLACK);
            g.fillOval(x - 5, y - 5, 10, 10);

            // 각각의 점 위에 가격 표시
            String priceStr = Integer.toString(price);
            g.drawString(priceStr, x - 10, y - 15);

            if (i < dataSize - 1) { // 마지막 점이 아니라면
                // 다음 점의 위치를 구하고
                int nextX = startX + (i + 1) * 80; // x좌표: 처음에 비해 80 * (i+1) 만큼 이동. 처음으로부터 3번째 점이라면 50 + 80 * (2+1) = 50 + 240 = 310
                int nextY = baseY - (int) calculatePercent(i+1, dataSize, firstPrice) * 5;  // y좌표: 처음에 비해 오른 퍼센트의 5배 만큼 이동. 밑으로 갈수록 y좌표는 커지니 부호를 반대로 해줌

                // 지금에 비해 가격이 올랐으면 빨간색, 내렸으면 파란색으로 계산
                g.setColor(calculatePercent(i + 1, dataSize, price) >= 0 ? Color.RED : Color.BLUE); // 상승일 때 빨간색, 하락일 때 파란색
                // 현재 선택된 점과 그 다음 점을 잇는다.
                g.drawLine(x, y, nextX, nextY);
            }
        }

        // 패널의 구분선을 그림
        g.setColor(Color.BLACK);
        g.drawLine(0, getHeight()-2, 999999, getHeight());
    }

    // 현재 주가와 다른 주가와의 가격을 퍼센트로 반환
    private double calculatePercent(int index, int dataSize, int price) {
        if (price == 0)
            return 0;
        if (index == 0)
            return 0;

        int currentPrice = (int) stock.getPriceLog().get(stock.getPriceLog().size() - dataSize + index);

        return (currentPrice - price) * 100d / price;
    }

}
