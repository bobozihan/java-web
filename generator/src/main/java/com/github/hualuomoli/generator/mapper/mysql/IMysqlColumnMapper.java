package com.github.hualuomoli.generator.mapper.mysql;

import org.springframework.stereotype.Repository;

import com.github.hualuomoli.generator.mapper.IColumnMapper;
import com.github.hualuomoli.stereotype.Mapper;

/**
 * mysql column mapper
 * @author hualuomoli
 *
 */
@Mapper(value = "mysqlColumnMapper")
public interface IMysqlColumnMapper extends IColumnMapper {

}
