package com.oa.mapper;

import com.oa.entity.ProcessFlow;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class ProcessFlowMapperTest extends TestCase {

    @Test
    public void testInsert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            ProcessFlowMapper mapper = sqlSession.getMapper(ProcessFlowMapper.class);
            ProcessFlow processFlow = new ProcessFlow();
            processFlow.setFormId(3L);
            processFlow.setOperatorId(2L);
            processFlow.setAction("audit");
            processFlow.setResult("approved");
            processFlow.setReason("同意");
            processFlow.setCreateTime(new Date());
            processFlow.setAuditTime(new Date());
            processFlow.setOrderNo(1);
            processFlow.setState("ready");
            processFlow.setIsLast(1);
            mapper.insert(processFlow);
            return null;
        });
    }
}