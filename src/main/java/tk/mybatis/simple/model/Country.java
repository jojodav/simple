package tk.mybatis.simple.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Country {
    @TableId
    private long id;

    @TableField("country_name")
    private String countryName;

    @TableField("country_code")
    private String countryCode;
}
