package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class MarioBrothers extends Stock {

    public MarioBrothers() {
        super("마리오 브라더스", "부동산을 전문으로 하는 미국의 투자은행", 260000, StockField.ECONOMY);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("문재혁", "美 부동산, 3년간 150% 증가",
                "美 부동산 가격이 멈출 줄 모르고 오르고 있습니다.\n이에 '마리오 브라더스' 은행의 주택 담보 매출 파생 상품이 인기를 끌고 있습니다.\n" +
                        "주택 담보 대출을 30개씩 묶은 상품, 그리고 이를 10개씩 모아놓은 상품이 인기가 많다고 합니다.",
                true, this));
        News.register(new SpecificNews("윤성현", "美 부동산, 거품 터지나",
                "지난 11일 미국의 증권사들은 난립하는 부동산 파생 상품이\n시장 거품을 증가시키고 있다고 주장했습니다.\n특히, '마리오 브라더스' 은행의 주택 담보 파생 상품이\n불량 채권이 대다수인 채권 묶음을 묶고, 이를 또 묶어 판매하는 등\n" +
                        "시장의 건전성을 해치고 있다고 밝혔습니다.",
                false, this));
    }
}
