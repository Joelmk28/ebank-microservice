package levraijmk.ebankservice.controllers;

import levraijmk.ebankservice.entities.BankAccount;
import levraijmk.ebankservice.services.EbankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EbankAccountController {

    private EbankService ebankService;


    public EbankAccountController(EbankService ebankService){
        this.ebankService = ebankService;
    }


    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts(){
        return ebankService.getAllBankAccounts();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
        return ebankService.getBankAccount(id);
    }

    @PostMapping("/accounts")
    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount){
        return ebankService.saveBankAccount(bankAccount);
    }


}
