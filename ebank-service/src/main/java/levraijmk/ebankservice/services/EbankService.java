package levraijmk.ebankservice.services;

import levraijmk.ebankservice.entities.BankAccount;
import levraijmk.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EbankService {

    private BankAccountRepository bankAccountRepository;

    public EbankService(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }


    public List<BankAccount> getAllBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccount(String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
}
