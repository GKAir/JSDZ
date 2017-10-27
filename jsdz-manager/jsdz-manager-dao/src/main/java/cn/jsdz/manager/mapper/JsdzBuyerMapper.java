package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzBuyerMapper {
    int countByExample(JsdzBuyerExample example);

    int deleteByExample(JsdzBuyerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsdzBuyer record);

    int insertSelective(JsdzBuyer record);

    List<JsdzBuyer> selectByExample(JsdzBuyerExample example);

    JsdzBuyer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsdzBuyer record, @Param("example") JsdzBuyerExample example);

    int updateByExample(@Param("record") JsdzBuyer record, @Param("example") JsdzBuyerExample example);

    int updateByPrimaryKeySelective(JsdzBuyer record);

    int updateByPrimaryKey(JsdzBuyer record);
}