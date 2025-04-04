package assignment.classes;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class LineItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineitemseq")
	@SequenceGenerator(name = "lineitemseq",sequenceName = "lineitem_seq",allocationSize = 1)
	private int id;
	private int qty;
	
	public LineItem() {}
		
	
	public LineItem( int qty) {
		this.qty=qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LiveItem [id=" + id + ", qty=" + qty + "]";
	}
	
}
