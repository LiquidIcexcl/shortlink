package org.liquidice.shortlink.admin.dto.req;
import lombok.Data;

/**
 * 短链接分组排序请求DTO
 */

@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}
