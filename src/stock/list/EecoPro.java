package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class EecoPro extends Stock {

    public EecoPro() {
        super("이코프로", "2차전지 광풍으로 주가가 폭등한 기업", 300000, StockField.BATTERY);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("현진우", "내가 이코프로를 조금이라도 일찍 알았더라면!",
                "다수의 주식 전문가들이 이코프로의 주가에 대해\n상승할 것이라는 견해를 밝혔습니다.",
                true, this));
        News.register(new SpecificNews("현진우", "2차전지 광풍, 너무 과한건 아닐까? 권형도씨와의 인터뷰",
                "암호화폐계의 권위자 권형도씨는 본지와의 인터뷰에서\n최근 이코프로의 급부상이 투기성이 짙다고 밝혔습니다.\n그는 사람들이 생각하는 2차전지 기술력과 실제 기술력은 유리되어있다고 밝혔습니다.",
                false, this));
    }

}
