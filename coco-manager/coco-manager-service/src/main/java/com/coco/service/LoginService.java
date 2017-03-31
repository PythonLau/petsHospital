package com.coco.service;

import com.coco.pojo.TbLogin;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public interface LoginService {
    TbLogin getUser(String username, String password);
}
