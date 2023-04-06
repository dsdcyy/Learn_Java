package com.atguigu.fruit.dao;

import com.atguigu.fruit.dao.impl.FruitDaoImplException;
import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取指定页码上的库存列表信息 , 每页显示5条
    List<Fruit> getFruitList(String keyword , Integer pageNo) throws FruitDaoImplException;

    //根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Integer fid) throws FruitDaoImplException;

    //修改指定的库存记录
    void updateFruit(Fruit fruit) throws FruitDaoImplException;

    //根据fid删除指定的库存记录
    void delFruit(Integer fid) throws FruitDaoImplException;

    //添加新库存记录
    void addFruit(Fruit fruit) throws FruitDaoImplException;

    //查询库存总记录条数
    int getFruitCount(String keyword) throws FruitDaoImplException;
}
