package tk.mybatis.simple.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long Id;
    private String roleName;
    private Boolean enabled;
    private Integer createBy;
    private Date createTime;
}
