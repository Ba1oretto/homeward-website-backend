package com.homeward.website.aop.pointcuts;


import org.aspectj.lang.annotation.Pointcut;

public class PlayerInformationAdvice {

    @Pointcut(
            value = "execution(" +
                    "@com.homeward.website.aop.annotations.JoinPointSymbol " +
                    "Long " +
                    "com.homeward.website.mapper.PlayerMapper.insertPlayer(..)) && " +
                    "args(uuid, name, createTime)",
            argNames = "uuid, name, createTime"
    )
    public void insertPlayerLog(String uuid, String name, String createTime) {}
}
