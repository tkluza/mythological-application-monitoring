package com.tkluza.smartcity.smartmobility.business.user.config;

import com.tkluza.smartcity.smartmobility.business.user.domain.UserFacade;
import com.tkluza.smartcity.smartmobility.business.user.domain.UserFacadeAdapter;
import com.tkluza.smartcity.smartmobility.business.user.domain.mapper.UserMapper;
import com.tkluza.smartcity.smartmobility.business.user.domain.repository.UserRepository;
import com.tkluza.smartcity.smartmobility.business.user.domain.service.UserService;
import com.tkluza.smartcity.smartmobility.business.user.domain.service.adapter.UserServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserFacade userFacade(UserRepository userRepository) {
        UserService userService = new UserServiceAdapter(
                userRepository,
                new UserMapper()
        );

        return new UserFacadeAdapter(userService);
    }
}
