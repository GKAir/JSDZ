package cn.jsdz.buyer.interfaces;

import java.io.Serializable;
import java.util.List;

import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerOrder;

public interface BuyerService extends Serializable{

	JsdzResult register(JsdzBuyer buyer);
	
	JsdzResult login(JsdzBuyer buyer);

    JsdzResult authentication(JsdzBuyer buyer);

    JsdzResult update(JsdzBuyer buyer);

    JsdzResult delete(JsdzBuyer buyer);

    JsdzResult findByPhone(String phone);

    JsdzResult findById(Integer id);

    JsdzResult findByPage(Integer pageNum,Integer pageSize);

    JsdzResult findAll();

    String genOrder(JsdzBuyerOrder buyerOrder);
}
