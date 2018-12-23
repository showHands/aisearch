package com.hengan.aisearch.service.impl;

import com.hengan.aisearch.db.mapper.AIUserMapper;
import com.hengan.aisearch.db.schema.AIUser;
import com.hengan.aisearch.service.AIUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangxiaotao on 2018/12/21.
 */
@Slf4j
@Service
public class AIUserServiceImpl implements AIUserService{

    @Resource
    AIUserMapper aiUserMapper;

    @Cacheable(value = "user", key = "#userId", unless = "#result eq null")
    public AIUser queryByUserId(Long userId) {
        return aiUserMapper.selectByPrimaryKey(userId);
    }

    @CacheEvict(value = "user", key = "#userId")
    public void deleteByUserId(Long userId) {
        aiUserMapper.deleteByPrimaryKey(userId);
    }

    @CachePut(value = "user", key = "#aiUser.userId")
    public void updateUserInfo(AIUser aiUser) {
        aiUserMapper.updateByPrimaryKey(aiUser);
    }


}
