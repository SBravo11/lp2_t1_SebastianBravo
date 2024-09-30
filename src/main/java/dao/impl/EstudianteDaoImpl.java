package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dao.EstudianteDao;
import entity.EstudianteEntity;

public class EstudianteDaoImpl implements EstudianteDao{

	private EntityManager entityManager;
	
	public EstudianteDaoImpl() {
		entityManager = Persistence.createEntityManagerFactory("LP2_T1").createEntityManager();
	}
	
	@Override
	public void crearEstudiante(EstudianteEntity entity) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
	}
	
	@Override
	public void actualizarEstudiante(EstudianteEntity entity) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().	begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
	}

	@Override
	public List<EstudianteEntity> buscarTodos() {
		String query = "SELECT u FROM EstudianteEntity u";
		List<EstudianteEntity> lista = entityManager.createQuery(query, EstudianteEntity.class).getResultList();
		for(EstudianteEntity estu: lista) {
			System.out.println(estu);
		}
		return lista;
	}
	
	@Override
	public EstudianteEntity buscarEstudiantePorId(String dni) {
		// TODO Auto-generated method stub
		EstudianteEntity estudianteEncontrado = entityManager.find(EstudianteEntity.class, dni);
		System.out.println(estudianteEncontrado);
		return estudianteEncontrado;
	}

	@Override
	public List<EstudianteEntity> buscarEstudiantePorCodAlu(String cod) {
		// TODO Auto-generated method stub
		String queryString = "SELECT u FROM EstudianteEntity u WHERE u.codAlumno = :codEstu";
		TypedQuery<EstudianteEntity> query = entityManager.createQuery(queryString, EstudianteEntity.class);
		query.setParameter("codEstu", cod);
		List<EstudianteEntity> lista = query.getResultList();
		for(EstudianteEntity estu: lista) {
			System.out.println(estu);
		}
		return lista;
	}

	@Override
	public List<EstudianteEntity> buscarEstudiantePorPerfilId(int id) {
		// TODO Auto-generated method stub
		String queryString = "SELECT u FROM EstudianteEntity u WHERE u.perfilEntity = :perfilEstu";
		TypedQuery<EstudianteEntity> query = entityManager.createQuery(queryString, EstudianteEntity.class);
		query.setParameter("perfilEstu", id);
		List<EstudianteEntity> lista = query.getResultList();
		for(EstudianteEntity estu: lista) {
			System.out.println(estu);
		}
		return lista;
	}
	
	
	@Override
	public void eliminarEstudiantePorDni(String dni) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			EstudianteEntity estudianteEncontrado = buscarEstudiantePorId(dni);
			if(estudianteEncontrado != null) {
				entityManager.remove(estudianteEncontrado);
				entityManager.getTransaction().commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
	}	
}
