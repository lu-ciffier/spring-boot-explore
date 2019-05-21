package com.lucifer.dao;


import com.lucifer.dao.domain.Account;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lucifer on 2019/5/12 22:16
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Cacheable(value = "account", key = "#accountId")
    Account getAccountByAccountId(long accountId);
}
