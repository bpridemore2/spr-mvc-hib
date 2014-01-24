package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Team;

public interface TeamDAO {
	
	public void addTeam(Team team);
	public void updateTeam(Team team);
	public Team getTeam(String name);
	public void deleteTeam(String name);
	public List<Team> getTeams();

}
