package com.chandkhat.ecommerce.web.order;

public class AddressService {

    public static AddressDto mapToDto(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDto(
                address.getAddress1(),
                address.getAddress2(),
                address.getCity(),
                address.getPostcode(),
                address.getCountry()
        );

    }
}
