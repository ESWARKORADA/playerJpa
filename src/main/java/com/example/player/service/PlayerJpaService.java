package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;

@Service
public class PlayerJpaService implements PlayerRepository {
	@Autowired
	private PlayerJpaRepository playerJpaRepository;

	@Override
	public ArrayList<Player> getPlayers() {
		List<Player> listPlayer = playerJpaRepository.findAll();
		ArrayList<Player> arrList = new ArrayList<>(listPlayer);
		return arrList;
	}

	@Override
	public Player getPlayerById(int playerId) {
		try {
			Player player = playerJpaRepository.findById(playerId).get();
			return player;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Player addPlayer(Player player) {
		playerJpaRepository.save(player);
		return player;
	}

	@Override
	public Player updatePlayer(Player player, int playerId) {
		try {
			Player newPlayer = playerJpaRepository.findById(playerId).get();

			if (player.getPlayerName() != null) {
				newPlayer.setPlayerName(player.getPlayerName());
			}

			if (player.getJerseyNumber() != 0) {
				newPlayer.setJerseyNumber(player.getJerseyNumber());
			}

			if (player.getRole() != null) {
				newPlayer.setRole((player.getRole()));
			}

			return playerJpaRepository.save(newPlayer);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deletePlayer(int playerId) {
		try {
			playerJpaRepository.deleteById(playerId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
