package factory;

import interfaces.ICustomerService;
import interfaces.ILoggerService;

import service.CustomerService;

public class CustomerServiceFactory {

    public ICustomerService getICustomerService(String serviceName){

        if (serviceName == null){
            return null;
        }

        if (serviceName.equalsIgnoreCase("CustomerService")){
            return CustomerService.getInstance();
        }
        return null;
    }
}
