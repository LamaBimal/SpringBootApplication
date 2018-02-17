package com.test.rest.repository;

import com.test.rest.domain.Greeting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bimal on 2/11/18.
 */
public interface GreetingRepository extends CrudRepository<Greeting,Long> {
}
