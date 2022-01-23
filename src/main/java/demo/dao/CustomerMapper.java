package demo.dao;

import demo.domain.Customer;

public interface CustomerMapper {

    Customer find(long id);

    Customer findWithAddress(long id);

    Customer findWithOrderId(long orderId);


}
