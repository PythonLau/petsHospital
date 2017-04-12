package com.coco.aop;


import com.coco.common.utils.IDUtils;
import com.coco.mapper.TbFlowMapper;
import com.coco.pojo.TbFlow;
import org.apache.http.HttpRequest;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
@Aspect
@Component
public class UserControllerLog {
    @Autowired
    private TbFlowMapper flowMapper;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Pointcut("execution(* com.coco.controller.*.*(..))")
    public void pointRequest() { //不需要有方法内部的代码
        //方法体不需要代码
    }
    @After("pointRequest()")
    public void afterRequest(){
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        session = request.getSession();
        TbFlow flow = new TbFlow();
        flow.setUrl(request.getRequestURL().toString());
        flow.setBrowser(request.getHeader("User-Agent").toString());
        Object refererObject = request.getHeader("Referer");
        if(refererObject != null){
            String referer = refererObject.toString();
            flow.setRefer(referer);
        }
        Object userIdObject = session.getAttribute("user");
        if(userIdObject != null){
            String userId = userIdObject.toString();
            BigDecimal user_Id = new BigDecimal(userId);
            flow.setHandler(user_Id);
        }
        flow.setSessionid(session.getId());
        flow.setIp(request.getRemoteHost().toString());
        Long flowId = IDUtils.genItemId();
        BigDecimal flow_Id = new BigDecimal(flowId);
        flow.setId(flow_Id);
        flow.setCreated(new Date());
        flowMapper.insert(flow);
    }
}
