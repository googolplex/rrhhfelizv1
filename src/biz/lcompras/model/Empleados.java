package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="RRHH_EMPLEADOS"
 , uniqueConstraints={
        @UniqueConstraint(name="EMP_CODIGO_DUPLICADO", columnNames={"EMP_CODIGO"})
        , @UniqueConstraint(name="EMP_NOMBRE_DUPLICADO", columnNames={"EMP_NOMBRE"})        
 }
)
public class Empleados extends SuperClaseFeliz {

	@Required
	@Pattern(regexp="^[0-9]+$",message="No es un numero tipo CI NNNNNNNNN ")
	@Column(length=20,nullable=false,name="EMP_CODIGO")		
	private String empCodigo;
	@Required
	@Column(length=80,nullable=false,name="EMP_NOMBRE")		
	private String empNombre;

	
	public String getempCodigo() {
		return empCodigo;
	}

	public void setempCodigo(String empCodigo) {
		this.empCodigo = empCodigo.toUpperCase().trim();
	}

	public String getempNombre() {
		return empNombre;
	}



	public void setempNombre(String empNombre) {
		this.empNombre = empNombre.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}