package cn.jsdz.buyer.controller;

import cn.jsdz.buyer.interfaces.BuyerOrderService;
import cn.jsdz.buyer.interfaces.BuyerService;
import cn.jsdz.common.utils.JsdzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Author:  Air
 * Date  :  2017-09-04.
 */
@Controller
@RequestMapping("/buyer")
public class BuyerOrderController {

    @Autowired
    BuyerOrderService buyerOrderService;
    @RequestMapping(value = "/findMyOrder",method = RequestMethod.POST)
    @ResponseBody
    public JsdzResult findBuyerOrderByPage(String phone, Integer pageNum, Integer pageSize, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        return buyerOrderService.findByPage(phone, pageNum, pageSize);
    }
}
