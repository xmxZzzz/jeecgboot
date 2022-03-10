package com.example.service.impl;

import com.example.service.StuService;
import com.example.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransServiceImpl implements TransService {

    @Autowired
    private StuService stuService;

    /**
     * 传播行为
     *  REQUIRED：使用当前的事务。如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的。如果当前存在事务，则加入这个事务，成为一个整体。
     *  SUPPORTS：如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     *  MANDATORY：该传播属性强制要求父方法必须存在一个事务，如果不存在，则抛出异常。
     *  REQUIREDS_NEW：
     *  NOT_SUPPORTED
     *  NEVER
     *  NESTED
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChild();
    }
}
