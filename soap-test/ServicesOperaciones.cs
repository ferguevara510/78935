using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
    public class Operaciones : Mensajes 
    {
        public string Saludar(string nombre)
        {
            string msj = "Hola"+nombre+"me llamo Fer Guevara";
            return msj;
        }
        public string Mostrar(int id)
        {
            return "x";
        }
    }
}
