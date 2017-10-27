package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzBuyerOrder;
import cn.jsdz.manager.po.JsdzBuyerOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzBuyerOrderMapper {
    int countByExample(JsdzBuyerOrderExample example);

    int deleteByExample(JsdzBuyerOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JsdzBuyerOrder record);

    int insertSelective(JsdzBuyerOrder record);

    List<JsdzBuyerOrder> selectByExampleWithBLOBs(JsdzBuyerOrderExample example);

    List<JsdzBuyerOrder> selectByExample(JsdzBuyerOrderExample example);

    JsdzBuyerOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JsdzBuyerOrder record, @Param("example") JsdzBuyerOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") JsdzBuyerOrder record, @Param("example") JsdzBuyerOrderExample example);

    int updateByExample(@Param("record") JsdzBuyerOrder record, @Param("example") JsdzBuyerOrderExample example);

    int updateByPrimaryKeySelective(JsdzBuyerOrder record);

    int updateByPrimaryKeyWithBLOBs(JsdzBuyerOrder record);

    int updateByPrimaryKey(JsdzBuyerOrder record);
}