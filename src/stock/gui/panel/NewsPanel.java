package stock.gui.panel;

import news.News;

import javax.swing.*;
import java.awt.*;

// 현재 뉴스를 보여주는 Panel
public class NewsPanel extends JPanel {

    private News news;
    private JLabel titleLabel;
    private JTextArea contextTextArea;

    public NewsPanel(News news) {
        this.news = news;

        setPreferredSize(new Dimension(500, 50));
        setLayout(new BorderLayout());

        titleLabel = new JLabel(news.getWriter() + " - " + news.getTitle());
        titleLabel.setVerticalAlignment(SwingConstants.TOP);

        add(titleLabel, BorderLayout.CENTER);

        // "전문 확인" 버튼 추가
        JButton viewDetailButton = new JButton("전문 확인");
        viewDetailButton.addActionListener(e -> showFullNews());

        // 버튼을 패널의 오른쪽에 추가
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(viewDetailButton);
        add(buttonPanel, BorderLayout.EAST);

        contextTextArea = new JTextArea(news.getContext());
        contextTextArea.setEditable(false);
        contextTextArea.setLineWrap(true);
        contextTextArea.setWrapStyleWord(true);
    }

    private void showFullNews() {
        JScrollPane scrollPane = new JScrollPane(contextTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scrollPane, news.getWriter() + " - " + news.getTitle(), JOptionPane.PLAIN_MESSAGE);
    }

}
