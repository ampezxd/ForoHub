package hub.foro.controller;

import hub.foro.domain.topics.DatosActualizacionTopic;
import hub.foro.domain.topics.DatosRegistroTopic;
import hub.foro.domain.topics.Topics;
import hub.foro.domain.topics.TopicsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;


    @Transactional
    @PostMapping
    public ResponseEntity registrar (@RequestBody @Valid DatosRegistroTopic datos, UriComponentsBuilder uriBuilder) {
        var topics = new Topics(datos);
        topicsRepository.save(topics);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topics.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosActualizacionTopic(topics));
    }

    @GetMapping
    public List<DatosRegistroTopic> listar(){
        return topicsRepository.findAll().stream()
                .map(DatosRegistroTopic::new)
                .sorted(Comparator.comparing(DatosRegistroTopic::fechaCreacion).reversed())
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRegistroTopic> buscar(@PathVariable Long id){
        Topics topics;
        topics = topicsRepository.getReferenceById(id);
        var datosTopics = new DatosRegistroTopic(topics.getId(), topics.getTitulo(), topics.getMensaje(), topics.getAutor_id(), topics.getFechaCreacion());
        return ResponseEntity.ok(new DatosRegistroTopic(topics));
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopic datos){
        var topic = topicsRepository.getReferenceById(datos.id()); // Así optenemos el topico de la base de datos mediante el id
        topic.actualizarInformacion(datos); //metodo para actualizar informacion del tópico

        return  ResponseEntity.ok(new DatosActualizacionTopic(topic));
    }

    @Transactional
    @DeleteMapping("/{id}")
    //Se utiliza el responseEntity para devolver diferentes codigos http
    public ResponseEntity <Void> eliminar(@PathVariable Long id){
        Optional<Topics> topicsOptional = topicsRepository.findById(id);
        //Utilizacion del optional para manejar mejor los errores
        if (topicsOptional.isPresent()) {
            topicsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
} 
