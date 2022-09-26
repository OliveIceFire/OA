package com.oa.mapper;

import com.oa.entity.Node;
import com.oa.utils.MybatisUtils;

import java.util.List;

//useGeneratedKeys .xml主键自动递增,

public class FuncMapper {
    public List<Node> selectNodeByUserId(Long userId) {
        List list = (List) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("funcmapper.selectNodeByUserId", userId));
        return list;
    }
}
