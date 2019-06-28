package util;

import java.util.ArrayList;
import java.util.List;

import beans.Aluno;

public class LoadAluno {
		
	public static List<Aluno> load(){
		List<Aluno> alunos = new ArrayList<>();
		alunos.add(new Aluno("Amanda", 8.0));
		alunos.add(new Aluno("Paulo", 5.5));
		alunos.add(new Aluno("Fernanda", 9.6));
		alunos.add(new Aluno("João", 8.8));
		alunos.add(new Aluno("Carla", 9.7));
		return alunos;
	}
}
