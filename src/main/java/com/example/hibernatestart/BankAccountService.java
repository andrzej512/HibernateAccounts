package com.example.hibernatestart;

import com.example.hibernatestart.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository        bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }
    public List<BankAccount> getBankAccountsByCurrency(String currency){
        return bankAccountRepository.findAllByCurrency(currency);
    };

    public List<BankAccount> getBankAccountsWithBalanceGreaterThan(BigDecimal amount){
        return bankAccountRepository.findAllByBalanceGreaterThan(amount);
    };

    public List<BankAccount> getBankAccountsWithBalanceBetween(BigDecimal balance1, BigDecimal balance2){
        return bankAccountRepository.findAllByBalanceBetween(balance1,balance2);
    };

    public List<BankAccount> getBankAccountsByTypeAndBalanceLessThanOrEqual(String type, BigDecimal balance){
        return bankAccountRepository.findAllByTypeAndBalanceLessThanEqual(type,balance);
    };
    public List<BankAccount> getBankAccountsByCurrencyInAndBalanceGreaterThan(List<String> currencies, BigDecimal balance){
        return bankAccountRepository.findAllByCurrencyInAndBalanceGreaterThan( currencies,balance);
    };

}
