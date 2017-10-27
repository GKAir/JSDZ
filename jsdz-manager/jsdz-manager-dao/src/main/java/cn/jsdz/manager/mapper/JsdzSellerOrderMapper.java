package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzSellerOrder;
import cn.jsdz.manager.po.JsdzSellerOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzSellerOrderMapper {
    int countByExample(JsdzSellerOrderExample example);

    int deleteByExample(JsdzSellerOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(JsdzSellerOrder record);

    int insertSelective(JsdzSellerOrder record);

    List<JsdzSellerOrder> selectByExample(JsdzSellerOrderExample example);

    JsdzSellerOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") JsdzSellerOrder record, @Param("example") JsdzSellerOrderExample example);

    int updateByExample(@Param("record") JsdzSellerOrder record, @Param("example") JsdzSellerOrderExample example);

    int updateByPrimaryKeySelective(JsdzSellerOrder record);

    int updateByPrimaryKey(JsdzSellerOrder record);
}