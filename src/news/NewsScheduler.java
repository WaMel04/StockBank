package news;

import stock.Stock;
import stock.list.SinsangAlphaTech;

// 60초마다 뉴스를 뽑고, 60초 후 뉴스에 따른 주가 변동을 진행하는 스케쥴러 (Thread)
public class NewsScheduler extends Thread {

    public static News[] selectedNewsList = null;
    public static final int SELECT_COUNT = 7;
    public static final int REFRESH_TIME = 10;

    private int tick = -1;
    private boolean isSecondRun = false;

    @Override
    public void run() {
        while (true) {
            if (tick == -1 || tick >= REFRESH_TIME) {
                if (isSecondRun == false) {
                    selectedNewsList = getRandomNews(SELECT_COUNT); // 첫번째는 뉴스를 미리 뽑아놓음.
                    isSecondRun = true;
                } else {
                    for (int i=0; i<selectedNewsList.length; i++) {
                        News news = selectedNewsList[i];

                        news.apply(); // 뉴스로 인한 영향을 적용함
                    }
                    isSecondRun = false;
                }

                tick = 0;
            }
            try {
                Thread.sleep(1000);
                tick++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // n개의 랜덤한 뉴스를 반환
    // 같은 주식에 대한 뉴스는 뽑히지 않음.
    private static News[] getRandomNews(int n) {
        int length = News.newsList.size();

        if (n <= 0 || n > length) {
            return new News[0];
        }

        boolean[] selectedObjects = new boolean[length];

        News[] result = new News[n];

        int count = 0;
        while (count < n) {
            int randomIndex = (int) (Math.random() * length);
            boolean continueNextStock = false;

            if (!selectedObjects[randomIndex]) {
                News selectedNews = (News) News.newsList.get(randomIndex);

                if (selectedNews instanceof SpecificNews) {
                    Stock stock = ((SpecificNews) selectedNews).getStock();

                    if (stock.isDelisted())
                        continue;

                    String selectedStockName = stock.getName(); // 선택한 특정 뉴스의 주식명

                    for (News rNews : result) {
                        if (continueNextStock) // 다음 주식으로 넘어가도 된다면
                            continue; // 루프-2를 빠져나옴
                        if (rNews instanceof SpecificNews) {
                            String resultStockName = ((SpecificNews) rNews).getStock().getName(); // 이미 선택된 특정 뉴스의 주식명

                            if (selectedStockName.equals(resultStockName)) { // 이미 선택된 주식을 또 고를 경우
                                continueNextStock = true; // 넣지 않고 다음 주식으로 넘어감
                            }
                        }
                    }
                    if (continueNextStock) // 다음 주식으로 넘어가도 된다면
                        continue; // while문의 조건식으로 바로 이동
                }

                result[count] = (News) News.newsList.get(randomIndex);
                selectedObjects[randomIndex] = true;
                count++;
            }
            // continueNextStock이 true로 바뀌면, 최종적으로 이곳으로 빠져나옴.
        }

        return result;
    }

}
