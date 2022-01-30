package com.te.assignmentmvc.base.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class ProductId  implements Serializable{
   @Id	
   private int id;
   private String password;
   
   @OneToOne(cascade =  CascadeType.ALL)
   private ProductDetails pDetails;
}
