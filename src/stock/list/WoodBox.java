package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class WoodBox extends Stock {

    public WoodBox() {
        super("우드박스", "유튜브 크리에이터를 매니지먼트하는 MCN", 50000, StockField.FOOD);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("띠또", "이 유튜버도 '우드박스' 소속? 역시 우드박스가 대세네~",
                "최근 유행하는 유튜버 A와 B, MZ 세대 사이에서 엄청난 인기를 끌고 있는데요!\n이 유튜버들... 모두 우드박스 소속이였다는 거 아시나요?\n" +
                        "유명 유튜버가 세운 '우드박스'는 1인 유튜버들을 전문적으로 관리해주고, 양질의 컨텐츠를 제공한다는데요?\n" +
                        "최근에는 '우드 서베이'의 설문조사에서 유튜버들이 들어가고 싶은 MCN 1위로 뽑혔다고 하네요!\n\n* 이 기사는 우드박스로부터 소정의 원고료를 받고 작성된 기사입니다.",
                true, this));
        News.register(new SpecificNews("띠또", "우드박스 대표, 때 아닌 '뒷광고' 논란",
                "유명 유튜브 크레이에터 MCN 기업인 우드박스의 대표가 소속 유튜버들의 '뒷광고'를  옹호했다는 논란이 일고 있습니다.",
                false, this));
    }
}
