package hub.foro.domain.autor;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Notaciones lombonk
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table (name = "autor")
@Entity (name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;


    public Autor(DatosRegistroAutor datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.email = datos.email();
    }

    //Con este metodo se cambian los valores que el usuario indique mediante la request
    public void ActualizarInformacion(@Valid DatosActualizacionAutor datos) {
        if (datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if (datos.email() != null){
            this.email = datos.email();
        }
    }
}
