package news;

import stock.StockField;

// EntireNews 등록기
public class EntireNewsRegister {

    public static void init() {
        News.register(new EntireNews("김세균", "식중독 대유행!",
                "최근 이상 기후로 일교차가 커지면서 식중독 사례가 늘고 있습니다.\n특히, 일부 식품 기업의 생산품에서 노로바이러스가\n검출되었다는 소식에 주가가 요동치고 있습니다.",
                false, StockField.FOOD));
        News.register(new EntireNews("조 트럼펫", "美, 자동차, 에너지에 덤핑 선언",
                "美 재무부가 자국의 핵심 산업인 자동차와 에너지에 덤핑을 하겠다고 선언하였습니다.\n'덤핑'은 국가가 기업에게 보조금을 주어 기업이 더 싸게 물건을\n팔 수 있게 하여 " +
                        "해외 시장에서 경쟁력을 확보하게 하는 수단 중 하나입니다.",
                true, StockField.CAR, StockField.ENERGY));
        News.register(new EntireNews("쯔하", "젊은이들이 열광하는 '먹방'",
                "요즘 젊은이들 사이에서 '먹방'이 유행입니다.\n먹방 애호가들은 먹방 유튜버가 맛있는 음식을 맛있게 먹는 모습이 대리 만족이 된다고 합니다.",
                true, StockField.FOOD, StockField.ENTERTAINMENT));
        News.register(new EntireNews("전도사", "美, 초전도체 연구에 10억 弗 투자",
                "최근 상온 상압 초전도체로 추정되는 'K-99'의 화제와 더불어 미국에서 초전도체 연구에 힘을 쓴다는 호재가 전해졌습니다."
        , true, StockField.SUPERCONDUCTOR));
        News.register(new EntireNews("빅토리", "美 유명 의학 기업 사장인 엘리자, 사기죄로 기소",
                "피 한방울로 수십가지 질병을 파악할 수 있다고 주장한 \n유명 의학 기업의 사장인 '엘리자'씨가 사기죄로 기소당했습니다.\n그녀의 회사는 실제로는 아무런 개발도 진행하지 않았고,\n" +
                        "투자금에 스위스의 개인 명의 계좌에 빼돌렸다는 의혹을 받고 있습니다.", false, StockField.MEDICAL));
        News.register(new EntireNews("전성회", "'메타버스'가 대세가 되고 있다", "메타버스는 가상 공간에서 현실과 같은 제2의 삶을 구현하는 것을 목표로 하는 일종의 게임입니다.\n2021년 이후 대세가 되어가고 있으며, 유명 SNS 기업인 페이크북도 사명을 '메타'로 변경함으로써\n" +
                "SNS를 장기적으로 메타버스로 발전시켜나가겠다는 포부를 보이고 있습니다."
        , true, StockField.IT, StockField.GAME));
        News.register(new EntireNews("박상록", "또 터진 '순살 아파트' 논란", "유명 건설사의 브랜드 아파트에 철근이 누락된 사건 이후로 생긴 신조어가 있습니다.\n바로 '순살 아파트'입니다. 건물을 지탱해주는 철근이 없는게 꼭\n" +
                "뼈가 없는 순살 치킨 같다는 건데요, 다른 건설사에서도 똑같은 논란이 퍼지며\n국민들의 불안감이 커지고 있습니다.\n익명을 요구한 건설 업계 관련자는\n" +
                "'봉쇄 전 단군이래 역대급 부동산 호황으로 건설을 우후죽순 시작한\n" +
                "건설사들이 봉쇄 이후로 자금난에 시달리면서, 철근과 같은 자재들을 빼먹기 시작했다.'\n" +
                "라고 밝혔습니다.",
                false, StockField.BUILD));
    }
}
