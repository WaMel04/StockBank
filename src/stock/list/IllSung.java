package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class IllSung extends Stock {

    public IllSung() {
        super("일성전자", "전자기기를 제조하는 시장 점유율 1위 기업", 70000, StockField.ELECTRONIC_DEVICE, StockField.SEMICONDUCTOR);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("이용재", "林 대통령, 일성은 한국의 미래",
                "林 대통령은 일산 대통령실에서 일성전자는 한국의 미래라고 말했습니다.",
                true, this));
        News.register(new SpecificNews("이용재", "선풍적인 인기를 끄는 오로트 21",
                "일성전자의 오로트 21이 중국에서 선풍적인 인기를 끌고있습니다.",
                true, this));
        News.register(new SpecificNews("이용재", "일성전자, 스탠더드 에너지의 뒤를 따라가나",
                "일성전자가 스마트폰 분야에서 무려 72%의 점유율을 보이고 있습니다.\n정부는 일성 그룹의 문어발식 확장을 언급하며\n반독점법의 적용 여부를 검토하고 있다고 합니다.",
                false, this));
        News.register(new SpecificNews("이용재", "중국의 희토류 규제, 일성전자 사업부와의 인터뷰",
                "본지가 일성전자 사업부와 진행한 인터뷰의 요약은 아래와 같습니다.\n'중국의 희토류 규제로 스마트폰 제작에 차질이 생기고 있다.'\n'주가 하락을 피할 수 없을 것 같다.'",
                false, this));
    }

}
