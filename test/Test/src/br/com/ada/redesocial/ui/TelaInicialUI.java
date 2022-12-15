package br.com.ada.redesocial.ui;

public class TelaInicialUI {

    public void telaInicial(){

        new BoasVindas().boasVindas();

        int entrada = new LerOpcaoUsuarioDeslogado().lerOpcaoDeslogado();

        switch (entrada){
            case 1:
                System.out.println("Logar!");
                //loginUi();
                break;
            case 2:
                System.out.println("Cadastrar!");
//                cadastroUi();
                telaInicial();
                break;
            case 0:
                System.out.println("Fechar!");
//                fecharPrograma();
                break;
        }
    };

}
