package com.coco.service;

import com.coco.pojo.TbUser;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public interface UserService {
    TbUser selectLoginUser(String username, String password);
}
