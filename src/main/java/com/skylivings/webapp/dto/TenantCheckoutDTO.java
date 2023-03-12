package com.skylivings.webapp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TenantCheckoutDTO {
	private int tenantId;
	private int propertyId;
	private int roomId;
	private Date checkOutDate;
	private String remarks;
}
