package hub.foro.topics;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopic(
        @NotNull Long id,
        String titulo,
        String mensaje
) {

}
