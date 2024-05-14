package news;

import stock.Stock;

// 특정 주식에만 적용되는 뉴스
public class SpecificNews extends News {

    private Stock stock;

    public SpecificNews(String writer, String title, String context, boolean isFavorable, Stock stock) {
        super(writer, title, context, isFavorable);
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public void apply() {
        if (stock.isDelisted())
            return;
        if (isFavorable()) { // 호재일 경우
            stock.increasePrice((Math.random() * 2.5) + 0.5); // 가격을 0.5 ~ 3.0 퍼센트 증가 시킴.
        } else { // 악재일 경우
            stock.decreasePrice((Math.random() * 2.5) + 0.3); // 가격을 0.3 ~ 3.0 퍼센트 증가 시킴.
        }
    }
}
