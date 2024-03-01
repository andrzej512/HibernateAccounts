package com.example.hibernatestart;

import com.example.hibernatestart.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
     List<BankAccount> findAllByCurrency(String currency);
     List<BankAccount> findAllByBalanceGreaterThan(BigDecimal number);
     List<BankAccount> findAllByBalanceBetween(BigDecimal balance1,BigDecimal balance2 );
     List<BankAccount> findAllByTypeAndBalanceLessThanEqual(String type ,BigDecimal balance);
     List<BankAccount> findAllByCurrencyInAndBalanceGreaterThan(List<String> currencies ,BigDecimal balance);
}
