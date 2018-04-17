package com.zyc.controller;


import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import com.zyc.model.Power;
import com.zyc.model.User;
import com.zyc.service.MenuService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuController extends BaseController{
    @Autowired
    MenuService menuService;

    @RequestMapping("getMenu")
    public List<Menu> getMenu(User user) throws Exception {
        List<Power> powers = new ArrayList<>();
        Power power = new Power();
        power.setPowerid(1);
        powers.add(power);
        user.setPowers(powers);
        MenuExample menuExample = new MenuExample();
        List<Integer> ids = new ArrayList();
        for(Power temp : user.getPowers()){
            ids.add(temp.getPowerid());
        }
        menuExample.createCriteria().andPowerIn(ids);
        //根据用户权限查询可以使用的菜单
        JSONResult jsonResult = new JSONResult(menuService.query(menuExample));
        List<Menu> menus = jsonResult.getResultAsArray(Menu.class);
        //组织菜单
        for (int i = 0; i < menus.size(); i++) {
            if(menus.get(i).getParent()!=null){
                for(int j = 0;i<menus.size();j++){
                    if(menus.get(i).getParent().equals(menus.get(j).getMenuid())){
                        menus.get(j).putChilds(menus.remove(i));
                        break;
                    }
                }
                i--;
            }
        }
        return menus;
    }
}
