package com.hua.server.service.impl;

import com.hua.server.pojo.Oplog;
import com.hua.server.mapper.OplogMapper;
import com.hua.server.service.IOplogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
