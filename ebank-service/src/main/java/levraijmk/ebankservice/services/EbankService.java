package levraijmk.ebankservice.services;

import levraijmk.ebankservice.entities.BankAccount;
import levraijmk.ebankservice.entities.Customer;
import levraijmk.ebankservice.feign.CustomerRestClient;
import levraijmk.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        try {
            //verification du compte customer
            customerRestClient.getCustomerById(bankAccount.getCustomerId());
            //bankAccount.setId(UUID.randomUUID().toString());
            return bankAccountRepository.save(bankAccount);
        } catch (Exception exception) {
           throw new RuntimeException(exception.getMessage());
        }


    }
}
