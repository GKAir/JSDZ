package cn.jsdz.buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:  Air
 * Date  :  2017-09-03.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }
}
