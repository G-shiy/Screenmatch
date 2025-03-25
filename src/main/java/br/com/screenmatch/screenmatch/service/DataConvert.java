package br.com.screenmatch.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConvert implements IDataConvert {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convert(String json, Class<T> dataClass) {
        try {return mapper.readValue(json, dataClass);}
        catch (JsonProcessingException e) {throw new RuntimeException(e);}
    }
}
