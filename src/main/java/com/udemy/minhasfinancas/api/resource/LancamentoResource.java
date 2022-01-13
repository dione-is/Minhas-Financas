package com.udemy.minhasfinancas.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.minhasfinancas.api.dto.LancamentoDTO;
import com.udemy.minhasfinancas.exception.RegraNegocioException;
import com.udemy.minhasfinancas.model.entity.Lancamento;
import com.udemy.minhasfinancas.model.entity.Usuario;
import com.udemy.minhasfinancas.model.enums.StatusLancamento;
import com.udemy.minhasfinancas.model.enums.TipoLancamento;
import com.udemy.minhasfinancas.service.LancamentoService;
import com.udemy.minhasfinancas.service.UsuarioService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoResource {
	
	private LancamentoService service;
	private UsuarioService 	  usuarioService;
	
	public  LancamentoResource(LancamentoService service) {
		
		this.service = service;
	} 
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
		return null;
		
		
	}

	private Lancamento converter(LancamentoDTO dto) {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(dto.getId());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setMes(dto.getMes());
		lancamento.setAno(dto.getAno());
		lancamento.setValor(dto.getValor());
		
		Usuario usuario = usuarioService
			.obterPorId(dto.getUsuario())
			.orElseThrow( () -> new RegraNegocioException("Usuario não Encontrado"));
 		
		lancamento.setUsuario(usuario);
		lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
		lancamento.setStatus(StatusLancamento.valueOf(dto.getStatus()));
		
		return lancamento;
	}
}
