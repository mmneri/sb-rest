package org.france.players.controller;

import java.util.ArrayList;

import org.france.players.model.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

	private ArrayList<Player> players;

	public PlayerController() {
		this.players = new ArrayList<Player>();
		this.players.add(new Player(1, 10, "Kylian Mbappé", 19, "PSG", "Attaquant",
				"https://www.fupa.net/fupa/images/photo/big/kylian-mbappe-878771_2.jpg"));
	}

	@GetMapping("/players")
	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	@GetMapping("/player/{id}")
	public Player getPlayer(@PathVariable int id) {
		return this.players.get(id);
	}
}
