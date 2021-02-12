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
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MergeObject.class)
public class PowerMockitoTests {
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
    public void testUpdateAccount() throws Exception {
        PowerMockito.mockStatic(MergeObject.class);
        Account account = new Account();
        account.setAcctName("Pooja");
        Mockito.when(accountRepository.findByAcctId(Mockito.anyString())).thenReturn(Optional.of(account));
        PowerMockito.when(MergeObject.mergetwoObjects(Mockito.any(Object.class), Mockito.any(Object.class))).thenReturn(account);
        Mockito.when(accountRepository.save(Mockito.any())).thenReturn(account);
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        List<Account> accountUpdated=impl.updateDetails(account);
        assertThat(accountList).isEqualTo(accountUpdated);
    }
}

