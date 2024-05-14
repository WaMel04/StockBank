package news;

import stock.Stock;
import stock.StockField;

// 특정 분야의 주식에 모두 적용되는 뉴스
public class EntireNews extends News {

    private StockField[] appliedFields;

    public EntireNews(String writer, String title, String context, boolean isFavorable, StockField... appliedFields) {
        super(writer, title, context, isFavorable);
        this.appliedFields = appliedFields;
    }

    public StockField[] getAppliedFields() {
        return appliedFields;
    }

    @Override
    public void apply() {
        for (int i=0; i<Stock.stocks.size(); i++) { // 모든 주식 목록을 loop
            Stock stock = (Stock) Stock.stocks.get(i);

            if (stock.isDelisted())
                continue;

            boolean continueNextStock = false;

            for (int j=0; j<stock.getFields().length; j++) { // 해당 주식의 모든 분야를 loop
                if (continueNextStock) // 다음 주식으로 넘어가도 된다면은
                    continue; // 루프-2를 빠져나옴

                StockField stockField = stock.getFields()[j]; // 주식의 특정 분야를 가져옴.

                for (StockField appliedField : appliedFields) { // 뉴스가 적용되는 모든 분야를 loop
                    if (continueNextStock) // 다음 주식으로 넘어가도 된다면은
                        continue; // 루프-3를 빠져나옴

                    if (stockField.equals(appliedField)) { // 주식의 분야 중 하나가 뉴스 적용 분야에 포함될 경우
                        if (isFavorable()) { // 호재일 경우
                            stock.increasePrice((Math.random() * 2.5) + 0.5); // 가격을 0.5 ~ 3.0 퍼센트 증가 시킴.
                        } else { // 악재일 경우
                            stock.decreasePrice((Math.random() * 2.5) + 0.3); // 가격을 0.3 ~ 3.0 퍼센트 증가 시킴.
                        }

                        continueNextStock = true; // 처리를 완료했으니 다음 주식으로 넘어가도 된다.
                    }
                }
            }
        }

        // continueNextStock이 true로 바뀌면, 최종적으로 이곳으로 빠져나옴.
    }

}
