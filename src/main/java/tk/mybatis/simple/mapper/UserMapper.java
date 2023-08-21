package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();
}
