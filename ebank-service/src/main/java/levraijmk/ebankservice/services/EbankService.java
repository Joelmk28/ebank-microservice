package levraijmk.ebankservice.services;

import levraijmk.ebankservice.entities.BankAccount;
import levraijmk.ebankservice.feign.CustomerRestClient;
import levraijmk.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EbankService {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient){
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }


    public List<BankAccount> getAllBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccount(String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
          bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
}
