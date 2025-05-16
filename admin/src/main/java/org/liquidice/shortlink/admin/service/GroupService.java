package org.liquidice.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.liquidice.shortlink.admin.dao.entity.GroupDO;
import org.liquidice.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.liquidice.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.liquidice.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 短链接分组接口层
 */
public interface  GroupService extends IService<GroupDO> {

    /**
     * 新建短链接分组
     * @param groupName 短链接分组名称
     */
    void saveGroup(String groupName);

    /**
     * 新建短链接分组
     * @param username 用户名
     * @param groupName 短链接分组名称
     */
    void saveGroup(String username, String groupName);

    /**
     * 查询用户短链接分组集合
     * @return 用户短链接分组集合
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改短链接分组
     * @param requestParam 修改短链接分组请求DTO
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     * @param gid 短链接分组ID
     */
    void deleteGroup(String gid);

    /**
     * 短链接分组排序
     * @param requestParam 短链接分组排序请求DTO
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
