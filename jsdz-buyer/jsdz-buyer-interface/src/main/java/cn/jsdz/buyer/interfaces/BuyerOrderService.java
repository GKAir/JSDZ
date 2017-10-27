package cn.jsdz.buyer.interfaces;

import cn.jsdz.common.utils.JsdzResult;

/**
 * Author:  Air
 * Date  :  2017-09-04.
 */
public interface BuyerOrderService {

    JsdzResult findByPage(String phone, Integer pageNum, Integer pageSize);

}
