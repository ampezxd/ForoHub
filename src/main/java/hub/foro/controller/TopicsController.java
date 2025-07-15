package hub.foro.controller;

import hub.foro.autor.AutorRepository;
import hub.foro.topics.DatosRegistroTopic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private AutorRepository autorRepository;


    @Transactional
    @PostMapping
    public void registrar (@RequestBody DatosRegistroTopic datos) {
        System.out.println(datos);
    }
}
