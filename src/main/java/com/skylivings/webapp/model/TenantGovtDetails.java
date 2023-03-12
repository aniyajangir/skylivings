package com.skylivings.webapp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class TenantGovtDetails{
	  @Id
	  private int govtId;
	  private String aadharNumber;
	  private String panNumber;
	  private String passportNumber;
	  private Date passportExpiryDate;
	  private String visaNumber;
	  private Date visaExpiryDate;
	  private String visaType;
	  private String nationality;
}
