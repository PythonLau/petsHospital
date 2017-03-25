package com.coco.service.impl;

import com.coco.common.pojo.Page;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbPackageMapper;
import com.coco.pojo.TbPackage;
import com.coco.pojo.TbPackageExample;
import com.coco.service.PackageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@Service
public class PackageServiceImpl implements PackageService {
    @Autowired
    private TbPackageMapper packageMapper;
    private Short isTrue = 1;
    private Short isFalse = 0;
    @Override
    public TaotaoResult createPackage(TbPackage tbPackage) throws Exception{
        Long packageId = IDUtils.genItemId();
        BigDecimal package_id = new BigDecimal(packageId);
        tbPackage.setId(package_id);
        tbPackage.setCreated(new Date());
        tbPackage.setUpdated(new Date());
        tbPackage.setStatus(isTrue);
        packageMapper.insert(tbPackage);
        return TaotaoResult.ok();
    }
    @Override
    public Page<TbPackage> getTbPackageList(Integer pageNumber){
        Page<TbPackage> page = new Page<>(pageNumber);
        TbPackageExample example = new TbPackageExample();
        Integer count = packageMapper.countByExample(example);
        PageHelper.startPage(pageNumber, page.getPageSize());
        List<TbPackage> list = packageMapper.selectByExample(example);
        page.setTotalPageItems(count);
        page.setList(list);
        return page;
    }
}
