package br.com.ada.aredesocial.rede;

import br.com.ada.aredesocial.post.Post;
import br.com.ada.aredesocial.usuario.Usuario;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Rede {
    private static Scanner input = new Scanner(System.in);
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuario;
    public Usuario usuarioLogado;

    public Rede(){
    }

    public void boasVindas(){
        System.out.println("\n********************");
        System.out.println("**** BEM VINDO! ****");
        System.out.println("********************\n");
    }

    public void despedida(){
        System.out.println("\n**********************");
        System.out.println("****Até a próxima!****");
        System.out.println("**********************");
    }

    public int lerOpcaoDeslogado() {
        boolean test = false;
        int entrada = -1;
        while(!test) {
            try {
                System.out.println("\nDigite 1 para logar, 2 para cadastrar ou 0 para sair: ");
                entrada = input.nextInt();
                if(entrada > 2 || entrada < 0) {
                    System.out.println("\nOpção inválida. Digite novamente.");
                } else {
                    test = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nOpção inválida. Digite novamente.");
                input.nextLine();
            }
        }
        return entrada;
    }

    public void cadastrarUsuario(){
        System.out.println("Digite seu nome: ");
        String nome = input.next();
        System.out.println("Digite seu login: ");
        String login = input.next();
        System.out.println("Digite sua senha: ");
        String senha = input.next();
        System.out.println("Confirme sua senha: ");
        String confirmarSenha = input.next();
        if (verificarCadastro(login, senha, confirmarSenha)){
            Usuario user = new Usuario(nome, login, senha);
            setUsuarios(user);
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public boolean verificarCadastro(String login, String senha, String confirmarSenha){
        for (Usuario user : usuarios) {
            if (user.getLogin().equalsIgnoreCase(login)){
                System.out.println("O usuário já está cadastrado.");
                return false;
            }
        }
        if (!senha.equals(confirmarSenha)) {
            System.out.println("As senhas devem ser iguais! ");
            return false;
        } else {
            return true;
        }
    }

    public boolean logar(){
        System.out.println("Digite seu login: ");
        String login = input.next();
        System.out.println("Digite sua senha: ");
        String senha = input.next();

        for (Usuario user : usuarios) {
            if (user.getLogin().equalsIgnoreCase(login)){
                if (!user.getSenha().equals(senha)){
                    System.out.println("Senha incorreta!");
                    return false;
                } else {
                    usuarioLogado = user;
                    return true;
                }
            }
        }
        System.out.println("Usuario não cadastrado.");
        return false;
    }

    public int lerOpcaoLogado() {
        boolean test = false;
        int entrada = -1;
        while(!test) {
            try {
                System.out.println("\nDigite 1 para postar, 2 para timeline ou 0 para deslogar: ");
                entrada = input.nextInt();
                if(entrada > 2 || entrada < 0) {
                    System.out.println("\nOpção inválida. Digite novamente.");
                } else {
                    test = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println("\nOpção inválida. Digite novamente.");
                input.nextLine();
            }
        }
        return entrada;
    }

    public void postar(Usuario user) {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        input.nextLine();
        System.out.println("Digite a mensagem: ");
        String mensagem = input.nextLine();
        user.criarPost(data, hora, mensagem);
        System.out.println("\nPOST CRIADO!");
    }

    public void mostrarTimeline(Usuario user){
        if (user.getPosts().size() != 0){
            for (Post postagem : user.getPosts()) {
                System.out.println("\nDATA: " + postagem.getData());
                System.out.println("HORA: " + postagem.getHora());
                System.out.println("MENSAGEM: "+ postagem.getMensagem());
            }
        } else {
            System.out.println("\nEste usuário não possui posts!");
        }
    }
}
