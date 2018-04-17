package com.zyc.service;

import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient("QUESTION-SERVICE")
@RequestMapping("menu")
public interface MenuService {
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    String insert(@RequestBody Menu menu);
    @RequestMapping(value = "query",method = RequestMethod.POST)
    String query(@RequestBody MenuExample menuExample);
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    String delete(@PathVariable("id") Integer id);
    @RequestMapping(value = "update",method = RequestMethod.POST)
    String update(@RequestBody Map<String, Object> param) throws Exception;
}
