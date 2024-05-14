package stock;

import util.FluxibleList;

public abstract class Stock {

    public static FluxibleList stocks = new FluxibleList(30);

    String name;
    String description;
    int price;
    StockField[] fields;
    boolean isDelisted = false;

    FluxibleList priceLog = new FluxibleList(100);

    public Stock(String name, String description, int price, StockField... fields) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.fields = fields;

        // 공모가를 priceLog에 추가
        priceLog.add(price);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void increasePrice(double percent) {
        int newPrice = (int) (price * (1 + (percent / 100))); // 소숫점은 버림
        priceLog.add(newPrice);

        this.price = newPrice;
    }

    public void decreasePrice(double percent) {
        int newPrice = (int) (price * (1 - (percent / 100))); // 소숫점은 버림
        priceLog.add(newPrice);

        this.price = newPrice;

        if (newPrice == 0)
            isDelisted = true;
    }

    // 뉴스가 발행되어 주가가 변동될 떄 마다 변동된 주가를 저장한 priceLog를 반환
    public FluxibleList getPriceLog() {
        return priceLog;
    }

    public StockField[] getFields() {
        return fields;
    }

    // 주식의 상장폐지 여부를 반환
    public boolean isDelisted() {
        return isDelisted;
    }

    // 해당 주식에만 영향을 끼치는 SpecificNews를 등록함
    public abstract void registerSpecificNews();

}

