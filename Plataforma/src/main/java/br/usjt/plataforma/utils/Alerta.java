package br.usjt.plataforma.utils;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Alerta {
	public String mensagem;
	public String tipo;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static void alerta(String mensagem, String tipo, HttpSession session) {

		/*if(!isset($_SESSION)){
            session_start();
        }*/
		
		if(tipo == null) {
			tipo = "warning";
		} else if(tipo == "error" || tipo == "erro") {
			tipo = "danger";
		}
		
		Alerta alerta = new Alerta();
		alerta.setTipo(tipo);
		alerta.setMensagem(mensagem);
		
		ArrayList<Alerta> novosAlertas = new ArrayList<Alerta>();
		
		ArrayList<Alerta> antigosAlertas = carregarAlertas(session);
		if(!antigosAlertas.isEmpty()) {
			novosAlertas.addAll(antigosAlertas);
		}
		
		novosAlertas.add(alerta);
		
		
		session.setAttribute("alertas", novosAlertas);

	} 

	public static ArrayList<Alerta> carregarAlertas(HttpSession session) {

		ArrayList<Alerta> alertas = (ArrayList) session.getAttribute("alertas");
		
		if(alertas == null) {
			alertas = new ArrayList<Alerta>();
		}
		
		return alertas;
	}
}