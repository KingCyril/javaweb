package com.cyril.mapper;

import com.cyril.pojo.Brand;
import com.cyril.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * sql语句设置多个参数
     * 1、散装参数：需要使用@Param("sql中的参数占位符名称")
     * 2、实体类封装参数：只需要保证sql中的参数名和实体类属性名对应上，即可设置成功
     * 3、map集合：需要保证sql中的参数名和map集合的键的名称对应上，即可设置成功
     */
    // List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    // List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByCondition_dynamic(Map map);

    List<Brand> selectByCondition_dynamic_single(Brand brand);

    void add(Brand brand);

    int updateAll(Brand brand);

    int updateSome(Brand brand);

    void deleteSingle(int id);

    void deleteMore(@Param("ids") int[] ids);
}
