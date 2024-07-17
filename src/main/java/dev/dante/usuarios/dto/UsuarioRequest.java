package dev.dante.usuarios.dto;



public class UsuarioRequest {

    private String nome;
    private String email;
    private Boolean adm;

    public UsuarioRequest(String nome, String email, Boolean adm) {
        this.nome = nome;
        this.email = email;
        this.adm = adm;
    }
    
    // Getter and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getAdm() {
        return adm;
    }
    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    
}
