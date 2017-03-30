package com.coco.service;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbManager;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
public interface ManagerService {
   boolean IsManagerExist(String username,String password);
}
