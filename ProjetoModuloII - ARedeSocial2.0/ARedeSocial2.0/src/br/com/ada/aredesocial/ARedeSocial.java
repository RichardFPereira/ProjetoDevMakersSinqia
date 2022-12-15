package br.com.ada.aredesocial;

import br.com.ada.aredesocial.rede.Rede;
import br.com.ada.aredesocial.usuario.Usuario;

public class ARedeSocial {
    public static void main(String[] args) {
        boolean quit = false;
        Usuario usuario = new Usuario();
        Rede rede = new Rede();

        rede.boasVindas();

        while(!quit){
            int opcao = rede.lerOpcaoDeslogado();
            if(opcao == 0) {
                quit = true;
            } else if (opcao == 1) {
                if (rede.getUsuarios().isEmpty()){
                    System.out.println("\nNenhum usuário cadastrado. Por favor, cadastre-se.");
                } else {
                    if (rede.logar()){
                        usuario.setLogado(true);
                        while(usuario.getLogado()){
                            Usuario user = rede.usuarioLogado;
                            opcao = rede.lerOpcaoLogado();
                            if (opcao == 0){
                                System.out.println("DESLOGADO!");
                                usuario.setLogado(false);
                            } else if (opcao == 1) {
                                rede.postar(user);
                            } else {
                                rede.mostrarTimeLine(user);
                            }
                        }
                    }
                }
            } else if (opcao == 2) {
                rede.cadastrarUsuario();
            }
        }
        rede.despedida();
    }
}