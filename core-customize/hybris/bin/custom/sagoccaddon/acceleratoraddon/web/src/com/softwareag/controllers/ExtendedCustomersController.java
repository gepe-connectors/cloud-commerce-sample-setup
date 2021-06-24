import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import org.springframework.security.access.annotation.Secured;

/**
 * Controller which extends Customer Resources
 */
@Controller("sampleExtendedCustomerController")
@RequestMapping(value = "/{baseSiteId}/customers")
public class ExtendedCustomersController 
{
	private CustomerFacade customerFacade;
	
	protected CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

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
		CustomerFacade customerFacade = getCustomerFacade();
		final CustomerData customer = customerFacade.getCurrentCustomer();
		customer.setNickname(nickname);
		customerFacade.updateFullProfile(customer);
		return customerFacade.getCurrentCustomer();
	}

}