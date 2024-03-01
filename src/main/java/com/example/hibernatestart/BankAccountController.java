package com.example.hibernatestart;

import com.example.hibernatestart.entity.BankAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/v1/accounts/all")
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/v1/accounts")
    public List<BankAccount> getBankAccountsByCurrency(@RequestParam(value = "currency", required = false) String currency) {
        return bankAccountService.getBankAccountsByCurrency(currency);
    }

    @GetMapping("/v1/accounts/balance/above/{balance}")
    public List<BankAccount> getBankAccountsWithBalanceGreatherThan(@PathVariable("balance") BigDecimal balance) {
        return bankAccountService.getBankAccountsWithBalanceGreaterThan(balance);
    }

    @GetMapping("/v1/accounts/balance/between/{balance1}/{balance2}")
    public List<BankAccount> getBankAccountsWithBalanceBetween(@PathVariable("balance1") BigDecimal balance1,
                                                               @PathVariable("balance2") BigDecimal balance2) {
        return bankAccountService.getBankAccountsWithBalanceBetween(balance1, balance2);
    }

    @GetMapping("/v1/accounts/ex3")
    public List<BankAccount> getBankAccountsByTypeAndBalanceLessThanOrEqual(@RequestParam(value = "type", required = false) String type,
                                                                            @RequestParam(value = "balance", required = false) BigDecimal balance) {
        return bankAccountService.getBankAccountsByTypeAndBalanceLessThanOrEqual(type, balance);
    }

    @GetMapping("/v1/accounts/ex4")
    public List<BankAccount> getBankAccountsByCurrencyInAndBalanceLessThan(@RequestParam(value = "currency", required = false) List<String> currencies,
                                                                           @RequestParam(value = "balance", required = false) BigDecimal balance) {
        return bankAccountService.getBankAccountsByCurrencyInAndBalanceGreaterThan(currencies, balance);
    }

}
