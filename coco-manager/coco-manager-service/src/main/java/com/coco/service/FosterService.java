package com.coco.service;

import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbFoster;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public interface FosterService {
    TaotaoResult addFoster(String id, String address, String telePhone);
}
