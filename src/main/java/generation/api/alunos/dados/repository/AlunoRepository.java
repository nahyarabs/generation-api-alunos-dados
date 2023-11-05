package generation.api.alunos.dados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import generation.api.alunos.dados.model.AlunoEntidade;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntidade, Long> {

}
