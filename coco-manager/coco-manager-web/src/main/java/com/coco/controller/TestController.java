package com.coco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
@Controller
public class TestController {
    @RequestMapping("/test/list")
    @ResponseBody
    public List testTree(){
        System.out.println("come in test");
        List test = new ArrayList();
        Map test1 = new HashMap<>();
        Map attributes = new HashMap();
        test1.put("id",1);
        test1.put("text","chunhe");
        test1.put("status","open");
        attributes.put("url","/index");
        test1.put("attributes",attributes);
        test.add(test1);
        return test;
    }
}
