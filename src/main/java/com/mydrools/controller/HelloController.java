package com.mydrools.controller;

/*
 * @author Steve Shen
 * @version 1.0.0
 * @date 2020/8/21 17:38
 */

import com.mydrools.entity.CreditCardApplyInfo;
import com.mydrools.service.RuleService;
import com.mydrools.entity.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private RuleService ruleService;
    @RequestMapping("/rule")
    public String rule(){
        ruleService.rule();
        return "OK";
    }

    @RequestMapping("/mytest")
    public String mytest(){
        ruleService.rule();
        return "OK";
    }

    @RequestMapping("/calculate")
    public Calculation calculate(double wage){
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        calculation = ruleService.calculate(calculation);
        System.out.println(calculation);
        return calculation;
    }

    @RequestMapping("/creditCardApply")
    public CreditCardApplyInfo creditCardApply(@RequestBody CreditCardApplyInfo creditCardApplyInfo){
        creditCardApplyInfo = ruleService.creditCardApply(creditCardApplyInfo);
        return creditCardApplyInfo;
    }
}

