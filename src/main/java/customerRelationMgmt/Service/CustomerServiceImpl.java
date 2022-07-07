package customerRelationMgmt.Service;

//Import all required packages
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import customerRelationMgmt.Entity.Customer;


//Class to implement the methods in Customer Service interface
@Repository
public class CustomerServiceImpl {


	//Declaration and initialization of session factory variables 
	private SessionFactory sessionfactory;

	private Session session;


	public CustomerServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;		
		try {
			session=this.sessionfactory.getCurrentSession();

		} catch (HibernateException e) {
			session=this.sessionfactory.openSession();
		}
	}


	//Method to display all customer details
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> findAll()
	{
		List<Customer> customerList=session.createQuery("from Customer").list();
		/*for(Customer c:customerList)
		{
			System.out.println(c);
		}*/
		return customerList;
	}

	//Method to search customer by first name
	@Transactional
	public Customer findByfistName(String firstName)
	{
		Customer customer=session.get(Customer.class, firstName);		
		return customer;
	}

	//Method to save/update customer
	@Transactional
	public void customer(Customer customer)
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(customer);
		tr.commit();
	}

	//Method to delete customer
	@Transactional
	public void delete(Customer c) {
		Transaction tr=session.beginTransaction();
		session.delete(c);
		tr.commit();
	}



	//Method to find customer
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> findByLastName_Email(String lastName, String email) {
		List<Customer> customerList=null;
		String query="";
		if(lastName.length()!=0 && email.length()!=0)
			query="from Customer where lastName like '%"+lastName+"%' and email like '%"+email+"%'";
		else if(lastName.length()==0 && email.length()!=0)
			query="from Customer where author like '%"+email+"%'";
		else if(lastName.length()!=0 && email.length()==0)
			query="from Customer where lastName like '%"+lastName+"%'";
		else
			query="from Customer";
		if(query.length()!=0)
		{
			customerList=session.createQuery(query).list();
		}
		return customerList;
	}



}
