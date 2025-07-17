package hub.foro.domain.topics;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRegistroTopic(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Long autor_id,
        LocalDateTime fechaCreacion
) {

        public DatosRegistroTopic (Topics topics) {
                this(topics.getId(), topics.getTitulo(), topics.getMensaje(), topics.getAutor_id(), topics.getFechaCreacion());
        }
}
