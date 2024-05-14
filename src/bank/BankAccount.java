package bank;

import stock.Stock;
import util.FluxibleList;

public class BankAccount {

    public static BankAccount createAdminAccount() {
        return new BankAccount("admin", 99999999);
    }

    private String name;
    private int balance;
    private FluxibleList stockStorageList = new FluxibleList(100);

    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public FluxibleList getStockStorageList() {
        return stockStorageList;
    }

    // 주식 추가
    public void addStock(Stock stock, int amount) {
        for (int i=0; i<stockStorageList.size(); i++) {
            StockStorage stockStorage = (StockStorage) stockStorageList.get(i);

            if (stockStorage.getStock().getName().equals(stock.getName())) {
                stockStorage.addAmount(amount);
                stockStorageList.set(i, stockStorage);
                return;
            }
        }

        stockStorageList.add(new StockStorage(stock, amount));
    }

    // 주식 제거
    public boolean removeStock(Stock stock, int amount) {
        for (int i=0; i<stockStorageList.size(); i++) {
            StockStorage stockStorage = (StockStorage) stockStorageList.get(i);

            if (stockStorage.getStock().getName().equals(stock.getName())) {
                boolean b = stockStorage.removeAmount(amount);

                if (b == false)
                    return false;
                if (stockStorage.getAmount() <= 0)
                    stockStorageList.remove(i);
                else
                    stockStorageList.set(i, stockStorage);

                return true;
            }
        }

        return false;
    }

    // 해당 주식의 보유량
    public int getStockAmount(Stock stock) {
        for (int i=0; i<stockStorageList.size(); i++) {
            StockStorage stockStorage = (StockStorage) stockStorageList.get(i);

            if (stockStorage.getStock().getName().equals(stock.getName())) {
                return stockStorage.getAmount();
            }
        }

        return 0;
    }

    // 계좌의 금액을 "xxxx억 xxxx만 xxxx원"으로 반환
    public String getKoreanBalance() {
        int won = getBalance();
        StringBuilder result = new StringBuilder();

        int eok = won / 100000000;
        if (eok > 0) {
            result.append(eok).append("억 ");
            won %= 100000000;
        }

        int man = won / 10000;
        if (man > 0) {
            result.append(man).append("만 ");
            won %= 10000;
        }

        if ((eok > 0 || man > 0) && won <= 0) {
            result.deleteCharAt(result.length()-1).append("원");
        } else {
            result.append(won).append("원");
        }

        return result.toString();
    }

    // 입금
    public BankMessage deposit(int amount) {
        if (amount <= 0)
            return BankMessage.AMOUNT_IS_ILLEGAL;

        balance += amount;
        return BankMessage.DEPOSIT_SUCCESS;
    }

    // 출금
    public BankMessage withdraw(int amount) {
        if (amount <= 0)
            return BankMessage.AMOUNT_IS_ILLEGAL;
        if (amount > balance)
            return BankMessage.NO_ENOUGH_BALANCE;

        balance -= amount;
        return BankMessage.WITHDRAW_SUCCESS;
    }

    // 이체
    public BankMessage transfer(BankAccount opponentAccount, int amount) {
        BankMessage withdrawMessage = withdraw(amount);

        if (withdrawMessage.isError()) {
            return withdrawMessage;
        } else {
            opponentAccount.deposit(amount);

            return BankMessage.TRANSFER_SUCCESS;
        }
    }

}
