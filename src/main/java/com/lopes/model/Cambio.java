package com.lopes.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cambio")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cambio implements Serializable {
	 
	private static final long serialVersionUID = -3243179210038650890L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "from_currency", nullable = false, length = 3)
	private String from;
	@Column(name = "to_currency", nullable = false, length = 3)
	private String to;
	@Column(name = "conversion_factor", nullable = false)
	private BigDecimal conversionFactor;
	
	@Transient
	private BigDecimal convertedValue;
	@Transient
	private String enviroment; 

}
