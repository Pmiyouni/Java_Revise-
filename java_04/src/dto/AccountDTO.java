package dto;

public class AccountDTO {
    private Long id;
    private String accountNumber; //계좌번호
    private int deposit =0; //입금액
    private int  withdraw =0; //출금액

    private String bankingAt;


   // private static long num = 1L;

    public AccountDTO() {
    }

//    public AccountDTO(Long id, String accountNumber, long deposit, long withdraw, long balance) {
//        this.id = num++;
//        this.accountNumber = accountNumber;
//        this.deposit = deposit;
//        this.withdraw = withdraw;
//        this.balance = balance;
//    }

    public int getBalance() {
           return deposit - withdraw;
      }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }
}


