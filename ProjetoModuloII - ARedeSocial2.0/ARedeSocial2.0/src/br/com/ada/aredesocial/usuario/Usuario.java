package br.com.ada.aredesocial.usuario;

public class Usuario {
    private String nome;
    private String login;
    private String senha;

    boolean logado = false;

    public Usuario(){};

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    public String getLogin(){
        return this.login;
    }

    public String getSenha(){
        return this.senha;
    }

    public boolean getLogado(){
        return this.logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}
