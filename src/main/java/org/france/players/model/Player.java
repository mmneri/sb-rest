package org.france.players.model;

import java.util.Objects;

public class Player {
	private int id;
	private int numero;
	private String nom;
	private int age;
	private String equipe;
	private String poste;
	private String photoURL;

	public Player(int id, int numero, String nom, int age, String equipe, String poste, String photoURL) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.age = age;
		this.equipe = equipe;
		this.poste = poste;
		this.photoURL = photoURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero, nom, age, equipe, poste, photoURL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (equipe == null) {
			if (other.equipe != null)
				return false;
		} else if (!equipe.equals(other.equipe))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numero != other.numero)
			return false;
		if (photoURL == null) {
			if (other.photoURL != null)
				return false;
		} else if (!photoURL.equals(other.photoURL))
			return false;
		if (poste == null) {
			if (other.poste != null)
				return false;
		} else if (!poste.equals(other.poste))
			return false;
		return true;
	}

}
