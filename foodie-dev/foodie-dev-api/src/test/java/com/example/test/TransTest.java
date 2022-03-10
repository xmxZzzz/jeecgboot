package com.example.test;

import com.example.Application;
import com.example.service.TransService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

// JUnit4
//@RunWith(SpringRunner.class)
// JUnit5
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private TransService transService;


    @Test
    public void testPropagationTrans(){
        transService.testPropagationTrans();
    }
}
