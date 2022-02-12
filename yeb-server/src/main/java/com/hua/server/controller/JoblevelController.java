package com.hua.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.server.pojo.DataGridView;
import com.hua.server.pojo.Joblevel;
import com.hua.server.pojo.RespBean;
import com.hua.server.vo.JoblevelVo;
import com.hua.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laoHuang
 * @since 2021-03-02
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    /*@ApiOperation(value = "获取所有职称(分页)")
    @GetMapping("/")
    public DataGridView<Joblevel> getAllJoblevels(JoblevelVo joblevelVo){
        IPage<Joblevel> page = new Page<>(joblevelVo.getPage(),joblevelVo.getSize());
        //查询条件
        QueryWrapper<Joblevel> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(joblevelVo.getName()),"name",joblevelVo.getName());
        wrapper.eq(!ObjectUtils.isEmpty(joblevelVo.getTitleLevel()),"title_level",joblevelVo.getTitleLevel());
        wrapper.orderByDesc("create_date");
        joblevelService.page(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }*/

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/")
    public RespBean addJoblevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(joblevel)){
            return RespBean.success("添加职称成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "修改职称信息")
    @PutMapping("/")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel){
        if (joblevelService.updateById(joblevel)) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @ApiOperation(value = "根据id删除职称信息")
    @DeleteMapping("/{id}")
    public RespBean removeJoblevel(@PathVariable("id") Integer id){
        if (joblevelService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/")
    public RespBean removeJoblevels(Integer[] ids){
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("批量删除成功");
        }
        return RespBean.error("删除失败");
    }

}
