package com.sprhib.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

import com.sprhib.model.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {
	private static List<Team> teamList = new ArrayList<Team>();
	
	public void addTeam(Team team) {
		teamList.add(team);
	}

	public void updateTeam(Team team) {
		deleteTeam((team.getName()));
		addTeam(team);
	}

	public Team getTeam(String name) {
		for ( Team team : teamList ) {
			if ( name.equalsIgnoreCase(team.getName())) {
				return team;
			}
		}
		
		return null;
	}

	public void deleteTeam(String name) {
		for ( Team team : teamList ) {
			if ( name.equalsIgnoreCase(team.getName())) {
				teamList.remove(team);
			}
		}
	}

	public List<Team> getTeams() {
		return teamList;
	}

}
