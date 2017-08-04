package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOC_ID")
	private long locationId;
	
	@Column(name="LOC_NAME", length=10)
	private String locationName;

	@Column(name="PINCODE", length=6)
	private String pincode;
	
	@Column(name="ADDRESS", length=100)
	private String address;
}
