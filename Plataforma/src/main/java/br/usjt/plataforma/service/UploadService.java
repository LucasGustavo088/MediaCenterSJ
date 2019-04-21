package br.usjt.plataforma.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private static String PATH = "//home//marcelo//Área de Trabalho//Alura//casadocodigo//";
	
	//Salva no path do projeto -> reload
	//private static String PATH = "src/main/resources/static/";

	public JSONObject upload(MultipartFile file) throws Exception {

		JSONObject json = new JSONObject();

		json.put("arquivo", gravar(file));

		return json;

	}

	private String gravar(MultipartFile file) throws Exception {

		File novoArquivo = criarArquivo(file);

		try (FileOutputStream fileOutputStream = new FileOutputStream(novoArquivo)) {

			fileOutputStream.write(file.getBytes());

			return novoArquivo.getName();

		} catch (IOException e) {

			throw new RuntimeException("Erro ao processar arquivo");
		}
	}

	private File criarArquivo(MultipartFile file) throws Exception {

		String fileName = file.getOriginalFilename();

		if (fileName.lastIndexOf('.') >= 0) {

			String extensao = fileName.substring(fileName.lastIndexOf('.') + 1);

			File novoArquivo = new File(PATH, UUID.randomUUID().toString() + "." + extensao);

			try {

				novoArquivo.createNewFile();

			} catch (IOException e) {
				// TODO Auto-generated catch block

				throw new RuntimeException("Erro ao processar arquivo");
			}

			return novoArquivo;
		}

		throw new RuntimeException("Erro ao criar arquivo");

	}


}
