package com.trizentinc.study.one.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trizentinc.study.one.model.Player;
import com.trizentinc.study.one.model.Team;
import com.trizentinc.study.one.repository.PlayerRepository;
import com.trizentinc.study.one.repository.TeamRepository;

@Service
public class SoccerServiceImpl implements SoccerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<String> getAllTeamPlayers(long teamId) {
        List<String> result = new ArrayList<String>();
        List<Player> players = playerRepository.findByTeamId(teamId);
        for (Player player : players) {
            result.add(player.getName());
        }

        return result;
    }

    public void addBarcelonaPlayer(String name, String position, int number) {

        Team barcelona = teamRepository.findOne(1l);

        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);
        playerRepository.save(newPlayer);
    }
}