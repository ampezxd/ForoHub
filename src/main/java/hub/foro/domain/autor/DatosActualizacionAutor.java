package hub.foro.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionAutor(
        @NotNull
        Long id,
        String nombre,
        @Email
        String email
) {
    public DatosActualizacionAutor(Autor autor){
        this(autor.getId(),
                autor.getNombre(),
                autor.getEmail());
}
}
