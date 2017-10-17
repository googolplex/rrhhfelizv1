package biz.lcompras.model;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="RRHH_HORASLABORABLES"
 , uniqueConstraints={
        @UniqueConstraint(name="HLA_PERIODO_DUPLICADO", columnNames={"HLA_YYYYMM"})       
 }
)
public class HorasLaborables extends SuperClaseFeliz {

	@Required
	@Range(min=0,max=9999)
	@Column(name="HLA_YYYY",length=4,nullable=false)
	//@DefaultValueCalculator(CeroFelizLong.class)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	private Long yyyy ;

	@Required
	@Range(min=1,max=12)
	@Column(name="HLA_MM",length=2,nullable=false)
	@DefaultValueCalculator(CeroFelizLong.class)
	private Long mes ;
	
	@Hidden
	@Column(length=10,nullable=true,name="HLA_YYYYMM")
	@DefaultValueCalculator(CeroFelizLong.class)
	private Long yyyymm ;

	@Required
	@Range(min=0) // lo dejo provisoriamente
	@Column(name="HLA_QHORAS",length=10,nullable=false)
	@DefaultValueCalculator(CeroFelizDouble.class)
	private Double qhoras ;
	
	
	public Double getQhoras() {
		return qhoras;
	}

	public void setQhoras(Double qhoras) {
		this.qhoras = qhoras;
	}

	public Long getYyyy() {
		return yyyy;
	}

	public void setYyyy(Long yyyy) {
		this.yyyy = yyyy;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Long getYyyymm() {
		return yyyymm;
	}


	public void setYyyymm(Long yyyymm) {
		this.yyyymm = yyyymm;
	}


	private void camposCalculados () {
		this.setYyyymm(this.yyyy * 100 + this.mes);
	}
	
	
	@PrePersist
	private void antesDeGrabar() {
		this.camposCalculados();
	}
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
			this.camposCalculados();
	}	
	
}
