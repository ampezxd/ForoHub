package hub.foro.topics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

//Notaciones lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "topics")
@Entity(name = "Topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private Long autor_id;


    public Topics (DatosRegistroTopic datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor_id = datos.autor_id();
    }
}
