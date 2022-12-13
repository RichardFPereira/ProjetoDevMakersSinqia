package br.com.ada.aredesocial.post;

public class Post {

    String usuario;
    String data;
    String hora;
    String mensagem;

    public Post(String usuario, String data, String hora, String mensagem){
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMensagem() {
        return mensagem;
    }
}
