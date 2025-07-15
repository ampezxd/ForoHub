package hub.foro.topics;

import hub.foro.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Autor, Long> {
}
