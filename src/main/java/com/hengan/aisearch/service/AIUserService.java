package com.hengan.aisearch.service;

import com.hengan.aisearch.db.schema.AIUser;

/**
 * Created by wangxiaotao on 2018/12/21.
 */
public interface AIUserService {

    AIUser queryByUserId(Long userId);

    void deleteByUserId(Long userId);

    void updateUserInfo(AIUser aiUser);
}
