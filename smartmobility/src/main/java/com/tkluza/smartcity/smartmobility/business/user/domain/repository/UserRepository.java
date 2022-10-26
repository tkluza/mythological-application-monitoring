package com.tkluza.smartcity.smartmobility.business.user.domain.repository;

import com.tkluza.smartcity.smartmobility.business.user.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
