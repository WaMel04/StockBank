import bank.BankAccount;
import bank.gui.frame.BankAccountGUI;
import news.EntireNewsRegister;
import news.NewsScheduler;
import stock.StockRegister;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        StockRegister.init();
        EntireNewsRegister.init();

        NewsScheduler scheduler = new NewsScheduler();
        scheduler.start();

        BankAccountGUI.adminAccount = BankAccount.createAdminAccount();
        BankAccountGUI.userAccount = new BankAccount(getAccountName(), 1000000);

        SwingUtilities.invokeLater(() -> {
            BankAccountGUI bankAccountGUI = new BankAccountGUI();
        });
    }

    public static String getAccountName() {
        JOptionPane.showMessageDialog(null, "환영합니다!\n한양은행을 이용하시려면, 먼저 계좌를 개설해주세요.", "한양은행 시작하기", JOptionPane.INFORMATION_MESSAGE);

        String accountName;

        do {
            accountName = JOptionPane.showInputDialog("계좌명을 입력해주세요: (최대 10자)");

            if (accountName == null)
                System.exit(0);
            if (accountName.length() > 10)
                JOptionPane.showMessageDialog(null, "계좌명은 최대 10자까지 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
            if (accountName.equalsIgnoreCase("admin")) {
                JOptionPane.showMessageDialog(null, "해당 이름은 사용할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                accountName = "";
            }
        } while (accountName.isEmpty() || accountName.length() > 10);

        return accountName;
    }

}