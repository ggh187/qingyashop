/**
 * Copyright (c) 2016-2019 青芽开源 All rights reserved.
 * <p>
 * https://www.guli.cloud
 * <p>
 * 版权所有，侵权必究！
 */

package com.atguigu.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;


/**
 * 角色与菜单对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] roleIds);

}
