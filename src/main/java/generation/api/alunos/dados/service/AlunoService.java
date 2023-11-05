package generation.api.alunos.dados.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.api.alunos.dados.controller.AlunoDTO;
import generation.api.alunos.dados.model.AlunoEntidade;
import generation.api.alunos.dados.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public String cadastrarAluno(AlunoDTO dadosAlunoDTO) {
        AlunoEntidade entidade = new AlunoEntidade();
        entidade.setIdentificador(dadosAlunoDTO.getIdentificador());
        entidade.setIdade(dadosAlunoDTO.getIdade());
        entidade.setNomeAluno(dadosAlunoDTO.getNomeAluno());
        entidade.setNota1(dadosAlunoDTO.getNota1());
        entidade.setNota2(dadosAlunoDTO.getNota2());
        entidade.setNomeProfessor(dadosAlunoDTO.getNomeProfessor());
        entidade.setNumeroSala(dadosAlunoDTO.getNumeroSala());

        repository.save(entidade);
        return "Cadastrado com sucesso";

    }

    public String deletarAluno(Long alunoID) {

        Optional<AlunoEntidade> entidadeOpcional = repository.findById(alunoID);

        if (entidadeOpcional.isPresent()) {

            repository.delete(entidadeOpcional.get());

            return "Aluno deletado com sucesso";
        } else {

            return "Aluno nao encontrado na base de dados";
        }
    }

    public AlunoDTO buscarAluno(Long alunoID) {

        Optional<AlunoEntidade> alunoOptional = repository.findById(alunoID);

        if (alunoOptional.isPresent()) {

            AlunoEntidade entidade = alunoOptional.get();

            AlunoDTO response = new AlunoDTO();

            response.setIdentificador(entidade.getIdentificador());
            response.setIdade(entidade.getIdade());
            response.setNomeAluno(entidade.getNomeAluno());
            response.setNota1(entidade.getNota1());
            response.setNota2(entidade.getNota2());
            response.setNomeProfessor(entidade.getNomeProfessor());
            response.setNumeroSala(entidade.getNumeroSala());

            return response;
        } else {
            return null;
        }
    }

    public String atualizarAluno(AlunoDTO requestAluno) {
        Optional<AlunoEntidade> entidadeOpcional = repository.findById(Long.valueOf(requestAluno.getIdentificador()));

        if (entidadeOpcional.isPresent()) {

            AlunoEntidade entidade = entidadeOpcional.get();
            entidade.setIdentificador(requestAluno.getIdentificador());
            entidade.setIdade(requestAluno.getIdade());
            entidade.setNomeAluno(requestAluno.getNomeAluno());
            entidade.setNota1(requestAluno.getNota1());
            entidade.setNota2(requestAluno.getNota2());
            entidade.setNomeProfessor(requestAluno.getNomeProfessor());
            entidade.setNumeroSala(requestAluno.getNumeroSala());

            repository.save(entidade);

            return "Aluno atualizado com sucesso";
        } else {

            return "Aluno nao encontrado na base de dados";
        }
    }

}
