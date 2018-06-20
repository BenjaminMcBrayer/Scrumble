package com.gc.scrumble.oops.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gc.scrumble.oops.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	<S extends User> S save(S entity);
	Optional<User> findByUsername(String username);
	
}
