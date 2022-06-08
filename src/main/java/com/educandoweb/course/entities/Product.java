package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String decription;
	private Double price;
	private String imgUrl;
	
	/*Set representa um conjunto para garantir que eu não vou ter um produto
	 *com mais de uma ocorrencia da mesma categoria, um mesmo produto não
	 *pode ter mais de uma categoria 
	 *E foi instanciado para garantir que a coleção categoria não inicie valendo Nula,
	 *ela tem que começar vazia, porém instanciada
	 *Por que usar o HashSet? pois o Set é uma interface e não pode ser instanciado
	 * ai utiliza a Classe HashSet correspondente a essa interface
	 * Da mesma forma quando utilizamos o LIST instanciamos com o ArrayList.. 
	 * Essa parte faz conexão entre 2 entidades e no caso */
	  /*@Transient Essa Anotation da JPA impede que JPA tente interpretar essa parte*/
	@ManyToMany
	@JoinTable(name = "tb_product_category", 
	joinColumns = @JoinColumn(name = "product_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	public Product() {
	}

	public Product(Long id, String name, String decription, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.decription = decription;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	

	
	

}
