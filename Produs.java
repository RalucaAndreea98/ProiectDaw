package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class Produs {
private Long id;
private String nume;
private String producator;
private float pret;
public Produs() {
	super();
	
}
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getProducator() {
	return producator;
}
public void setProducator(String producator) {
	this.producator = producator;
}
public float getPret() {
	return pret;
}
public void setPret(float pret) {
	this.pret = pret;
}

}
