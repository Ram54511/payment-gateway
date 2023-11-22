package com.smartsolution.repositories.user;

import com.smartsolution.entities.Users;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface UserRepository extends PanacheRepository<Users> {

}
