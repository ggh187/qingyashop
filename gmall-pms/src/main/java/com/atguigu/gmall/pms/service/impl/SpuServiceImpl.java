package com.atguigu.gmall.pms.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.SpuMapper;
import com.atguigu.gmall.pms.entity.SpuEntity;
import com.atguigu.gmall.pms.service.SpuService;


@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuEntity> implements SpuService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<SpuEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<SpuEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public PageResultVo querySpuInfo(PageParamVo pageParamVo, long categoryId) {

        QueryWrapper wapper = new QueryWrapper();
        if (categoryId != 0) {
            wapper.eq("category_id", categoryId);
        }
        //查询条件里面的关键字,这里面的参数可能是用户输入的name或者id
        String key = pageParamVo.getKey();

        if (StringUtils.isNotBlank(key)) {
            //wapper.and(t -> t.like("name", key).or().like("id", key));
        }


        return new PageResultVo(this.page(pageParamVo.getPage(),wapper));

    }

}