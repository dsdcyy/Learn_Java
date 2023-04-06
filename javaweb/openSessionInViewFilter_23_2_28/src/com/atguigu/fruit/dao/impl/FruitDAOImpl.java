package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.myssm.basedao.BaseDaoException;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    public FruitDAOImpl() throws BaseDaoException {
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) throws FruitDaoImplException {
        try {
            return super.executeQuery("select * from t_fruit where fname like ?  limit ? , 5", "%" + keyword + "%", (pageNo - 1) * 5);
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("FruitDAO.getFruitList failed...");
        }
    }

    @Override
    public Fruit getFruitByFid(Integer fid) throws FruitDaoImplException {
        try {
            return super.load("select * from t_fruit where fid = ? ", fid);
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("FruitDAO.getFruitByFid failed...");
        }
    }

    @Override
    public void updateFruit(Fruit fruit) throws FruitDaoImplException {
        String sql = "update t_fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ? ";
        try {
            super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("FruitDAO.updateFruit failed...");
        }
    }

    @Override
    public void delFruit(Integer fid) throws FruitDaoImplException {
        try {
            super.executeUpdate("delete from t_fruit where fid = ? ", fid);
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("deleteFruit failed...");
        }
    }

    @Override
    public void addFruit(Fruit fruit) throws FruitDaoImplException {
        String sql = "insert into t_fruit values(0,?,?,?,?)";
        try {
            super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("insertFruit failed...");
        }
    }

    @Override
    public int getFruitCount(String keyword) throws FruitDaoImplException {
        try {
            return ((Long) super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?", "%" + keyword + "%", "%" + keyword + "%")[0]).intValue();
        } catch (BaseDaoException e) {
            throw new FruitDaoImplException("getFruitCount failed...");
        }
    }
}

// 39行报错  ClassCastException: java.lang.Long cannot be cast to java.lang.Integer