package hub.foro.controller;


import hub.foro.autor.Autor;
import hub.foro.autor.AutorRepository;
import hub.foro.autor.DatosRegistroAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    @PostMapping
    public void registrarAutor(@RequestBody DatosRegistroAutor datos) {
        autorRepository.save(new Autor(datos));

    }
}
