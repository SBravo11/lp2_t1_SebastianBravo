package dao;

import java.util.List;

import entity.EstudianteEntity;

public interface EstudianteDao {

	void crearEstudiante(EstudianteEntity entity);
	void actualizarEstudiante(EstudianteEntity entity);
	void eliminarEstudiantePorDni(String dni);
	EstudianteEntity buscarEstudiantePorId(String dni);
	List<EstudianteEntity> buscarTodos();
	List<EstudianteEntity> buscarEstudiantePorCodAlu(String cod);
	List<EstudianteEntity> buscarEstudiantePorPerfilId(int id);
}
