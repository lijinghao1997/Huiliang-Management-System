package com.huiliang.oilservice.mapper;

import entity.Oil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Mapper
@Component
public interface OilMapper {
    int insert(Oil record);

    List<Oil> selectAll();

    Oil getByName(@Param("name") String name);

    Oil getByNo(@Param("no") Short no);

    int updateOilByNo(@Param("no") Short no, @Param("price") BigDecimal price);
}
