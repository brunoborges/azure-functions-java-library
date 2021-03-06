package com.microsoft.azure.functions;

/**
 * Enum for HTTP methods in the HTTP Binding of Azure Functions.
 * 
 * @author Bruno Borges
 */
public enum HttpMethod {
    
    GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE;

    /**
     * Converts passed value to upper case to extract valueOf() of this Enum.
     * @param value of http method in any case
     * @return this enum
     */
    public static HttpMethod value(String value) {
        return HttpMethod.valueOf(value.toUpperCase());
    }

}
