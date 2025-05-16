package org.liquidice.shortlink.project.dto.resp;

import lombok.Data;

/**
 * 短链接分组统计查询响应DTO
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组短链接数量
     */
    private Integer shortLinkCount;
}
