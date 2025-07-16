package hub.foro.controller;

import hub.foro.topics.DatosRegistroTopic;
import hub.foro.topics.Topics;
import hub.foro.topics.TopicsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registrar (@RequestBody DatosRegistroTopic datos) {
        topicsRepository.save(new Topics(datos));
    }

    @GetMapping
    public List<DatosRegistroTopic> listar(){
        return topicsRepository.findAll().stream()
                .map(DatosRegistroTopic::new)
                .sorted(Comparator.comparing(DatosRegistroTopic::fechaCreacion).reversed())
                .toList();
    }
}
