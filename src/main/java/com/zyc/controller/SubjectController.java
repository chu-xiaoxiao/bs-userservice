package com.zyc.controller;

import com.alibaba.fastjson.JSON;
import com.zyc.exception.StatusException;
import com.zyc.model.Example.SubjectExample;
import com.zyc.model.Subject;
import com.zyc.service.SubjectService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by YuChen Zhang on 18/03/11.
 */
@RestController
public class SubjectController extends BaseController{
    @Autowired
    SubjectService subjectService;
    @RequestMapping(value = "query/subject",method = RequestMethod.POST)
    public List<Subject> query() throws StatusException {
        JSONResult jsonResult = new JSONResult(subjectService.query(new SubjectExample()));
        List<Subject> result = jsonResult.getResultAsArray(Subject.class);
        return result;
    }
}
