package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class Nicola extends Stock {

    public Nicola() {
        super("니콜라", "전기 자동차를 제조하는 미국 기업", 450000, StockField.CAR, StockField.ENERGY);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("워렌 베넷", "니콜라 신제품, '사이버 바이크' 출시",
                "지난 8일 니콜라가 출시한 '사이버 바이크'가 온라인 상에서\n큰 화제가 되고 있습니다.\n사이버 바이크는 최초의 전기 바이크이자\n근미래적인 디자인으로 많은 호평을 받고 있습니다.",
                true, this));
        News.register(new SpecificNews("김도지", "니콜라 CEO, 또 사고쳤다",
                "니콜라의 CEO 마스크가 SNS에 또 '도기 코인'을 언급했습니다.\n그의 언급이후 주가가 급락함과 동시에\n'CEO가 발언을 너무 경솔하게 한다.'라는 비판이 니콜라 대주주들 사이에서\n" +
                        "나돌고 있습니다.",
                false, this));
    }
}
