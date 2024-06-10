package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.player.service.PlayerJpaService;
import com.example.player.model.Player;

@RestController
public class PlayerController {
    @Autowired
    public PlayerJpaService playerService;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/players/{playerId}")

    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/players")

    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")

    public Player updatePlayer(@RequestBody Player player, @PathVariable("PlayerId") int playerId) {
        return playerService.updatePlayer(player, playerId);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerService.deletePlayer(playerId);
    }

}