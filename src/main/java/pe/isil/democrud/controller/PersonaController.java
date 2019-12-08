package pe.isil.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.democrud.model.Personas;
import pe.isil.democrud.service.api.PersonaServiceAPI;


@Controller
public class PersonaController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("list", personaServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model){
        if(id != null && id !=0){
            model.addAttribute("persona", personaServiceAPI.get(id));
        }else {
            model.addAttribute("persona", new Personas());
        }
        return "save";

    }

    @PostMapping("/save")
    public String save(Personas persona, Model model){
        personaServiceAPI.save(persona);

        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        personaServiceAPI.delete(id);
        return "redirect:/";
    }


}
