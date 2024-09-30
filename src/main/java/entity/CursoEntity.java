package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "curso")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CursoEntity {

	@Id
	@Column(name = "curso_id")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cursoId;
	
	@Column(name = "cod_curso", nullable = false, columnDefinition = "CHAR(4)")
	private String codCurso;
	
	@Column(name = "nombre_curso", nullable = false, length = 45)
	private String nombreCurso;
	
	@Column(nullable = false, length = 45)
	private String ciclo;
	
	@ManyToMany(mappedBy = "cursos")
	private Set<EstudianteEntity> estudiantes = new HashSet<EstudianteEntity>();
}
