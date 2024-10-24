package com.dropwizard.gameauth.dao;

import java.util.List;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.dropwizard.gameauth.representations.GameUserInfo;

public class GameUserDB {

    // Using a synchronized map for thread-safety if required
    public static Map<Integer, GameUserInfo> gameUserInfos = Collections.synchronizedMap(new HashMap<>());

    static {
        gameUserInfos.put(1, new GameUserInfo(1, "Lokesh", "Gupta", "India"));
        gameUserInfos.put(2, new GameUserInfo(2, "John", "Gruber", "USA"));
        gameUserInfos.put(3, new GameUserInfo(3, "Melcum", "Marshal", "AUS"));
    }

    // Return the list of game users from the map values
    public static List<GameUserInfo> getGameUsers() {
        // Use ArrayList to store and return the values of the HashMap
        return new ArrayList<>(gameUserInfos.values());
    }

    // Return a single game user by ID
    public static GameUserInfo getGameUser(Integer id) {
        return gameUserInfos.get(id);
    }

    // Update an existing game user or add a new one
    public static void updateGameUser(Integer id, GameUserInfo gameUserInfo) {
        gameUserInfos.put(id, gameUserInfo);
    }

    // Remove a game user by ID
    public static void removeGameUser(Integer id) {
        gameUserInfos.remove(id);
    }
}
