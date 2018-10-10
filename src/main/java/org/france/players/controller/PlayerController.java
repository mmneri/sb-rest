package org.france.players.controller;

import java.util.ArrayList;

import org.france.players.model.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final ArrayList<Player> players;

    public PlayerController() {
        this.players = new ArrayList<Player>();
        this.players.add(new Player(1, 10, "Kylian Mbappé", 19, "PSG", "Attaquant",
                        "https://www.fupa.net/fupa/images/photo/big/kylian-mbappe-878771_2.jpg"));
        this.players.add(new Player(2, 6, "Paul Pgba", 25, "Manchester united", "Milieu terrain",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Paul_Pogba_in_2018.jpg/275px-Paul_Pogba_in_2018.jpg"));
    }

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable final int id) {
        return this.players.get(id);
    }
}
