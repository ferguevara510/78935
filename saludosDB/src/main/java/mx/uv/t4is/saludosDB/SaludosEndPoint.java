package mx.uv.t4is.saludosDB;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class SaludosEndPoint 
{
    @Autowired
    Isaludadores isaludadores;
    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion)
    {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        Saludadores saludo = new Saludadores();
        isaludadores.save(saludo);
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos()
    {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        Iterable <Saludadores> listaSaludos = isaludadores.findAll();
        for (Saludadores o : listaSaludos) 
        {
            BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
            e.setId(o.getID());
            respuesta.getSaludos().add(e);
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludo(@RequestPayload ModificarSaludoRequest peticion)
    {
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        Saludadores e = new Saludadores();
        e.setID(peticion.getId());
        e.setNombre(peticion.getNombre());
        isaludadores.save(e);
        respuesta.setRespuesta(true);
        return respuesta;
    }
    @PayloadRoot(localPart = "BorrarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorrarSaludoResponse borrarSaludo(@RequestPayload BorrarSaludoRequest peticion)
    {
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
        isaludadores.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;
    }
}