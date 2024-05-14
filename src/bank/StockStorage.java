package bank;

import stock.Stock;

public class StockStorage {

    private Stock stock;
    private int amount;

    public StockStorage(Stock stock, int amount) {
        this.stock = stock;
        this.amount = amount;
    }

    public Stock getStock() {
        return stock;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public boolean removeAmount(int amount) {
        if (this.amount < amount)
            return false;

        this.amount -= amount;
        return true;
    }

}
