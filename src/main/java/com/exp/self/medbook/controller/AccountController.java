package com.exp.self.medbook.controller;

import com.exp.self.medbook.dto.AccountDTO;
import com.exp.self.medbook.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/get")
    public ResponseEntity<AccountDTO> getAccount(@RequestParam Long id){
        AccountDTO accountDTO = accountService.getAccountDTOById(id);
        return ResponseEntity.ok(accountDTO);
    }
}
