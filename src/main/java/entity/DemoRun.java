package entity;

import java.util.Date;

import dao.impl.EstudianteDaoImpl;
import dao.impl.PerfilDaoImpl;

public class DemoRun {

	public static void main(String[] args) {
		//EntityManager entityManager = Persistence.createEntityManagerFactory("LP2_T1").createEntityManager();
		EstudianteDaoImpl daoEstu = new EstudianteDaoImpl();
		PerfilDaoImpl daoPerfil = new PerfilDaoImpl();
		
		/*
		 * Date fechaNaci = new Date(10-10-2020); EstudianteEntity objEstudiante = new
		 * EstudianteEntity(); objEstudiante.setDni("87456321");
		 * objEstudiante.setCodAlumno("ALU002"); objEstudiante.setNombres("Jose");
		 * objEstudiante.setApellidos("Perez");
		 * objEstudiante.setFechaNacimiento(fechaNaci);
		 * objEstudiante.setPerfilEntity(daoPerfil.buscarPerfilPorId(2));
		 * 
		 * daoEstu.crearEstudiante(objEstudiante);
		 */
		
		// daoEstu.eliminarEstudiantePorDni("87456321");
		
		/*
		 * Date fechaNaci = new Date(10-10-2020); EstudianteEntity objEstudiante = new
		 * EstudianteEntity(); objEstudiante.setDni("87456321");
		 * objEstudiante.setCodAlumno("ALU003"); objEstudiante.setNombres("Sebastian");
		 * objEstudiante.setApellidos("Ramos");
		 * objEstudiante.setFechaNacimiento(fechaNaci);
		 * objEstudiante.setPerfilEntity(daoPerfil.buscarPerfilPorId(2));
		 * 
		 * daoEstu.actualizarEstudiante(objEstudiante);
		 */
		
		// daoEstu.buscarEstudiantePorCodAlu("ALU003");
		// daoEstu.buscarEstudiantePorId("12345678");
		daoEstu.buscarEstudiantePorPerfilId(2);
	}
}
