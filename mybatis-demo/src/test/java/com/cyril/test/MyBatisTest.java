package com.cyril.test;

import com.cyril.mapper.BrandMapper;
import com.cyril.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void queryAll() throws IOException {

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> list = brandMapper.selectAll();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void queryById() throws IOException {

        int id = 1;

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);

        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void queryByCondition() throws IOException {

        int status = 0;
        String companyName = "三只";
        String brandName = "松鼠";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // List<Brand> brandList = brandMapper.selectByCondition(status, companyName, brandName);
        // Brand brand = new Brand(status,companyName,brandName);
        Map map = new HashMap<>();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        List<Brand> brandList = brandMapper.selectByCondition(map);

        System.out.println(brandList);

        sqlSession.close();
    }

    @Test
    public void queryByConditionDynamic() throws IOException {

        int status = 0;
        String companyName = "三只";
        String brandName = "松鼠";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Map map = new HashMap<>();
        // map.put("status",status);
        map.put("companyName",companyName);
        // map.put("brandName",brandName);
        List<Brand> brandList = brandMapper.selectByCondition_dynamic(map);

        System.out.println(brandList);

        sqlSession.close();
    }

    @Test
    public void queryByConditionDynamicSingle() throws IOException {

        int status = 0;
        String companyName = "三只";
        String brandName = "松鼠";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        // brand.setStatus(1);
        List<Brand> brandList = brandMapper.selectByCondition_dynamic_single(brand);

        System.out.println(brandList);

        sqlSession.close();
    }

    @Test
    public void add() throws IOException {

        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        int ordered = 100;
        String description = "手机中的战斗机";

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand(brandName,companyName,ordered,description,status);

        brandMapper.add(brand);

        System.out.println(brand.getId());

        sqlSession.close();
    }

    @Test
    public void updateAll() throws IOException {

        int status = 0;
        String companyName = "苹果手机";
        String brandName = "苹果";
        int ordered = 10;
        String description = "手机中的菜鸡";
        int id = 5;

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql 参数true，改为自动commit事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand(id,brandName,companyName,ordered,description,status);

        int i = brandMapper.updateAll(brand);

        System.out.println(i);

        sqlSession.close();
    }

    @Test
    public void updateSome() throws IOException {

        int status = 0;
        String companyName = "苹果手机";
        // String brandName = "苹果";
        // int ordered = 10;
        String description = "手机中的菜鸡";
        int id = 4;

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql 参数true，改为自动commit事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setId(id);

        int i = brandMapper.updateSome(brand);

        System.out.println(i);

        sqlSession.close();
    }

    @Test
    public void deleteSingle() throws IOException {

        int status = 0;
        String companyName = "苹果手机";
        // String brandName = "苹果";
        // int ordered = 10;
        String description = "手机中的菜鸡";
        int id = 5;

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql 参数true，改为自动commit事务，改为false，则需要手动commit
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteSingle(id);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteMore() throws IOException {

        int status = 0;
        String companyName = "苹果手机";
        // String brandName = "苹果";
        // int ordered = 10;
        String description = "手机中的菜鸡";
        int[] ids = {1,2,3};

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql 参数true，改为自动commit事务，改为false，则需要手动commit
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // 3、获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteMore(ids);

        sqlSession.commit();

        sqlSession.close();
    }
}
