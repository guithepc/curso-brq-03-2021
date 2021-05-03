package br.com.brq.camel.covid;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "covid")
public class UfCovidModel {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "covid_seq_id")
	@SequenceGenerator ( name = "covid_seq_id" , sequenceName = "covid_seq_id", allocationSize = 1 )
	@Column(name = "id")
	private Integer uid;
	
	private String uf;
	private String state;
	private Integer cases;		
	private int deaths;
	private Integer suspects;
	private Integer refuses;
	
	@Column(name = "date_covid")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
}