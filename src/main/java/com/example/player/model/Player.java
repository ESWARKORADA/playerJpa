package com.example.player.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "team")

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid")
    private int playerId;

    @Column(name = "playername")
    private String playerName;

    @Column(name = "jerseyNumber")
    private int jerseyNumber;

    @Column(name = "role")
    private String role;

    public Player() {
    }

    public Player(int playerId, String playerName, int jerseyNumber, String role) {

        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int id) {
        this.playerId = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int num) {
        this.jerseyNumber = num;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}