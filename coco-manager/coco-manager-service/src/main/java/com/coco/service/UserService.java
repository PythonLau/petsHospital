package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbUser;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public interface UserService {
    TbUser selectLoginUser(String username, String password);
    boolean checkRegisterName(String userName);
    boolean checkRegisterNickName(String registerNickName);
    TaotaoResult userRegister(String registerUserName, String registerPassWord,
                              String nickName, String telePhone);
    boolean isVIP(BigDecimal userId);
    EUDataGridResult getAccountList(Integer page, Integer rows);
    TaotaoResult updateAccountByManager(TbUser user) throws Exception;
    EUDataGridResult searchAccountList(String search_condition,String search_key,Integer page,Integer rows);
}
