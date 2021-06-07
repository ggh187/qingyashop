package com.atguigu.gmall.pms.controller;

import java.util.List;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.service.AttrService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.common.bean.PageParamVo;

/**
 * 商品属性
 *
 * @author liugang
 * @email 18751307732@qq.com
 * @date 2021-05-13 23:35:43
 */
@Api(tags = "商品属性 管理")
@RestController
@RequestMapping("pms/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    /*查询分类下的规格参数    cid和type和searchtype查询category表
                                        是否必须
    | cid        | 分类id       | long | 是                       |
    | type       | 是否基本属性 | int  | 0-销售属性，1-基本属性   |
    | searchType | 是否搜索参数 | int  | 0-非搜索参数，1-搜索参数 |
    * */

    @ApiOperation("查询分类下的规格参数")
    @GetMapping("category/{cid}")
    public ResponseVo<List<AttrEntity>> queryAttrsByCidAndTypeOrSearchType(
            @PathVariable("cid")Long cid,
            @RequestParam(value = "type", required = false)Integer type,
            @RequestParam(value = "searchType", required = false)Integer searchType
    ){
        List<AttrEntity> attrEntities = this.attrService.queryAttrsByCidAndTypeOrSearchType(cid, type, searchType);
        return ResponseVo.ok(attrEntities);
    }

    /*查询分组下的规格参数
     * */
    @GetMapping("group/{gid}")
    @ApiOperation("查询分组下的规格参数")
    public ResponseVo queryGroupBygid(@PathVariable("gid") long gid) {

        List<AttrEntity> attrEntityList = this.attrService.list(new QueryWrapper<AttrEntity>().eq("group_id", gid));
        return ResponseVo.ok(attrEntityList);

    }


    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseVo<PageResultVo> queryAttrByPage(PageParamVo paramVo) {
        PageResultVo pageResultVo = attrService.queryPage(paramVo);

        return ResponseVo.ok(pageResultVo);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseVo<AttrEntity> queryAttrById(@PathVariable("id") Long id) {
        AttrEntity attr = attrService.getById(id);

        return ResponseVo.ok(attr);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseVo<Object> save(@RequestBody AttrEntity attr) {
        attrService.save(attr);

        return ResponseVo.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseVo update(@RequestBody AttrEntity attr) {
        attrService.updateById(attr);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseVo delete(@RequestBody List<Long> ids) {
        attrService.removeByIds(ids);

        return ResponseVo.ok();
    }

}
