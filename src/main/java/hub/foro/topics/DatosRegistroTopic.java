package hub.foro.topics;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopic(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        Long autor_id
) {
}
