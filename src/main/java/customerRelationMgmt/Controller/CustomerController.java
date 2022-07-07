package customerRelationMgmt.Controller;

//Import all the required packages

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import customerRelationMgmt.Entity.Customer;
import customerRelationMgmt.Service.CustomerService;

//Annotation for Controller Class
@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired /*spring managed */
	private CustomerService customerService;

	//Method to dispay all Customers
	@RequestMapping("/list")
	public String findAll(Model model)
	{
		List<Customer> customerList=customerService.findAll() ;
		model.addAttribute("books", customerList);
		return "Customers";
	}

	//Method to save customer details
	@RequestMapping("/save")
	public String save(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,
			@RequestParam("category") String category)
	{
		Customer c=null;
		if(firstName!=null)
		{
			c=customerService.findByfirstName(firstName);
			c.setLastName(lastName);
			c.setEmail(email);
		}
		else
			c=new Customer(firstName,lastName, email);

		customerService.save(c);
		return "redirect:list";
	}


	//Method to add customer details
	@RequestMapping("/addCustomer")
	public String addBook(@RequestParam("firstName") String firstName, Model model)
	{


		if(firstName!=null)
		{
			Customer c=customerService.findByfirstName(firstName);
			model.addAttribute("customer", c);
		}
		else
		{
			Customer c =new Customer();
			c.setFirstName(null);
			model.addAttribute("customer", c);
		}

		return "CustomerForm";
	}


	//Method to delete customer
	@RequestMapping("/deleteCustomer")
	public String delete(@RequestParam("firstName") String firstName)
	{
		Customer c=null;
		if(firstName!=null)
		{
			c=customerService.findByfirstName(firstName);
			customerService.delete(c);
		}

		return "redirect:list";
	}

	//Method to search customer
	@RequestMapping("/search")
	public String findByLastName_Email(@RequestParam("lastName")String lastName, @RequestParam("email") String email,Model model)
	{
		List<Customer> customerList=customerService.findByLastName_Email(lastName,email) ;
		System.out.println(customerList);
		if(customerList.size()!=0)
			model.addAttribute("customers", customerList);
		else
			model.addAttribute("error", "No Customers Found");
		return "Customers";
	}


}
