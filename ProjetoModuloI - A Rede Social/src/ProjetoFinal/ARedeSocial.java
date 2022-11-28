package ProjetoFinal;

import java.util.Scanner;

public class ARedeSocial {
	static Scanner input = new Scanner(System.in);
	static boolean quit = false;
	static boolean logado = false; 
	static int indexLogado = -1;
	static int opcao = -1;
	static int usuariosCadastrados = 0;
	static int[] postsRealizados = new int[1000];
	static Perfil[] usuarios = new Perfil[1000];
	static Perfil usuario = new Perfil();
	static Post[] posts = new Post[1000];
	static Post post = new Post();
	
	public static void main(String[] args) {		 
		boasVindas();
		while(!quit) {			
			opcao = lerOpcao();			
			if(opcao == 0) {
				quit = true;
				break;
			} else if (opcao == 1) {
				usuario = cadastro();
			} else if (opcao == 2) {
				logado = login();
				if(logado) {
					String nome = usuarios[indexLogado].nomePerfil;					
					while(logado) {
						opcao = -1;
						bemVindoUsuario(nome);
						opcao = lerOpcaoLogado();
						if (opcao == 0) {
							System.out.println("\nUsuário deslogado!");
							boasVindas();
							logado = false;
							break;
						} else if (opcao == 1) {
							postar();
							
						} else if (opcao == 2) {
							timeline();
						}
					}
				}
			}
		}
		ateMais();
		input.close();
	}
	
	public static int lerOpcao() {
		boolean test = false;
		int entrada = -1;
		while(!test) {
			try {
				System.out.println("\nDigite 1 para Cadastrar, 2 para Entrar ou 0 para Fechar.");
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
	
	public static void boasVindas( ) {
		System.out.println("\n*********************************");
		System.out.println("****Bem Vindo a A Rede Social****");
		System.out.println("*********************************");
	}
	
	public static void bemVindoUsuario(String nome) {
		System.out.println("\nBem Vindo, "+nome+"!");
	}
	
	public static void ateMais() {
		System.out.println("\n**********************");
		System.out.println("****Até a próxima!****");
		System.out.println("**********************");
	}
	
	public static Perfil cadastro() {
		Boolean testLogin = null;  
		Boolean testSenha = null;
		String nome;
		String login;
		String senha;
		String confirmarSenha;
		Perfil usuario = new Perfil();
		
		System.out.println("\n****************");
		System.out.println("****CADASTRO****");
		System.out.println("****************");
		
		try {
			input.nextLine();
			System.out.println("\nDigite o nome do usuário: ");
			nome = input.nextLine();
			nome = nome.toUpperCase();
			System.out.println("\nDigite o login do usuário: ");
			login = input.next();
			login = login.toUpperCase();
			testLogin = verificarLogin(login);
			if(!testLogin) {
				return null;
			} else {
				System.out.println("\nDigite a senha do usuário (mínimo 8 caracteres): ");
				senha = input.next();				
				System.out.println("\nDigite a confirmação de senhado usuário (mínimo 8 caracteres): ");
				confirmarSenha = input.next();
				testSenha = verificarSenha(senha, confirmarSenha);				
				if (!testSenha) {
					return null;
				}				
			}						
		} catch (Exception e) {
			System.out.println("Cadastro Inválido!");
			return null;
		}
		usuario.registrarUsuario(nome, login, senha);
		usuarios[usuariosCadastrados] = usuario;
		postsRealizados[usuariosCadastrados] = 0;
		usuariosCadastrados++;
		System.out.println("\nUsuário cadastrado com sucesso!!!");
		return usuario;
	}
	
	public static Boolean verificarLogin(String login) {
		if(usuariosCadastrados == 0) {
			return true;
		} else {
			for (int i = 0; i < usuariosCadastrados; i++) {
				if(usuarios[i].loginPerfil.equals(login)) {
					System.out.println("\nERRO! Login já cadastrado!");
					return false;
				}
			}
			return true;
		}
	}
	
	public static Boolean verificarSenha(String senha, String confirmarSenha) {
		if(senha.length() < 8 || confirmarSenha.length() < 8) {
			System.out.println("\nERRO! A senha deve ter no mínimo 8 caracteres!\n");
			return false;
		} else if (senha.equals(confirmarSenha)) {
			return true;
		}
		System.out.println("\nERRO! As senhas devem ser iguais!\n");
		return false;
	}
	
	public static boolean login() {
		boolean existe = false;
		System.out.println("\n*************");
		System.out.println("****LOGIN****");
		System.out.println("*************");
		
		if(usuariosCadastrados == 0) {
			System.out.println("\nERRO! Não há usuários cadastrados!");
			return false;
		} else {
			try {
				System.out.println("\nDigite o login: ");
				String login = input.next();
				System.out.println("\nDigite a senha: ");
				String senha = input.next();
				existe = verificarUsuariosCadastrados(login.toUpperCase(), senha);
				if(!existe) {
					return false;
				}								
			} catch (Exception e) {
				System.out.println("Erro inesperado!");
				return false;
			}
		}		
		return true;
	}
	
	public static boolean verificarUsuariosCadastrados (String login, String senha) {
		for (int i = 0; i < usuariosCadastrados; i++) {
			if (usuarios[i].loginPerfil.equals(login)) {
				if(verificarSenhaUsuariosCadastrados(senha, i)) {
					indexLogado = i;
					return true;
				} else {
					System.out.println("\nERRO! A senha está incorreta!");
					return false;
				}
			}
		}
		System.out.println("\nERRO! Usuário não cadastrado.");
		return false;
	}
	
	public static boolean verificarSenhaUsuariosCadastrados(String senha, int index) {
		if(usuarios[index].senhaPerfil.equals(senha)) {
			return true;
		}
		return false;
	}
	
	public static int lerOpcaoLogado() {
		boolean test = false;
		int entrada = -1;
		while(!test) {
			try {
				System.out.println("\nDigite 1 para Postar, 2 para Timeline ou 0 para Sair.");
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
	
	public static void postar() {
		String data;
		String hora;
		String mensagem;
		Post post = new Post();
		int meusPosts;
		
		try {
			System.out.println("\nDigite a data: ");
			data =  input.next();
			System.out.println("\nDigite a hora: ");
			hora =  input.next();
			input.nextLine();
			System.out.println("\nDigite a mensagem: ");
			mensagem =  input.nextLine();
			post.criarPost(data, hora, mensagem);
			meusPosts = postsRealizados[indexLogado];
			usuarios[indexLogado].postsUsuario[meusPosts] = post;			
		} catch (Exception e) {
			System.out.println("\n Erro inesperado!"); 
		}
		System.out.println("\nPost criado com sucesso! ");
		postsRealizados[indexLogado]++;
	}
	
	public static void timeline() {
		String data;
		String hora;
		String mensagem;
		int meusPosts = postsRealizados[indexLogado];
		
		if (meusPosts == 0) {
			System.out.println("\nVocê ainda não possui posts!");
		} else {
			System.out.println("\n****************");
			System.out.println("****TIMELINE****");
			System.out.println("****************");
			System.out.println("");
			for (int i = 0; i < meusPosts; i++) {
				data = usuarios[indexLogado].postsUsuario[i].dataPost;
				hora = usuarios[indexLogado].postsUsuario[i].horaPost;
				mensagem = usuarios[indexLogado].postsUsuario[i].mensagemPost;
				System.out.printf("%s às %s - %s", data, hora, mensagem);
				System.out.println("");
			}			
		}
	}
}
