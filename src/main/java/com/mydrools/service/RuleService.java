package com.mydrools.service;

/*
 * @author Steve Shen
 * @version 1.0.0
 * @date 2020/8/21 17:38
 */

import com.mydrools.entity.Calculation;
import com.mydrools.entity.CreditCardApplyInfo;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {
    @Autowired
    private KieBase kieBase;

    public void rule() {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    //调用Drools规则引擎实现个人所得税计算
    public Calculation calculate(Calculation calculation){
        KieSession session = kieBase.newKieSession();
        session.insert(calculation);
        session.fireAllRules();
        session.dispose();
        return calculation;
    }

    //调用Drools规则引擎实现信用卡申请
    public CreditCardApplyInfo creditCardApply(CreditCardApplyInfo creditCardApplyInfo){
        KieSession session = kieBase.newKieSession();
        session.insert(creditCardApplyInfo);
        session.fireAllRules();
        session.dispose();
        return creditCardApplyInfo;
    }
}
