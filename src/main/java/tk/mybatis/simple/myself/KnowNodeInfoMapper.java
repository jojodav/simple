package tk.mybatis.simple.myself;

import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface KnowNodeInfoMapper {
    @MapKey("id")
    @ResultMap("KnowNodeInfoMapper")
    @Select("select id,neo4jid ,node_labels as nodeLabels " +
            "from mydavinci.know_node_info where id=#{id}#")
    Map<Long, KnowNodeInfo> getNodeLabelsById(@Param("id") long id);
}
