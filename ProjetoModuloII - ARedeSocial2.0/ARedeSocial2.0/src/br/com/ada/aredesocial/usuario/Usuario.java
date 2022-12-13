package br.com.ada.aredesocial.usuario;

import br.com.ada.aredesocial.post.Post;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;

    private ArrayList<Post> posts = new ArrayList<>();

    boolean logado = false;

    public Usuario(){};

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome(){
        return this.nome;
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

    public void criarPost(String data, String hora, String mensagem){
        String usuario = this.login;
        Post novoPost = new Post(usuario, data, hora, mensagem);
        setPosts(novoPost);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(Post post) {
        this.posts.add(post);
    }
}
