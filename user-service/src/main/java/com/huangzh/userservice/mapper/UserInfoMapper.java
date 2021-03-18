package com.huangzh.userservice.mapper;

import com.huangzh.userservice.model.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}