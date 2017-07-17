package org.silab.expertsystem.db.dao;

import java.util.List;

import org.silab.expertsystem.db.broker.DBSession;
import org.silab.expertsystem.model.Player;

public class PlayerDaoImpl extends AbstractDao<Player> implements PlayerDao{

	public PlayerDaoImpl(DBSession session) {
		super(session);
	}

	@Override
	public List<Player> getPlayers() {
		return getAll();
	}

	
}
