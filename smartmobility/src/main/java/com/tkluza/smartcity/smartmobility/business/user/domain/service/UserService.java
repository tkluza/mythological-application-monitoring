package com.tkluza.smartcity.smartmobility.business.user.domain.service;

import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;

import java.util.List;

public interface UserService {

    List<UserQuery> findAll();
}
