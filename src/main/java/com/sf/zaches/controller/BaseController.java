package com.sf.zaches.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BaseController
 * @Description
 * @Author 01371059
 * @Date 2018/10/3 下午11:16
 * @Version 1.0
 **/
@RestController
public class BaseController {
    @RequestMapping("/")
    public Map Index(){
        Map map = new HashMap();
        map.put("message","hello world!");
        return map;
    }
}
