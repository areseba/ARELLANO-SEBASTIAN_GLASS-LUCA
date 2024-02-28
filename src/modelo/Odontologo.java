package modelo;

public class Odontologo {
    private Integer id;
    private String matricula;
    private String nombre;
    private String appellido;

    public Odontologo() {

    }

    public Odontologo(String matricula, String nombre, String appellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.appellido = appellido;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellido() {
        return appellido;
    }

    public void setAppellido(String appellido) {
        this.appellido = appellido;
    }


}
