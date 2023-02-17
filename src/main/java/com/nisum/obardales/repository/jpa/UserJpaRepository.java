package com.nisum.obardales.repository.jpa;

import com.nisum.obardales.repository.UserRepository;
import com.nisum.obardales.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String>, UserRepository {


}
