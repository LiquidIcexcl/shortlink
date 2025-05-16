package org.liquidice.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.liquidice.shortlink.project.dao.entity.ShortLinkDO;
import org.liquidice.shortlink.project.dto.biz.ShortLinkStatsRecordDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkBatchCreateRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;


/**
 * 短链接服务接口层
 */
public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     * @param requestParam 请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 根据分布式锁创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLinkByLock(ShortLinkCreateReqDTO requestParam);

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 批量创建短链接返回参数
     */
    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * 更新短链接
     * @param requestParam 请求参数
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 分页查询短链接
     * @param requestParam 请求参数
     * @return 短链接分页信息
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内数量
     * @param requestParam 请求参数
     * @return 短链接分组内数量信息
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    /**
     * 短链接跳转
     * @param shortUri 短链接后缀
     * @param request   HTTP请求
     * @param response  HTTP响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 短链接统计
     *
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(ShortLinkStatsRecordDTO shortLinkStatsRecord);
}
