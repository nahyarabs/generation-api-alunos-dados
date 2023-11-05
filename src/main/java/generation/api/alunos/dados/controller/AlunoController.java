package generation.api.alunos.dados.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generation.api.alunos.dados.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarAlunoPost(@RequestBody AlunoDTO request) throws IOException {
        service.cadastrarAluno(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<?> buscarAluno(@PathVariable Long idAluno) {

        AlunoDTO aluno = service.buscarAluno(idAluno);

        if (aluno != null) {
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{idAluno}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long idAluno) {

        String aluno = service.deletarAluno(idAluno);

        if (aluno != null) {
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(aluno);
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarAluno(@RequestBody AlunoDTO request) throws IOException {
        String retorno = service.atualizarAluno(request);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

}
