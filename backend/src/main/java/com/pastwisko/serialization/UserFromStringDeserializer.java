package com.pastwisko.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.pastwisko.model.User;
import com.pastwisko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;

public class UserFromStringDeserializer extends JsonDeserializer<User> {

    @Autowired
    private UserService userService;

    public UserFromStringDeserializer() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String userName = jsonParser.readValueAs(String.class);
        return userService.findByUserName(userName);
    }
}
