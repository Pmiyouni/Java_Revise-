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
    List<AccountDTO> outlist = new ArrayList<>();
    List<AccountDTO> inlist = new ArrayList<>();

    ClientDTO clientDTO = new ClientDTO();


    public boolean checkAccount(String account) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (account.equals(clientDTO.getAccountNumber())) {
                return false;
            }
        }
        return true;
    }


    public boolean accountInsert(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }


    public ClientDTO findByAccount(String account) {
        for (ClientDTO clientDTO1 : clientDTOList) {
            if (account.equals(clientDTO1.getAccountNumber())) {
                return clientDTO1;
            }
        }
        return null;
    }


    public void depositAccount(long cnt, String inAccount, long inMoney, String bankingAt) {


        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(cnt);
        accountDTO.setAccountNumber(inAccount);
        accountDTO.setDeposit(inMoney);
        accountDTO.setBankingAt(bankingAt);
        inlist.add(accountDTO);


    }


    public void withdrawAccount(long cnt, String outAccount, long outMoney, String bankingAt) {


        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(cnt);
        accountDTO.setAccountNumber(outAccount);
        accountDTO.setWithdraw(outMoney);
        accountDTO.setBankingAt(bankingAt);
        outlist.add(accountDTO);



    }


    public AccountDTO findBalance(String account) {

        for (AccountDTO accountDTO : accountDTOList) {
            if (account.equals(accountDTO.getAccountNumber()))
                return accountDTO;
        }
        return null;

    }

    public List<AccountDTO> bankingList() {
        List<AccountDTO> banklist = new ArrayList<>();
        for(AccountDTO accountDTO: inlist) {
            banklist.add(accountDTO);

        }
        for(AccountDTO accountDTO: outlist) {
            banklist.add(accountDTO);
        }
        return banklist;
    }

    public List<AccountDTO> inBankingList(String account) {
        List<AccountDTO> accountDTOList1 = new ArrayList<>();
        for (AccountDTO accountDTO : inlist) {
            if (account.equals(accountDTO.getAccountNumber())) {
                accountDTOList1.add(accountDTO);
                return accountDTOList1;
            }
        }
        return null;
    }

        public List<AccountDTO> outBankingList(String account){
            List<AccountDTO> accountDTOList2 = new ArrayList<>();
            for (AccountDTO accountDTO : outlist) {
                if (account.equals(accountDTO.getAccountNumber())) {
                    accountDTOList2.add(accountDTO);
                    return accountDTOList2;
                }
            }
            return null;
        }

    }










