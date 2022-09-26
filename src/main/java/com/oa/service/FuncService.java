package com.oa.service;


import com.oa.entity.Node;
import com.oa.mapper.FuncMapper;

import java.util.List;

public class FuncService {
    private FuncMapper funcMapper = new FuncMapper();//初始化

    public List<Node> selectNodeByUserId(Long userId) {
        return funcMapper.selectNodeByUserId(userId);
    }

    ;
}
