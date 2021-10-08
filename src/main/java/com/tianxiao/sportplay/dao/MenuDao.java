package com.tianxiao.sportplay.dao;

import com.tianxiao.sportplay.entity.MainMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
