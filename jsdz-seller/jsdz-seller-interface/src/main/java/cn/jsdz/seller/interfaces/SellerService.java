package cn.jsdz.seller.interfaces;

import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerOrder;
import cn.jsdz.manager.po.JsdzSeller;

public interface SellerService {

    JsdzResult register(JsdzSeller seller);

    JsdzResult login(JsdzSeller seller);

    JsdzResult authentication(JsdzSeller seller);

    JsdzResult sendMsg(JsdzBuyerOrder buyerOrder);

}
