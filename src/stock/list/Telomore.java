package stock.list;

import news.News;
import news.SpecificNews;
import stock.Stock;
import stock.StockField;

public class Telomore extends Stock {

    public Telomore() {
        super("텔로모어", "'역노화'를 연구하는 의료 기업", 73000, StockField.MEDICAL, StockField.CHEMISTRY);
    }

    @Override
    public void registerSpecificNews() {
        News.register(new SpecificNews("황이석", "텔로모어, 생쥐 대상 '역노화' 성공 주장",
                "텔로모어는 생쥐를 대상으로한 역노화에 성공했다고 주장했습니다.\n5살된 생쥐에 자사의 약품을 투약하자 생쥐의 혈압, 신체 기능, 기억력 등이\n갓 태어난 생쥐 수준으로 돌아갔다고 합니다.",
                true, this));
        News.register(new SpecificNews("황이석", "'역노화'는 진짜 '역'노화가 아니다.",
                "황이석 박사는 텔로모어의 '역노화' 기술에 대하여\n'신체 기능이 좋아졌다고 노화가 치료된 것은 아니다.'\n'현재 나온 기술은 텔로미어를 되돌리지 못하며, 세포 분열 횟수에 명백한 한계가 있다.'\n" +
                        "'설령 텔로미어를 연장 시켜도, 무한한 세포 분열로 암에 걸릴 확률이 대단히 높아질 것이다'\n등의 강도 높은 비판을 이어갔습니다.",
                false, this));
    }
}
