package com.validation;

import com.exception.CustomeException;

public class ValidationException {

    public static void validateBusId(int busId)
            throws CustomeException {

        if(busId <= 0)
            throw new CustomeException("Invalid Bus Id");
    }

    public static void validateFare(double fare)
            throws CustomeException {

        if(fare <= 0)
            throw new CustomeException("Invalid Fare");
    }

    public static void validateCustomerName(String name)
            throws CustomeException {

        if(name.length() < 3)
            throw new CustomeException("Invalid Customer Name");
    }
}