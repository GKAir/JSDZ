package cn.jsdz.manager.interfaces;

import java.io.Serializable;
import java.util.List;

import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerExample;
import cn.jsdz.manager.po.JsdzManager;

public interface ManagerService extends Serializable{

    JsdzResult register(JsdzManager manager);

    JsdzResult login(JsdzManager manager);
	
}
