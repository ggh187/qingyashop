package com.atguigu.gmall.pms.controller;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.pms.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**********************************************************
 日期:2021-06-06
 作者:刘刚
 描 述: 
 ***********************************************************/
@Api(tags = "spuInfo信息管理")
@RestController
@RequestMapping("pms/spuinfo")
public class SpuInfoController {
    @Autowired
    SpuService spuService;

    @ApiOperation("spuInfo信息管理")
    @GetMapping("category/{categoryID}")
    public ResponseVo<PageResultVo> querySpuInfo(@PathVariable("categoryID") long categoryId, PageParamVo pageParamVo) {
        //pageparamVo是分页的参数的对象,当前页面和每页的数量
        //pageresult里面包含的有当前页数和中记录数和总页数以及列表数据
       PageResultVo pageResultVo= this.spuService.querySpuInfo(pageParamVo, categoryId);



        return ResponseVo.ok(pageResultVo);
    }

}
