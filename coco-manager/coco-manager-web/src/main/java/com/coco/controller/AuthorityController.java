package com.coco.controller;

import com.coco.common.pojo.EUDataGridResult;
import com.coco.common.pojo.Ids;
import com.coco.common.pojo.TaotaoResult;
import com.coco.common.pojo.search_params;
import com.coco.pojo.TbAuthority;
import com.coco.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
@Controller
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;
    @RequestMapping("/manager/authority/save")
    @ResponseBody
    public TaotaoResult createAuthority(TbAuthority authority){
        TaotaoResult result = authorityService.createAuthority(authority);
        return result;
    }
    @RequestMapping("/manager/authority/list")
    @ResponseBody
    public EUDataGridResult getAuthorityList(Integer page,Integer rows){
        EUDataGridResult result = authorityService.getAuthorityList(page,rows);
        return result;
    }
    @RequestMapping("/manager/authority/search")
    @ResponseBody
    public EUDataGridResult searchAuthority(@RequestBody search_params search_params){
        String userId = search_params.getSearch_key();
        BigDecimal user_Id = new BigDecimal(userId);
        Integer page = new Integer(search_params.getPageNumber());
        Integer rows = new Integer(search_params.getRows());
        EUDataGridResult result = authorityService.searchAuthority(user_Id,page,rows);
        return result;
    }
    @RequestMapping("/manager/authority/delete")
    @ResponseBody
    public TaotaoResult deleteAuthority(@RequestBody Ids ids) throws Exception{
        String deleteIds = ids.getIds();
        TaotaoResult result = authorityService.deleteAuthority(deleteIds);
        return result;
    }
}
