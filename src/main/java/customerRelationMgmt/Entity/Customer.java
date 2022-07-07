package customerRelationMgmt.Entity;

//Import all the required packages
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Annotation for Entity Class
@Entity
@Table(name="customer")

public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Declaration of Fields
	private String firstName;
	private String lastName;
	private String email;
	//Getter & Setter Methods
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Parameterized constructor
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer Details: \nFirstName: "+firstName+"\nLastName: "+lastName+"\nEmail: "+email;
	}

}
