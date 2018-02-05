package com.test.rest.repository;

import com.test.rest.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bimal on 2/5/18.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
