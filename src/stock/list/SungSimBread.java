package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class SungSimBread extends Stock {

    public SungSimBread() {
        super("성심빵집", "전국적인 인지도를 가진 대전시의 토착 제과점", 10000, StockField.FOOD);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("마카", "성공적으로 개최된 대전 빵 축제",
                "대전시는 지난 28일 개최된 빵 축제가 성공적으로 진행되었다고 밝혔습니다.",
                true, this));
        News.register(new SpecificNews("마카", "보건복지부 장관, 비만의 원인은 유명 빵집?",
                "보건복지부 장관이 유명 빵집들의 인기로 탄수화물 섭취량이 높아지면서,\n비만율이 오르고 있다고 대표격으로 성심빵집을 언급했습니다.",
                false, this));
    }
}
