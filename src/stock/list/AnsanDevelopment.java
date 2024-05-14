package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class AnsanDevelopment extends Stock {

    public AnsanDevelopment() {
        super("안산도시공사", "안산시의 민영화된 공공 도시 개발 기업", 120000, StockField.BUILD);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("한전철", "신안산선 사업, 이제 마무리 단계",
                "2025년 완공될 신안산선 사업이 성공적으로 마무리 단계에 돌입했습니다.\n신안산선은 안산과 여의도를 30분만에 주파할 수 있게 해주는\n수도권 서남부의 교통을 담당하는 하나의 축이 될 예정입니다.",
                true, this));
        News.register(new SpecificNews("마태수", "자칭 '안산의 왕', 안산도시공사와는 무슨 관계?",
                "자기 자신을 '안산의 왕'이라고 칭하는 조직폭력배 두목과 안산도시공사 사이의\n모종의 협력관계가 있었다는 의혹이 불거졌습니다.",
                false, this));
        News.register(new SpecificNews("안침착", "안산 출신 유명 스트리머의 소신 발언",
                "안산에서 유년 시절을 보낸 유명 스트리머가 방송 중에 한 말이\n온라인 커뮤니티 사이에서 화제 중입니다.\n그는 '안산의 건물들은 너무 90년대 느낌이다',\n" +
                        "'등굣길이 너무 길고 인적이 드물어 학창 시절 등교 중 돈을 많이 뜯기고 다녔다' 등의 발언을 하였습니다.",
                false, this));
    }
}
