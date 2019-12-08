package pe.isil.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.democrud.model.Personas;
import pe.isil.democrud.service.api.PersonaServiceAPI;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class PersonaRestController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @GetMapping(value = "/all")
    public List<Personas> getAll(){
        return personaServiceAPI.getAll();

    }
    @PostMapping(value = "/save")
    public ResponseEntity<Personas> save(@RequestBody Personas persona){
       Personas obj = personaServiceAPI.save(persona);
       return new ResponseEntity<Personas>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Personas> delete(@PathVariable Long id){
        Personas persona = personaServiceAPI.get(id);
        if(persona!=null){
            personaServiceAPI.delete(id);
        }else {
            return new ResponseEntity<Personas>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Personas>(persona, HttpStatus.OK);
    }

}
