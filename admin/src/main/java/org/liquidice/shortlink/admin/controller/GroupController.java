package org.liquidice.shortlink.admin.controller;


import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.admin.common.convention.result.Result;
import org.liquidice.shortlink.admin.common.convention.result.Results;
import org.liquidice.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.liquidice.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.liquidice.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.liquidice.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import org.liquidice.shortlink.admin.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接分组管理-控制层
 */
@RestController(value = "GroupControllerByAdmin")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     *  新增短链接分组
     */
    @PostMapping("/api/shortlink/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询短链接分组集合
     */
    @GetMapping("/api/shortlink/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名称
     */
    @PutMapping("/api/shortlink/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接分组
     */
    @DeleteMapping("/api/shortlink/admin/v1/group")
    public Result<Void> updateGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 排序短链接分组
     */
    @PostMapping("/api/shortlink/admin/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam) {
        groupService.sortGroup(requestParam);
        return Results.success();
    }
}
