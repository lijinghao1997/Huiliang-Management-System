package com.huiliang.oilservice.mapper;

import entity.Oil;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OilMapper {
    int insert(Oil record);

    List<Oil> selectAll();

    Oil getByName(String name);

    Oil getByNo(Short no);

    int updateOilByNo(@Param("no") Short no, @Param("price") BigDecimal price);
}
