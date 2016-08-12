package com.example.arivas.retrofitexample.retrofit.service;

import com.example.arivas.retrofitexample.retrofit.interfaces.PersonaServiceI;


/**
 * Created by arivas on 28/07/2016.
 */
public class PersonaService extends BaseService{

    private PersonaServiceI personaServiceI;

    public PersonaService(String baseUrl, String idSession, String token, String iso) {
        super(baseUrl, idSession, token, iso);
        this.personaServiceI = getRetrofit().create(PersonaServiceI.class);
    }

    public PersonaServiceI getPersonaServiceI() {
        return personaServiceI;
    }

}
