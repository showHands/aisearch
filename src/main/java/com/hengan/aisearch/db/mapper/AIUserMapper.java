package com.hengan.aisearch.db.mapper;

import com.hengan.aisearch.db.schema.AIUser;
import java.util.List;

public interface AIUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AIUser record);

    AIUser selectByPrimaryKey(Long userId);

    List<AIUser> selectAll();

    int updateByPrimaryKey(AIUser record);
}