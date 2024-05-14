package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class Next extends Stock {

    public Next() {
        super("넥스트", "온라인 게임을 개발하는 IT 기업", 30000, StockField.IT, StockField.GAME);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("강기원", "넥스트 신작, 선풍적인 인기를 끌어",
                "넥스트가 이달 출시한 게임이 전세계적으로 선풍적인 인기를 끌고 있습니다.\n도트 그래픽, 간단하면서도 중독성 있는 게임성이 인기있는 잠수 게임이라고 합니다.",
                true, this));
        News.register(new SpecificNews("금창섭", "넥스트, 최근 논란에 사과문 올려",
                "넥스트의 일부 게임에서 확률이 표기된 것과 다르다는\n일명 '확률 조작' 파동이 일며\n이사진들이 사과문을 올리며 환불 조치를 하였습니다.",
                false, this));
    }

}
