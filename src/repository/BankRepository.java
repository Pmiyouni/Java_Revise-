package repository;

import dto.AccountDTO;
import dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.Callable;

public class BankRepository {
    List<ClientDTO> clientDTOList = new ArrayList<>();
    List<AccountDTO> accountDTOList = new ArrayList<>();
    ClientDTO clientDTO = new ClientDTO();
    
    // 계좌번호 체크
    public boolean checkAccount(String account) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (account.equals(clientDTO.getAccountNumber())) {
                return false;
            }
        }
        return true;
    }

    // 계좌등록
    public boolean accountInsert(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    //계좌 조회
    public ClientDTO findByAccount(String account) {
        for (ClientDTO clientDTO1 : clientDTOList) {
            if (account.equals(clientDTO1.getAccountNumber())) {
                return clientDTO1;
            }
        }
        return null;
    }

    //입금
    public void depositAccount(long cnt, String inAccount, int inMoney, String bankingAt) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(cnt);
        accountDTO.setAccountNumber(inAccount);
        accountDTO.setDeposit(inMoney);
        accountDTO.setBankingAt(bankingAt);
        accountDTOList.add(accountDTO);
    }

    //출금
    public void withdrawAccount(long cnt, String outAccount, int outMoney, String bankingAt) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(cnt);
        accountDTO.setAccountNumber(outAccount);
        accountDTO.setWithdraw(outMoney);
        accountDTO.setBankingAt(bankingAt);
        accountDTOList.add(accountDTO);
    }

    
//    public AccountDTO findBalance(String account) {
//        for (AccountDTO accountDTO : accountDTOList) {
//            if (account.equals(accountDTO.getAccountNumber())){
//                return accountDTO;
//             }
//         }
//        return null;
//    }

    // 전체내역
    public List<AccountDTO> bankingList(String account) {
        List<AccountDTO> allList = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
           if (account.equals(accountDTO.getAccountNumber())) {
               allList.add(accountDTO);
            }
        }
        return allList;
    }


    //입금 내역
    public List<AccountDTO> inBankingList(String account) {
        List<AccountDTO> inList = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (account.equals(accountDTO.getAccountNumber()) && accountDTO.getWithdraw() == 0) {
                inList.add(accountDTO);
            }
        }
        return inList;
    }

        //출금내역
        public List<AccountDTO> outBankingList(String account){
            List<AccountDTO> outList = new ArrayList<>();
             for (AccountDTO accountDTO : accountDTOList) {
                if (account.equals(accountDTO.getAccountNumber()) && accountDTO.getDeposit() == 0) {
                    outList.add(accountDTO);
                  }
            }
            return outList;
        }

    }