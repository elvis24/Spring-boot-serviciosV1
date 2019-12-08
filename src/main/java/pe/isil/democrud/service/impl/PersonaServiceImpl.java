package pe.isil.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.isil.democrud.commos.GenericServicesImpl;
import pe.isil.democrud.dao.api.PersonaDaoAPI;
import pe.isil.democrud.model.Personas;
import pe.isil.democrud.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServicesImpl<Personas, Long> implements PersonaServiceAPI {

    @Autowired
    private PersonaDaoAPI personaDaoAPI;

    @Override
    public CrudRepository<Personas, Long> getDao() {
        return personaDaoAPI;
    }
}
