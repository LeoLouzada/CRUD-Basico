package com.leolouzada.apirest.controller;

import com.leolouzada.apirest.dto.TarefaDTO;
import com.leolouzada.apirest.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO){
        return tarefaService.criar(tarefaDTO);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDTO tarefaDTO){
        return tarefaService.atualizar(tarefaDTO, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll(){
        return tarefaService.getAll();
    }

    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId){
        return tarefaService.delete(tarefaId);
    }
}
