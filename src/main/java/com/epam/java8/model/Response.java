package com.epam.java8.model;

public class Response<T> {

    private T responseBody;
    private Integer statusCode;
    private String responseType;

    public Response() {
    }

    public Response(T responseBody, Integer statusCode, String responseType) {
        this.responseBody = responseBody;
        this.statusCode   = statusCode;
        this.responseType = responseType;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseBody=" + responseBody +
                ", statusCode=" + statusCode +
                ", responseType='" + responseType + '\'' +
                '}';
    }
}
