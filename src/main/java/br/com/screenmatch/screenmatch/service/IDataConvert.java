package br.com.screenmatch.screenmatch.service;

public interface IDataConvert {
    public <T> T convert(String json, Class<T> dataClass);

}
