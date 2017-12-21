package fr.afgj.coinbot.entity;
// Generated 21 d�c. 2017 09:38:56 by Hibernate Tools 5.1.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ordertype generated by hbm2java
 */
@Entity
@Table(name = "ordertype", schema = "public")
public class OrderType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	private Set<OrderHistoryBot> orderhistorybots = new HashSet<OrderHistoryBot>(0);

	public OrderType() {
	}

	public OrderType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public OrderType(int id, String type, Set<OrderHistoryBot> orderhistorybots) {
		this.id = id;
		this.type = type;
		this.orderhistorybots = orderhistorybots;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "type", nullable = false, length = 25)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordertype")
	public Set<OrderHistoryBot> getOrderhistorybots() {
		return this.orderhistorybots;
	}

	public void setOrderhistorybots(Set<OrderHistoryBot> orderhistorybots) {
		this.orderhistorybots = orderhistorybots;
	}

}
