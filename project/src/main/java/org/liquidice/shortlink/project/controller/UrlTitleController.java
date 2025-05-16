package org.liquidice.shortlink.project.controller;

import lombok.RequiredArgsConstructor;
import org.liquidice.shortlink.project.common.convention.result.Result;
import org.liquidice.shortlink.project.common.convention.result.Results;
import org.liquidice.shortlink.project.service.UrlTitleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL 标题控制层
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    private final UrlTitleService urlTitleService;

    /**
     * 根据URL获取对应网站标题
     * @param url
     */
    @GetMapping("/api/shortlink/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url){
        return Results.success(urlTitleService.getTitleByUrl(url));
    }

}
