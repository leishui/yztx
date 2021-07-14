package com.example.yztx.repository;

import com.example.yztx.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {}
