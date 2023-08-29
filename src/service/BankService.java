package service;

import dto.AccountDTO;
import dto.ClientDTO;
import repository.BankRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//계좌등록
public class BankService {
    Scanner scanner = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();
    private static int cnt = 0;

    public void accountInsert() {
        boolean checkResult = false;
        boolean checkA = true;

        System.out.print("고객이름: ");
        String name = scanner.next();
        String account = null;

        while (checkA) {
            System.out.print("계좌번호:  ");
            account = scanner.next();
            checkResult = bankRepository.checkAccount(account);
            if (checkResult) {
                System.out.println("사용 가능한 계좌번호 입니다.");
                checkA = false;
            } else {
                System.out.println("이미 사용 중인 계좌번호 입니다.");
            }
        }
        System.out.print("계좌비밀번호: ");
        String password = scanner.next();
        LocalDateTime now = LocalDateTime.now();
        String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        ClientDTO clientDTO = new ClientDTO(name, account, password, createdAt);
        boolean result = bankRepository.accountInsert(clientDTO);
        if (result) {
            System.out.println("계좌등록 성공");
        } else {
            System.out.println("계좌등록 실패");
        }
    }


    //잔액 조회
    public void findByAccount() {
        System.out.println("===== 잔액 조회 화면 =====");
        System.out.print("조회할 계좌번호 입력: ");
        String account = scanner.next();
        boolean checkResult = bankRepository.checkAccount(account);
        if (!checkResult) {
            ClientDTO clientDTO = bankRepository.findByAccount(account);
            if (clientDTO != null) {
                System.out.println("계좌번호 : " + clientDTO.getAccountNumber());
                System.out.println("잔액 : " + clientDTO.getBalance());
            } else {
                System.out.println("해당 정보가 없습니다");
            }
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    //입금
    public void depositAccount() {
        AccountDTO accountDTO = new AccountDTO();

        System.out.print("계좌번호 입력 : ");
        String inAccount = scanner.next();
        boolean checkResult = bankRepository.checkAccount(inAccount);
        if (!checkResult) {
            System.out.print("입금금액 입력  >");
            int inMoney = scanner.nextInt();
            cnt = cnt + 1;
            LocalDateTime now = LocalDateTime.now();
            String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bankRepository.depositAccount(cnt, inAccount, inMoney, createdAt);
            System.out.println("입금 완료");
            ClientDTO clientDTO2 = bankRepository.findByAccount(inAccount);
            clientDTO2.setBalance(clientDTO2.getBalance() + inMoney);
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    //출금
    public void withdrawAccount() {
        AccountDTO accountDTO = new AccountDTO();
        System.out.print("계좌번호 입력 : ");
        String outAccount = scanner.next();
        boolean checkResult = bankRepository.checkAccount(outAccount);
        if (!checkResult) {
            System.out.print("출금금액 입력  >");
            int outMoney = scanner.nextInt();
            ClientDTO clientDTO3 = bankRepository.findByAccount(outAccount);

            if (clientDTO3.getBalance() >= outMoney) {
                cnt = cnt + 1;
                LocalDateTime now = LocalDateTime.now();
                String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                bankRepository.withdrawAccount(cnt, outAccount, outMoney, createdAt);
                System.out.println("출금 완료");
                clientDTO3.setBalance(clientDTO3.getBalance() - outMoney);
            } else {
                System.out.println("잔액부족입니다");
            }
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }
    
    //입출금 내역조회
    public void findAll() {
        AccountDTO accountDTO = new AccountDTO();
        System.out.print("계좌번호 입력 : ");
        String account = scanner.next();
        boolean checkResult = bankRepository.checkAccount(account);
        if (!checkResult) {
            submenu(account);
        } else {
            System.out.println("없는 계좌번호 입니다.");
        }
    }

    //입출금 내역조회 메뉴 및 실행
    public void submenu(String account) {
        boolean run = true;

        while (run) {
            System.out.println("\n====== 입출금 내역 조회 ======");
            System.out.println("1. 전체 내역 2. 입금 내역 3. 출금 내역 4.종료");
            System.out.print("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                int balance=0;
                System.out.println("전체내역 메뉴");
                List<AccountDTO> bankingList = bankRepository.bankingList(account);
                for (AccountDTO accountDTO : bankingList) {
                    System.out.println(" 전체 입출금 내역");
                    System.out.println("-------------------------------------------------------");
                    System.out.println("id=" + accountDTO.getId()+"\t"+
                            " 계좌번호 : " + accountDTO.getAccountNumber() + "\t" +
                            " 입금액 : " + accountDTO.getDeposit() + "\t"+
                            " 출금액 : " + accountDTO.getWithdraw() + "\t"+
                            " 입출금발생시간: " + accountDTO.getBankingAt() );
                    balance = balance + accountDTO.getBalance();
                }
                System.out.println(" 잔액 : " + balance );
            } else if (sel == 2) {

                boolean checkResult = bankRepository.checkAccount(account);
                if (!checkResult) {
                    System.out.println("입금내역 메뉴");
                    List<AccountDTO> inList = bankRepository.inBankingList(account);
                    if (inList == null) {
                        System.out.println("입금 내역이 없습니다");
                    } else {
                        for (AccountDTO accountDTO : inList) {
                            System.out.println(" 입금내역");
                            System.out.println("---------------------------------------------------");
                            System.out.println("id=" + accountDTO.getId()+"\t"+
                                    " 계좌번호 : " + accountDTO.getAccountNumber() + "\t" +
                                    " 입금액 : " + accountDTO.getDeposit() + "\t"+
                                    " 입금발생시간: " + accountDTO.getBankingAt() );
                    }
                    }

                } else {
                    System.out.println("없는 계좌번호 입니다.");
                }

            } else if (sel == 3) {

                boolean checkResult = bankRepository.checkAccount(account);
                if (!checkResult) {

                    System.out.println("출금내역 메뉴");
                    List<AccountDTO> outList = bankRepository.outBankingList(account);
                    if (outList == null) {
                        System.out.println("출금 내역이 없습니다");
                    } else {
                        for (AccountDTO accountDTO : outList) {
                            System.out.println(" 출금내역");
                            System.out.println("----------------------------------------------");
                            System.out.println("id=" + accountDTO.getId()+"\t"+
                                    " 계좌번호 : " + accountDTO.getAccountNumber() + "\t" +
                                    " 출금액 : " + accountDTO.getWithdraw() + "\t"+
                                    " 출금발생시간: " + accountDTO.getBankingAt() );
                        }
                    }
                } else {
                    System.out.println("없는 계좌번호 입니다.");
                }

                } else if (sel == 4) {
                    System.out.println("메인으로 이동");
                    run = false;
                }
            }

        }
    }



