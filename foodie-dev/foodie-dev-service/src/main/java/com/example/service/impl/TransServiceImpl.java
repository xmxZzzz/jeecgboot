package com.example.service.impl;

import com.example.service.StuService;
import com.example.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransServiceImpl implements TransService {

    @Autowired
    private StuService stuService;

    /**
     * 传播行为
     * REQUIRED：使用当前的事务。如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的。如果当前存在事务，则加入这个事务，成为一个整体。
     * SUPPORTS：如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     * MANDATORY：该传播属性强制要求父方法必须存在一个事务，如果不存在，则抛出异常。
     * REQUIRES_NEW：如果当前有事务，则挂起该事务，并且自己创建一个新的事务给自己使用；如果当前没有事务，则同REQUIRED。
     * NOT_SUPPORTED：如果当前有事务，则把事务挂起，自己不使用事务去运行数据库操作。
     * NEVER：如果当前有事务存在时，则抛出异常。
     * NESTED：如果当前有事务，则开启子事务（嵌套事务）。嵌套事务是独立提交或者回滚；如果当前没有事务，则同REQUIRED。但是如果主事务提交，则会携带子事务一起提交。
     * 如果主事务回滚，则子事务会一起回滚。相反，子事务异常，则父事务可以回滚也可以不回滚。
     */

    //@Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChild();

        int a = 1 / 0;
    }
}
