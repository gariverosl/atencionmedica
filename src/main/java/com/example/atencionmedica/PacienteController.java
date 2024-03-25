package com.example.atencionmedica;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
    
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Atencion> atenciones1 = new ArrayList<>();
    private List<Atencion> atenciones2 = new ArrayList<>();
    private List<Atencion> atenciones3 = new ArrayList<>();
    //Inicializar listas
    public PacienteController(){

        
        atenciones1.add(new Atencion(1, "Doc1", "Estomago 1","2022-02-22"));
        atenciones1.add(new Atencion(2, "Doc2", "Estomago 2","2023-02-22"));
        atenciones1.add(new Atencion(3, "Doc2", "Gargante 1","2024-02-22"));
        atenciones1.add(new Atencion(4, "Doc1", "Estomago 3","2024-03-25"));

        atenciones2.add(new Atencion(1, "Doc1", "Estomago 1","2022-02-11"));
        atenciones2.add(new Atencion(2, "Doc2", "Estomago 2","2023-02-11"));
        atenciones2.add(new Atencion(3, "Doc2", "Gargante 1","2024-02-11"));
        

        pacientes.add(new Paciente(1, "Pac 1", new ArrayList<>(atenciones1)));
        pacientes.add(new Paciente(2, "Pac 2", new ArrayList<>(atenciones2)));

    }

    //Listas de pacientes
    @GetMapping("/pacientes")
    public List<Paciente> getPaciente(){
        return   pacientes;
    }

    //Paciente por ID
    @GetMapping("/pacientes/{id}")
    public Paciente getPacienteById(@PathVariable int id) {
        for(Paciente paciente : pacientes)
        {
            if(paciente.getId() == id){
                return paciente;
            }
        }
        return null;
    }

    //Total de atenciones 
    @GetMapping("/pacientes/atenciones")
    public int getAtenciones() {
        int cont = 0;
        for(Paciente paciente : pacientes)
        {
            cont = cont + paciente.getAtenciones().size();

        }
        if(cont > 0 )
        {
            return cont;
        }
        else
        {
            return 0;
        }
        
    }

    //Atenciones por Paciente 
    @GetMapping("/pacientes/{id}/atenciones")
    public int getAtencionesById(@PathVariable int id) {
        int cont = 0;
        for(Paciente paciente : pacientes)
        {   
            if(paciente.getId() == id){
                cont = cont + paciente.getAtenciones().size();    
            }

        }
        if(cont > 0 )
        {
            return cont;
        }
        else
        {
            return 0;
        }
        
    }

    //Atenciones por Paciente Json 
    @GetMapping("/pacientes/json/{id}/atenciones")
    public Resp getAtencionesJsonById(@PathVariable int id) {
        int cont = 0;
        
        for(Paciente paciente : pacientes)
        {   
            if(paciente.getId() == id){
                cont = cont + paciente.getAtenciones().size();    
            }

        }
        
        if(cont > 0 )
        {
            Resp a = new Resp(cont);
            return a;
        }
        else
        { 
            Resp a = new Resp(cont);
            return a ;
        }
        
    }

}
