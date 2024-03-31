package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     *
     * @return
     */
    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);

    //插入并且生成主键
    int insert2(SysUser sysUser);

    //插入并生成主键，然后通过一个insert 的 select 子句获取
    int insert3(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId") Long userId,
            @Param("enabled") Integer enabled);

    List<SysUser> selectByUser(SysUser sysUser);

    List<SysUser> updateByIdSelective(SysUser sysUser);
}
