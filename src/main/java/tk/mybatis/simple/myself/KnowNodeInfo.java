package tk.mybatis.simple.myself;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowNodeInfo {
    private long id;
    private long neo4jid;
    private String nodeLabels;
}
