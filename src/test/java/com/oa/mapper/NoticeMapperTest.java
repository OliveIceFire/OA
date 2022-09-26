package com.oa.mapper;

import com.oa.entity.Notice;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

public class NoticeMapperTest extends TestCase {

    @Test
    public void testInsert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            mapper.insert(new Notice(21L, "Test notice"));
            return null;
        });
    }
}