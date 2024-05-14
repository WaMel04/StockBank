package bank;

// 입금, 출금, 송금 시 뜨는 메세지들
public enum BankMessage {

    AMOUNT_IS_ILLEGAL("입력값의 형식은 0보다 큰 자연수입니다.", true),
    DEPOSIT_SUCCESS("입금에 성공했습니다.", false),
    NO_ENOUGH_BALANCE("잔액이 부족합니다.", true),
    WITHDRAW_SUCCESS("출금에 성공했습니다.", false),
    TRANSFER_SUCCESS("송금에 성공했습니다.", false);

    private String reason;
    private boolean isError;

    BankMessage(String reason, boolean isError) {
        this.reason = reason;
        this.isError = isError;
    }

    public String getReason() {
        return reason;
    }

    public boolean isError() {
        return isError;
    }

}
