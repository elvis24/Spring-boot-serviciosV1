package pe.isil.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;
import pe.isil.democrud.model.Personas;

public interface PersonaDaoAPI extends CrudRepository<Personas, Long> {

}
