package stock;

import stock.list.*;

// 주식 등록기
public class StockRegister {

    public static void init() {
        Stock.stocks.add(new IllSung());
        Stock.stocks.add(new EecoPro());
        Stock.stocks.add(new SinsangAlphaTech());
        Stock.stocks.add(new SungSimBread());
        Stock.stocks.add(new Next());
        Stock.stocks.add(new Nicola());
        Stock.stocks.add(new AnsanDevelopment());
        Stock.stocks.add(new Telomore());
        Stock.stocks.add(new MarioBrothers());
        Stock.stocks.add(new WoodBox());

        for (int i=0; i<Stock.stocks.size(); i++) {
            Stock stock = (Stock) Stock.stocks.get(i);

            if (stock != null) {
                stock.registerSpecificNews();
            }
        }
    }

}
