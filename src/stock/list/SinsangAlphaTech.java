package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class SinsangAlphaTech extends Stock {

    public SinsangAlphaTech() {
        super("신상알파테크", "상온 상압 초전도체 개발을 주장하는 학자들과 연관있는 기업", 5000, StockField.SUPERCONDUCTOR);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("이재훈", "민영배 박사, K-99는 23일 학술회에서 발표하겠다",
                "민영배 박사는 본지와의 인터뷰에서\n상온 상압 초전도체인 K-99를 23일 안암의 학술회에서 발표하겠다고 밝혔습니다.\n이에 전국민의 관심이 쏠리고 있습니다.",
                true, this));
        News.register(new SpecificNews("김형배", "대한초전도연구회, K-99는 순전히 가짜",
                "대한초전도연구회는 K-99에 관한 논문의 실험 결과가\n조작되어 있음을 밝히고, 이는 전형적인 스캠이라고 주장했습니다.\n익명을 요구한 관계자는 본지와의 인터뷰에서\n'K-99는 시도때도 없이 나오는 무한동력장치와도 같다.'\n'그들도 자기들이 K-99를 만든 방법을 모른다. 이는 순전히 사기다.'\n등의 강도 높은 발언을 이어갔습니다.",
                false, this));
    }

}
