package com.tkluza.smartcity.smartmobility.business.user.domain.service.adapter;

import com.tkluza.smartcity.smartmobility.business.user.domain.mapper.UserMapper;
import com.tkluza.smartcity.smartmobility.business.user.domain.repository.UserRepository;
import com.tkluza.smartcity.smartmobility.business.user.domain.service.UserService;
import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;

import java.util.List;

public record UserServiceAdapter(
        UserRepository userRepository,
        UserMapper userMapper
) implements UserService {

    @Override
    public List<UserQuery> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .toList();
    }
}
