package hub.foro.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroAutor(

        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email
) {
       public DatosRegistroAutor (Autor autor){
                this(autor.getNombre(), autor.getEmail());
       }
}
