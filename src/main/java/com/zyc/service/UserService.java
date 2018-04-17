package com.zyc.service;

import com.zyc.model.Example.UserExample;
import com.zyc.model.User;
import com.zyc.util.MapUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("QUESTION-SERVICE")
@RequestMapping("/user")
public interface UserService {

    @RequestMapping("query/{id}")
    String queryUser(@PathVariable("id") Integer id);
    @RequestMapping("query")
    String queryUser(@RequestBody UserExample userExample);
    @RequestMapping("delete")
    String deleteUser(@RequestBody UserExample userExample);
    @RequestMapping("insert")
    String insertUser(@RequestBody User user);
    @RequestMapping("update")
    String modifyUser(Map<String,Object> modifyPara) throws Exception;
}
