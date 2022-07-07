package customerRelationMgmt.Service;

import java.util.List;

import customerRelationMgmt.Entity.Customer;

public interface CustomerService {

	//Declaration of methods in interface
	public List<Customer> findAll();
	public void save(Customer c);
	public Customer findByfirstName(String firstName);
	public void delete(Customer c);
	public List<Customer> findByLastName_Email(String lastName, String email);
}
