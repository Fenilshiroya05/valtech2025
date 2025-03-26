package com.valtech.training.springwebassignment.models;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private String desc;
	private int currentQty;
	private int maxQty;
	private int reorderQty;
	
	@OneToMany(mappedBy = "item",targetEntity = LineItem.class,fetch = FetchType.LAZY)
	private List<LineItem> lineItems;

	public Item() {}

	public Item(long id, String name, String desc, int currentQty, int maxQty, int reorderQty) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.currentQty = currentQty;
		this.maxQty = maxQty;
		this.reorderQty = reorderQty;
	}

	public void addLineItem(LineItem lm) {
		if(lineItems==null) lineItems = new ArrayList<LineItem>();
		lineItems.add(lm);
		lm.setItem(this);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(int currentQty) {
		this.currentQty = currentQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}
	
	
	
}
