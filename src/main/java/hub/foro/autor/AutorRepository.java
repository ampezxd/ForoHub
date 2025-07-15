package hub.foro.autor;

import org.springframework.data.jpa.repository.JpaRepository;


//Con esta interfaz accedemos y manipulamos los datos en la base de datos
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
