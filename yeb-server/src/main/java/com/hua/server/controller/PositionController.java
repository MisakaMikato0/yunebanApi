package com.hua.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.server.pojo.DataGridView;
import com.hua.server.pojo.Position;
import com.hua.server.pojo.RespBean;
import com.hua.server.service.IPositionService;
import com.hua.server.vo.PositionVo;
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
@RequestMapping("/system/config/pos")
public class PositionController {

    @Autowired
    private IPositionService iPositionService;

    /*@ApiOperation(value = "获取所有职位(分页)")
    @GetMapping("/")
    public DataGridView<Position> getAllPositions(PositionVo positionVo){
        //分页对象
        IPage<Position> page = new Page<>(positionVo.getPage(),positionVo.getSize());
        //查询条件
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.like(!ObjectUtils.isEmpty(positionVo.getName()),"name",positionVo.getName());
        wrapper.orderByDesc("create_date");
        iPositionService.page(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }*/

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPosition(){
        return iPositionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if (iPositionService.save(position)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (iPositionService.updateById(position)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean removePosition(@PathVariable Integer id){
        if (iPositionService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean removePositions(Integer[] ids){
        if (iPositionService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }

}
