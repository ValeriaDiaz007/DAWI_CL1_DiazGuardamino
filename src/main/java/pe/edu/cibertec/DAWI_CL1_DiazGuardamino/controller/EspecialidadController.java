package pe.edu.cibertec.DAWI_CL1_DiazGuardamino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.cibertec.DAWI_CL1_DiazGuardamino.model.Especialidad;
import pe.edu.cibertec.DAWI_CL1_DiazGuardamino.service.EspecialidadService;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/frmMantEspecialidad")
	public String frmMantEspecialidad(Model model) {
		model.addAttribute("listaEspecialidad", especialidadService.listarEspecialidad());
		return "Especialidad/frmMantEspecialidad";
	}
	
	@GetMapping("/frmRegEspecialidad")
	public String frmRegEspecialidad(Model model) {
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar", false);
		return "Especialidad/frmRegEspecialidad";
	}
	
	@PostMapping("/frmRegEspecialidad")
	public String registrarEspecialidad(@ModelAttribute("especialidadForm") Especialidad especialidad, Model model) {
		String mensaje="Especialidad registrado correctamente"; 
		try {
			especialidadService.registrarEspecialidad(especialidad);
		} catch(Exception e) {
			mensaje="Especialidad no registrado";
		}
		model.addAttribute("especialidadForm", new Especialidad());
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", mensaje);
		especialidadService.registrarEspecialidad(especialidad);
		return "Estado/frmRegEspecialidad";
	}

}
