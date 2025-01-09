package com.exp.self.medbook.service;

import com.exp.self.medbook.dto.AccountDTO;
import com.exp.self.medbook.entity.Account;
import com.exp.self.medbook.mapper.AccountMapper;
import com.exp.self.medbook.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDTO getAccountDTOById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        System.out.println("Role in Account: " + account.getRole());
        return accountMapper.toAccountDTO(account);
    }
}
