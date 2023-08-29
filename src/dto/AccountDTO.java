package dto;

public class AccountDTO {
    private Long id;
    private String accountNumber; //계좌번호
    private long deposit =0L; //입금액
    private long withdraw =0L; //출금액

    private String bankingAt;


    private static long num = 1L;

    public AccountDTO() {
    }

//    public AccountDTO(Long id, String accountNumber, long deposit, long withdraw, long balance) {
//        this.id = num++;
//        this.accountNumber = accountNumber;
//        this.deposit = deposit;
//        this.withdraw = withdraw;
//        this.balance = balance;
//    }

//    public long getBalance() {
//           return deposit - withdraw;
//      }

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

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
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
    public String print1() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }
    public String print2() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }


}


