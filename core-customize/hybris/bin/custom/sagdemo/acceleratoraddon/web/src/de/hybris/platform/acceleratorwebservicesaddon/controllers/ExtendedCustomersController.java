package de.hybris.platform.acceleratorwebservicesaddon.controllers;

/**
 * Controller which extends Customer Resources
 */
@Controller("sampleExtendedCustomerController")
@RequestMapping(value = "/{baseSiteId}/customers")
public class ExtendedCustomersController 
{
	@Secured("ROLE_CUSTOMERGROUP")
	@RequestMapping(value = "/current/nickname", method = RequestMethod.GET)
	@ResponseBody		
	public String getCustomerNickname()
	{
		final String name = getCustomerFacade().getCurrentCustomer().getNickname();
		return name;
	}

	@Secured("ROLE_CUSTOMERGROUP")
	@RequestMapping(value = "/current/nickname", method = RequestMethod.PUT)
	@ResponseBody
	public CustomerData setCustomerNickname(@RequestParam final String nickname) throws DuplicateUidException
	{
		final CustomerData customer = customerFacade.getCurrentCustomer();
		customer.setNickname(nickname);
		customerFacade.updateFullProfile(customer);
		return customerFacade.getCurrentCustomer();
	}
	
	@RequestMapping(value = "/testResource", method = RequestMethod.GET)
	@ResponseBody
	public String getTestResource() {
		return "Hello! This is a test resource output";
	}

}