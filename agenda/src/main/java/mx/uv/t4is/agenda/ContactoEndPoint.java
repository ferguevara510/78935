package mx.uv.t4is.agenda;

import https.t4is_uv_mx.agenda.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class ContactoEndPoint {

    @Autowired
    IContacto iContacto;
    @PayloadRoot(localPart = "RegistrarContactoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public RegistrarContactoResponse registrarContacto(@RequestPayload RegistrarContactoRequest peticion)
    {
        RegistrarContactoResponse respuesta = new RegistrarContactoResponse();
        Contacto contacto = new Contacto();
        iContacto.save(contacto);
        respuesta.setRespuesta(true);
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarContactosRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public BuscarContactosResponse buscarContactosResponse()
    {
        BuscarContactosResponse respuesta = new BuscarContactosResponse();
        Iterable <Contacto> listaSaludos = iContacto.findAll();
        for (Contacto o : listaSaludos)
        {
            BuscarContactosResponse.Contacto e = new BuscarContactosResponse.Contacto();
            e.setId(o.getId());
            respuesta.getContacto().add(e);
        }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarContactoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public ModificarContactoResponse modificarContactoResponse(@RequestPayload ModificarContactoRequest peticion)
    {
        ModificarContactoResponse respuesta = new ModificarContactoResponse();
        Contacto e = new Contacto();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        iContacto.save(e);
        respuesta.setRespuesta(true);
        return respuesta;
    }
    @PayloadRoot(localPart = "BorrarContactoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public BorrarContactoResponse borrarSaludo(@RequestPayload BorrarContactoRequest peticion)
    {
        BorrarContactoResponse respuesta = new BorrarContactoResponse();
        iContacto.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;
    }
}
