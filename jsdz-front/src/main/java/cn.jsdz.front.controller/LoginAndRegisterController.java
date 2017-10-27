package cn.jsdz.front.controller;

import cn.jsdz.manager.po.JsdzSeller;
import cn.jsdz.manager.po.ext.JsdzModel;
import cn.jsdz.seller.interfaces.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.jsdz.buyer.interfaces.BuyerService;
import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzBuyer;

import javax.servlet.http.HttpServletResponse;

//@CrossOrigin(origins = "",maxAge = 3600)
@Controller
@RequestMapping("/front")
public class LoginAndRegisterController {
	/**
	 * stateCode 用于区分是客户还是厂家：
	 * 		1-->客户     buyer
	 * 		2-->厂家    seller
	 * @param usertype
	 * @return
	 */

	@Autowired
	private BuyerService managerService;

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/login")
    @ResponseBody
	public JsdzResult login(String usertype, JsdzModel jsdzModel, Model model, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (usertype.equals("1")) {
            JsdzBuyer buyer = new JsdzBuyer();
            BeanUtils.copyProperties(jsdzModel,buyer);
            System.out.println("buyerRegister-->" + buyer);
            JsdzResult jsdzResult = managerService.login(buyer);
			if (jsdzResult.getStatus().equals(200)){
                model.addAttribute("buyer",jsdzResult.getData());
            }
			return jsdzResult;
		}else {
            JsdzSeller seller = new JsdzSeller();
            BeanUtils.copyProperties(jsdzModel,seller);
            System.out.println("sellerLogin-->" + seller);
            JsdzResult jsdzResult = sellerService.login(seller);
            if (jsdzResult.getStatus().equals(200)){
                model.addAttribute("seller",jsdzResult.getData());
            }
            return jsdzResult;
		}
	}

	@RequestMapping("/register")
    @ResponseBody
	public JsdzResult register(String usertype, JsdzModel jsdzModel, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (usertype.equals("1")) {
            JsdzBuyer buyer = new JsdzBuyer();
            BeanUtils.copyProperties(jsdzModel,buyer);
            System.out.println("buyerRegister-->" + buyer);
            return managerService.register(buyer);
		}else {
            JsdzSeller seller = new JsdzSeller();
            BeanUtils.copyProperties(jsdzModel, seller);
            System.out.println("sellerRegister-->" + seller);
            return sellerService.register(seller);
		}
	}
}
