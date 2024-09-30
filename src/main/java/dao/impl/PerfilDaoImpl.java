package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.PerfilDao;
import entity.PerfilEntity;

public class PerfilDaoImpl implements PerfilDao{

	private EntityManager entityManager;
	public PerfilDaoImpl() {
		entityManager = Persistence.createEntityManagerFactory("LP2_T1").createEntityManager();
	}
	
	@Override
	public PerfilEntity buscarPerfilPorId(int id) {
		// TODO Auto-generated method stub
		PerfilEntity perfilEncontrado = entityManager.find(PerfilEntity.class, id);
		System.out.println(perfilEncontrado);
		return perfilEncontrado;
	}

}
