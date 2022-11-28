package ProjetoFinal;

public class Perfil {
	String nomePerfil;
	String loginPerfil;
	String senhaPerfil;
	Post[] postsUsuario = new Post[1000];
	
	
	public void registrarUsuario(String nome, String login, String senha){
		nomePerfil = nome;
	    loginPerfil = login;
	    senhaPerfil = senha;
	  }
//	public void registrarPost(Post data, Post hora, Post mensagem, int index) {
//		Post post = new Post();
//		
//		postsUsuario[index].dataPost = data;
//		postsUsuario[index].horaPost = hora;
//		postsUsuario[index].mensagemPost = mensagem;
//	}
}
