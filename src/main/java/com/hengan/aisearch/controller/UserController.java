package com.hengan.aisearch.controller;

import com.hengan.aisearch.db.schema.AIUser;
import com.hengan.aisearch.service.AIUserService;
import com.hengan.aisearch.vo.ResponseBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", required = true, dataType ="Long")
    @GetMapping("/queryUserById")
    public ResponseBean queryUserById(@RequestParam("userId") Long userId){
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

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
