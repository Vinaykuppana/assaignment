package com.te.assignmentmvc.base.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class ProductDetails implements Serializable {
	@Id
	@Column(name="productId")
	private int id;
	private int price;
	private String name;
	private String company;

	@OneToOne(mappedBy = "pDetails", cascade = CascadeType.ALL)
	private ProductId pId;

}
