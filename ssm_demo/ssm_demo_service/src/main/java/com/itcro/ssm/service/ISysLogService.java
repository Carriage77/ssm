package com.itcro.ssm.service;

import com.itcro.ssm.domain.SysLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ISysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;

}
