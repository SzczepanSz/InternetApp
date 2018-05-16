package com.spring.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Data;
import com.spring.service.DataService;

@Controller

public class HomeController {
    @Autowired
    DataService dataService;

    @RequestMapping(value = "/add")
    public String addData(@ModelAttribute Data data) {
        if (data != null) {
            dataService.addData(data);
        }
        return "redirect:/add";
    }

    @RequestMapping("/listData")
    public ModelAndView listData() {
        List<Data> dataList = dataService.listData();
        return new ModelAndView("dataList", "dataList", dataList);
    }


}
