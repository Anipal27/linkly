package com.MyOrg.Linkly.repository;

import com.MyOrg.Linkly.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
