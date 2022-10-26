package com.tkluza.smartcity.smartmobility.business.user.domain;

import com.tkluza.smartcity.smartmobility.business.user.domain.service.UserService;
import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class UserFacadeAdapter implements UserFacade {

    private final UserService userService;

    @Override
    public List<UserQuery> findAllUsers() {
        return userService.findAll();
    }
}
