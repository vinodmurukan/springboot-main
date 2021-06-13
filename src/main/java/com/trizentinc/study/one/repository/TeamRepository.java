package com.trizentinc.study.one.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trizentinc.study.one.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByPlayers(long playerId);
}
