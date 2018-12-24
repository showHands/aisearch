package com.hengan.aisearch.controller;

import com.hengan.aisearch.db.schema.AIUser;
import com.hengan.aisearch.service.AIUserService;
import com.hengan.aisearch.vo.ResponseBean;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2018/12/21 10:54
 * @Created by 王晓涛
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    AIUserService aiUserService;

    @ApiOperation(value = "根据用户id查询用户实体信息", notes = "查询用户实体信息")
    @ApiImplicitParam(name = "userId", value = "用户ID")
    @GetMapping("/queryUserById")
    public ResponseBean queryUserById(@RequestParam(value = "userId", defaultValue = "-1") final Long userId){
        AIUser aiUser = aiUserService.queryByUserId(userId);
        return ResponseBean.successdata(aiUser);
    }


    /*@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", required = true, dataType ="Long"),
            @ApiImplicitParam(name = "name", value = "用户姓名", paramType = "path", required = true, dataType ="String")
    })*/
    @GetMapping("/updateUserInfo")
    public ResponseBean updateUserInfo(@RequestParam(value = "userId", defaultValue = "0") Long userId, @RequestParam(value = "name", defaultValue = "") String name){
        AIUser aiUser = aiUserService.queryByUserId(userId);
        if(null != aiUser){
            aiUser.setName(name);
        }
        aiUserService.updateUserInfo(aiUser);
        return ResponseBean.successdata(aiUser);

    }


    @GetMapping("/deleteUserById")
    public ResponseBean deleteUserById(@RequestParam("userId") Long userId){
        AIUser aiUser = aiUserService.queryByUserId(userId);
        return ResponseBean.successdata(aiUser);

    }

    /**
     * demo
     * @param object
     * @return
     */
    @RequestMapping(value = "/article", method = POST, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "summary", value = "文章摘要", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "发布状态", required = true, dataType = "Integer")
    })
    @ApiResponse(code=200,message="成功",response=ResponseBean.class)
    public ResponseBean saveArticle(@RequestBody Object object){

        return ResponseBean.success("查询成功");
    }
}
