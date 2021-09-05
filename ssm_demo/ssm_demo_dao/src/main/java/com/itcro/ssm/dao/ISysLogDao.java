package com.itcro.ssm.dao;

import com.itcro.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values" +
            "(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);


    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;

}
