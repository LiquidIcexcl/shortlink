package org.liquidice.shortlink.project.dto.req;

import lombok.Data;

/**
 * 回收站恢复请求DTO
 */
@Data
public class RecycleBinRecoverReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;

}
