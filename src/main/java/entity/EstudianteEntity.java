package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tb_estudiante")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudianteEntity {

	@Id
	@Column(columnDefinition = "CHAR(8)", nullable = false)
	private String dni;
	
	@Column(name = "cod_alumno", nullable = false, length = 6, unique = true)
	private String codAlumno;
	
	@Column(nullable = false, length = 45)
	private String nombres;
	
	@Column(nullable = false, length = 45)
	private String apellidos;
	
	@Column(name = "fecha_nacimiento",
			nullable = false,
			updatable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	public EstudianteEntity(String dni, String codAlumno, String nombres, String apellidos, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	@ManyToOne
	@JoinColumn(name = "perfil_id", nullable = false)
	private PerfilEntity perfilEntity;
	
	@OneToOne(mappedBy = "estudianteEntity")
	private CredencialesEntity credencialesEntity;
	
	@ManyToMany
	@JoinTable(name = "estudiante_curso", joinColumns = @JoinColumn(name = "tb_estudiante_dni"), 
	inverseJoinColumns = @JoinColumn(name = "curso_curso"))
	private Set<CursoEntity> cursos = new HashSet<CursoEntity>();

	@Override
	public String toString() {
		return "EstudianteEntity [dni=" + dni + ", codAlumno=" + codAlumno + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", fechaNacimiento=" + fechaNacimiento + ", perfilEntity=" + perfilEntity
				+ ", credencialesEntity=" + credencialesEntity + ", cursos=" + cursos + "]";
	}
	
	
}
