package demo.ongl;

import demo.domain.Address;
import demo.domain.Customer;
import ognl.*;

import java.util.ArrayList;

public class ONGLDemo {
    private static Customer customer;
    private static OgnlContext context;

    private static Customer createCustomer() {
        customer = new Customer();
        customer.setId(1);
        customer.setName("Test Customer");
        customer.setPhone("1234567");
        Address address = new Address();
        address.setCity("city-001");
        address.setId(1);
        address.setCountry("country-001");
        address.setStreet("street-001");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        customer.setAddresses(addresses);
        return customer;
    }

    public static void main(String[] args) throws OgnlException {
        customer = createCustomer();

        // create ONGL context
        context = new OgnlContext(new DefaultClassResolver(), new DefaultTypeConverter(), new DefaultMemberAccess(true));

        context.setRoot(customer);

        context.put("address", customer.getAddresses().get(0));

        Object obj = Ognl.getValue(Ognl.parseExpression("addresses"), context, context.getRoot());
        System.out.println(obj);

        obj = Ognl.getValue(Ognl.parseExpression("addresses[0].city"), context, context.getRoot());
        System.out.println(obj);

        // #address 表示访问的不是 root对象，而是 Ognl context 中 key 为 addresses 对象
        obj = Ognl.getValue(Ognl.parseExpression("#address.city"), context, context.getRoot());
        System.out.println(obj);

        obj = Ognl.getValue(Ognl.parseExpression("getName()"), context, context.getRoot());
        System.out.println(obj);
    }

}
