package com.random.spring.bean.bothXMLandAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CustomerService {
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Autowired
    @Qualifier("orderDAO")
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerDAO=" + customerDAO +
                ", orderDAO=" + orderDAO +
                '}';
    }
}
