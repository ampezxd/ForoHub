package hub.foro.controller;


import hub.foro.domain.autor.Autor;
import hub.foro.domain.autor.AutorRepository;
import hub.foro.domain.autor.DatosActualizacionAutor;
import hub.foro.domain.autor.DatosRegistroAutor;
import hub.foro.domain.topics.DatosActualizacionTopic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

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

    @GetMapping
    public List<DatosRegistroAutor> listar () {
        return  autorRepository.findAll() .stream()
                .map(DatosRegistroAutor::new)
                .sorted(Comparator.comparing(DatosRegistroAutor::nombre))
                .toList();
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar (@RequestBody @Valid DatosActualizacionAutor datos){
        var autor = autorRepository.getReferenceById(datos.id());
        autor.ActualizarInformacion(datos);

        return ResponseEntity.ok(new DatosActualizacionAutor(autor));
    }
}
