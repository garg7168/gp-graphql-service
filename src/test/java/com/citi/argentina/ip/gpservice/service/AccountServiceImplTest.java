package com.citi.argentina.ip.gpservice.service;

import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.repository.AccountRepository;
import com.citi.argentina.ip.gpservice.util.AutoGenerate;
import com.citi.argentina.ip.gpservice.util.MergeObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//import org.mockito.junit.MockitoJUnitRunner;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(MergeObject.class)
public class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    AccountServiceImpl impl;
    @Mock
    AutoGenerate autoGenerate;

    @BeforeEach
    public void init() {
    }

   @Test
    public void testCreateAccount() {
       MockitoAnnotations.initMocks(this);
        Account account = new Account();
        String id = "ICICI002";
        Mockito.when(autoGenerate.autoGenerateAccountId()).thenReturn(id);
        account.setAcctId(id);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<Account> accountSaved=impl.saveDetails(account);
        assertThat(accountList).isEqualTo(accountSaved);
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account();
        Mockito.when(accountRepository.findByAcctId(Mockito.anyString())).thenReturn(Optional.of(account));
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<Account> accountDeleted = impl.deleteDetails("TEST112");
        assertThat(accountList).isEqualTo(accountDeleted);
    }

    @Test
    public void testFindByAcctId() {
        //MockitoAnnotations.initMocks(this);
        Account account = new Account();
        Mockito.when(accountRepository.findByAcctId(Mockito.anyString())).thenReturn(Optional.of(account));
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<Account> accountData=impl.findByAcctId("Test112");
        assertThat(accountList).isEqualTo(accountData);
    }

    @Test
    public void testFindAll() {
        Account account = new Account();
        Account account1 = new Account();
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        accountList.add(account1);
        Page<Account> pageList = new PageImpl<>(accountList);
        Mockito.when(accountRepository.findAll((Pageable) Mockito.any())).thenReturn(pageList);
        Page<Account> accountData=impl.findAll(0,2);
        assertThat(pageList).isEqualTo(accountData);
    }

}

