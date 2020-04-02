package com.ecom.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.ecom.model.User;

@Repository
public interface userRepository extends JpaRepositoryImplementation<User,Long> {

}
