package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzBuyerAddress;
import cn.jsdz.manager.po.JsdzBuyerAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzBuyerAddressMapper {
    int countByExample(JsdzBuyerAddressExample example);

    int deleteByExample(JsdzBuyerAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsdzBuyerAddress record);

    int insertSelective(JsdzBuyerAddress record);

    List<JsdzBuyerAddress> selectByExample(JsdzBuyerAddressExample example);

    JsdzBuyerAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsdzBuyerAddress record, @Param("example") JsdzBuyerAddressExample example);

    int updateByExample(@Param("record") JsdzBuyerAddress record, @Param("example") JsdzBuyerAddressExample example);

    int updateByPrimaryKeySelective(JsdzBuyerAddress record);

    int updateByPrimaryKey(JsdzBuyerAddress record);
}