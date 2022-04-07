package mx.uv.t4is.saludos;

import java.util.ArrayList;

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
    ArrayList<BuscarSaludosResponse.Saludos> listaSaludos = new ArrayList<BuscarSaludosResponse.Saludos>();
    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion)
    {
        int id = 0;
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+peticion.getNombre());
        BuscarSaludosResponse.Saludos saludo = new BuscarSaludosResponse.Saludos();
        saludo.setId(id);
        saludo.setNombre(peticion.getNombre());
        listaSaludos.add(saludo);
        id ++;
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos()
    {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        for (BuscarSaludosResponse.Saludos saludo : listaSaludos) 
        {
            respuesta.getSaludos().add(saludo);
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse modificarSaludo()
    {
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        for (BuscarSaludosResponse.Saludos saludo : listaSaludos) 
        {
            respuesta.getSaludos().add(saludo);
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludo(@RequestPayload ModificarSaludoRequest peticion)
    {
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        listaSaludos.set(peticion.getId()-1, e);
        respuesta.setRespuesta(true);
        return respuesta;
    }
    @PayloadRoot(localPart = "BorrarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BorrarSaludoResponse borrarSaludo(@RequestPayload BorrarSaludoRequest peticion)
    {
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
        for(BuscarSaludosResponse.Saludos o : listaSaludos)
        {
            if(o.getId() == peticion.getId())
            {
                listaSaludos.remove(o);
            }
        }
        respuesta.setRespuesta(true);
        return respuesta;
    }
}