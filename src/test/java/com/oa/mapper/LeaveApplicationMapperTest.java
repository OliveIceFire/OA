package com.oa.mapper;

import com.oa.entity.LeaveApplication;
import com.oa.utils.MybatisUtils;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//方法命名应为test+测试类名
public class LeaveApplicationMapperTest extends TestCase {

    @Test
    public void testInsert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            LeaveApplicationMapper mapper = sqlSession.getMapper(LeaveApplicationMapper.class);
            LeaveApplication form = new LeaveApplication();
            form.setEmployeeId(4L); //员工编号
            form.setFormType(1); //事假
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = null;//起始时间
            Date endTime = null;//结束时间
            try {
                startTime = sdf.parse("2020-03-25 08:00:00");
                endTime = sdf.parse("2020-04-01 18:00:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            form.setStartTime(startTime);
            form.setEndTime(endTime);
            form.setReason("回家探亲");//请假事由
            form.setCreateTime(new Date());//创建时间
            form.setState("processing");//当前状态
            mapper.insert(form);
            return null;
        });
    }

}