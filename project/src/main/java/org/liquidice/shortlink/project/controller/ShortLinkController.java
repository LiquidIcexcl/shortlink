package org.liquidice.shortlink.project.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.project.common.convention.result.Result;
import org.liquidice.shortlink.project.common.convention.result.Results;
import org.liquidice.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.liquidice.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkBatchCreateRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.liquidice.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import org.liquidice.shortlink.project.handler.CustomBlockHandler;
import org.liquidice.shortlink.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接-控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    /**
     * 创建短链接
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, HttpServletRequest request, HttpServletResponse response) {
        shortLinkService.restoreUrl(shortUri, request, response);
    }

    /**
     * 创建短链接
     */
    @PostMapping("/api/shortlink/v1/create")
    @SentinelResource(
            value = "create_short-link",
            blockHandler = "createShortLinkBlockHandlerMethod",
            blockHandlerClass = CustomBlockHandler.class
    )
    public Result<ShortLinkCreateRespDTO> createShortLink
            (@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    /**
     * 通过分布式锁创建短链接
     */
    @PostMapping("/api/shortlink/v1/create/by-lock")
    public Result<ShortLinkCreateRespDTO> createShortLinkByLock(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLinkByLock(requestParam));
    }

    /**
     * 批量创建短链接
     */
    @PostMapping("/api/shortlink/v1/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
       return Results.success(shortLinkService.batchCreateShortLink(requestParam));
    }

    /**
     * 修改短链接
     */
    @PostMapping("/api/shortlink/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/shortlink/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    /**
     * 查询短链接分组内数量
     */
    @GetMapping("/api/shortlink/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam) {
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }
}
