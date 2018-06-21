package com.gc.scrumble.oops.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.scrumble.oops.entity.Rootword;

@Repository
public interface RootwordsRepository extends JpaRepository<Rootword, Long> {
	Optional<Rootword> findByWordname(String wordname);
}
