package com.coco.service;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.pojo.TbPackage;


/**
 * Created by Administrator on 2017/3/24 0024.
 */
public interface PackageService {
    TaotaoResult createPackage(TbPackage item) throws Exception;
    Page<TbPackage> getTbPackageList(Integer pageNumber);
    EUDataGridResult getAllTbPackageList(int page,int rows);
    TaotaoResult updatePackage(TbPackage tbPackage) throws Exception;

}
