package com.example.player.repository;

import java.util.*;
import com.example.player.model.Player;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player getPlayerById(int playerId);

    Player addPlayer(Player player);

    Player updatePlayer(Player player, int playerId);

    void deletePlayer(int playerId);
}
