package mx.uv.t4is.saludosDB;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.RegistrarContactoResponse;
import https.t4is_uv_mx.saludos.RegistrarContactoRequest;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class ContactoEndPoint {
    @Autowired
    IContacto iContacto;
    @PayloadRoot(localPart = "RegistrarContactoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public RegistrarContactoResponse Saludar(@RequestPayload RegistrarContactoRequest peticion)
    {
        RegistrarContactoResponse respuesta = new RegistrarContactoResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        Saludadores saludo = new Saludadores();
        iContacto.save(saludo);
        return respuesta;
    }
}
