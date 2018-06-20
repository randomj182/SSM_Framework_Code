package com.random.springtranscation.vo;
/**
 * 数据表account表的vo对象
 * @author random
 *
 */
public class Account {
	// 自增长id
	private Integer id;
	// 账户名
	private String name;
	// 金额
	private Double money;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, String name, Double money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
	
	
}
