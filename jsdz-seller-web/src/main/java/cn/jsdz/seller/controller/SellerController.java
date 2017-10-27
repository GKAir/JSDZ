package cn.jsdz.seller.controller;

import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzSeller;
import cn.jsdz.seller.interfaces.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:  Air
 * Date  :  2017-09-06.
 */
@Controller
@RequestMapping("seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/authentication")
    public JsdzResult authentication(JsdzSeller seller) {
        return sellerService.authentication(seller);
    }
}
