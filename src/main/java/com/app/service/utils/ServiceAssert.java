package com.app.service.utils;

import com.app.exceptions.ResourceNotFoundException;
import org.apache.commons.lang.ObjectUtils;

/**
 * Helper class for business asserts
 */
public class ServiceAssert {
    private ServiceAssert() {}

    /**
     * Asserts that the object is not null.
     * @throws ResourceNotFoundException
     */
    public static void notNull(Object o) {
        if(o == null) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Asserts that the object is not null. Throws formatted exception.
     * @throws ResourceNotFoundException
     */
    public static void notNull(Object o, Class clazz, Object id) {
        if(o == null) {
            throw new ResourceNotFoundException(clazz.getSimpleName() + " not found for id: " + ObjectUtils.toString(id));
        }
    }
}
