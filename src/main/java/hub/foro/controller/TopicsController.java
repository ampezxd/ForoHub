package hub.foro.controller;

import hub.foro.topics.DatosActualizacionTopic;
import hub.foro.topics.DatosRegistroTopic;
import hub.foro.topics.Topics;
import hub.foro.topics.TopicsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;


    @Transactional
    @PostMapping
    public void registrar (@RequestBody @Valid DatosRegistroTopic datos) {
        topicsRepository.save(new Topics(datos));
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
        var datosTopics = new DatosRegistroTopic(topics.getTitulo(), topics.getMensaje(), topics.getAutor_id(), topics.getFechaCreacion());
        return ResponseEntity.ok(new DatosRegistroTopic(topics));
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionTopic datos){
        var topic = topicsRepository.getReferenceById(datos.id()); // Así optenemos el topico de la base de datos mediante el id
        topic.actualizarInformacion(datos); //metodo para actualizar informacion del tópico
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id){}

} 
