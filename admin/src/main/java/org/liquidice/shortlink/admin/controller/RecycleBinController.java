package org.liquidice.shortlink.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.admin.common.convention.result.Result;
import org.liquidice.shortlink.admin.common.convention.result.Results;
import org.liquidice.shortlink.admin.dto.req.RecycleBinRecoverReqDTO;
import org.liquidice.shortlink.admin.dto.req.RecycleBinRemoveReqDTO;
import org.liquidice.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import org.liquidice.shortlink.admin.remote.ShortLinkActualRemoteService;
import org.liquidice.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.liquidice.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.liquidice.shortlink.admin.service.RecycleBinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController(value="recycleBinControllerByAdmin")
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 保存回收站
     */
    @PostMapping("/api/shortlink/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        shortLinkActualRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/shortlink/admin/v1/recycle-bin/page")
    public Result<Page<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }

    /**
     * 恢复短链接
     */
    @PostMapping("/api/shortlink/admin/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        shortLinkActualRemoteService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 移除短链接
     */
    @PostMapping("/api/shortlink/admin/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        shortLinkActualRemoteService.removeRecycleBin(requestParam);
        return Results.success();
    }
}
