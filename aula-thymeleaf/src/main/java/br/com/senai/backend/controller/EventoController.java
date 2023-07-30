package br.com.senai.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senai.backend.entity.Evento;
import br.com.senai.backend.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@GetMapping("/cadastrar")
	public String formularioPalestra() {
		return "pages/formularioCadastrarEvento";
	}

	@PostMapping("/cadastrar")
	public String formularioPalestra(Evento evento) {
		eventoRepository.save(evento);
		return "pages/formularioCadastrarEvento";
	}

	@GetMapping("/eventos")
	public ModelAndView listarEventos() {
		ModelAndView mv = new ModelAndView("pages/listarEventos");
		List<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	@GetMapping("{id}")
	public ModelAndView buscarEvento(@PathVariable Long id) {
		Optional<Evento> evento = eventoRepository.findById(id);
		ModelAndView mv = new ModelAndView("pages/buscarEvento");
		mv.addObject("evento", evento);
		return mv;

	}

}
