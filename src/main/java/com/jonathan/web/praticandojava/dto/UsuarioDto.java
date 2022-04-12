package com.jonathan.web.praticandojava.dto;

public class UsuarioDto {
    private int usuario_id;
    private String email;
    private String password;
    private String idgoogle;

    public UsuarioDto() {
    }

    public UsuarioDto(String email, String password, String idgoogle) {
        this.email = email;
        this.password = password;
        this.idgoogle = idgoogle;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdgoogle() {
        return idgoogle;
    }

    public void setIdgoogle(String idgoogle) {
        this.idgoogle = idgoogle;
    }

}
