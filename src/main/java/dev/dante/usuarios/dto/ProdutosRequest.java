package dev.dante.usuarios.dto;


public class ProdutosRequest {
    private String titulo;
    private String descricao;
    private Long usuario;

    
    public ProdutosRequest(String titulo, String descricao, Long usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Long getUsuario() {
        return usuario;
    }
    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    
    
}
