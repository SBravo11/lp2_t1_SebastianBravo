package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credenciales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CredencialesEntity {
	
	@Id
	@Column(columnDefinition = "CHAR(8)")
	private String dniEstudiante;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "estudiante_dni")
	private EstudianteEntity estudianteEntity;
	
	@Column(nullable = false, length = 45)
	private String correo;
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1)")
	private String estado;
}
