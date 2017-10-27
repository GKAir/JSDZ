package cn.jsdz.manager.controller;

import cn.jsdz.buyer.interfaces.BuyerService;
import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzBuyerOrder;
import cn.jsdz.manager.po.JsdzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jsdz.manager.interfaces.ManagerService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "/login")
	public JsdzResult login(JsdzManager manager) {
        return managerService.login(manager);
	}	

	@RequestMapping("/register")
	public JsdzResult register(JsdzManager manager) {
        return managerService.register(manager);
	}
    /**
     * 查找所有客户
     * @return JsdzResult.build(200,查询成功,list)
     */
	@RequestMapping("/findAll")
    @ResponseBody
    public JsdzResult findAllBuyer() {
        return buyerService.findAll();
    }

    @RequestMapping("/findByPage")
    @ResponseBody
    public JsdzResult findByPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
            return buyerService.findByPage(pageNum, pageSize);

    }

    //生成订单
    @RequestMapping("/genOrder")
    @ResponseBody
    public String genOrder(JsdzBuyerOrder buyerOrder) {
        return buyerService.genOrder(buyerOrder);
    }
    /*@RequestMapping("genData")
    public void genDate() {
	    buyerService.genData();
    }*/
}
