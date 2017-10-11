package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="RRHH_FUNCIONES"
 , uniqueConstraints={
        @UniqueConstraint(name="FUN_CODIGO_DUPLICADO", columnNames={"FUN_CODIGO"})
        , @UniqueConstraint(name="FUN_FUNCION_DUPLICADO", columnNames={"FUN_FUNCION"})        
 }
)
public class Funciones extends SuperClaseFeliz {

	@Required
	@Pattern(regexp="^[0-9]+$",message="No es un numero tipo NNNNNNNNN ")
	@Column(length=20,nullable=false,name="FUN_CODIGO")		
	private String funCodigo;
	@Required
	@Column(length=80,nullable=false,name="FUN_FUNCION")		
	private String funFuncion;

	
	public String getfunCodigo() {
		return funCodigo;
	}

	public void setfunCodigo(String funCodigo) {
		this.funCodigo = funCodigo.toUpperCase().trim();
	}

	public String getfunFuncion() {
		return funFuncion;
	}



	public void setfunFuncion(String funFuncion) {
		this.funFuncion = funFuncion.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}
