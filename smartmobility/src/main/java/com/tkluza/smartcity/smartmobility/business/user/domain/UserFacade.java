package com.tkluza.smartcity.smartmobility.business.user.domain;

import com.tkluza.smartcity.smartmobility.business.user.dto.query.UserQuery;

import java.util.List;

/**
 * Main entry point to User domain.
 */
public interface UserFacade {

    /**
     * Finds list of all users.
     *
     * @return users
     */
    List<UserQuery> findAllUsers();
}
