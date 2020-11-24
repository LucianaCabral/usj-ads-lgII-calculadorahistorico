package br.edu.usj.ads.lgll.calculadorahistoricolll;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculadoraHistoricoIII {

    //List<String> historico = new ArrayList<>();
    @Autowired
    HistoricoRepository historicoRepository; 

    @PostMapping(value="/somar")
    public ModelAndView postSomar(@RequestParam String numero1, @RequestParam String numero2) {
        Double numero1Double = Double.valueOf(numero1);
        Double numero2Double = Double.valueOf(numero2);
        Double resultado = numero1Double + numero2Double;
        String operacao = numero1 + " + "  + numero2 + " = " + resultado;

        //historico.add(operacao);
        Historico item = new Historico();
        item.setOperacao(operacao);
        historicoRepository.save(item);

        List<Historico> historico = historicoRepository.findAll();
        
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", operacao);
        modelAndView.addObject("historico", historico);
        return modelAndView;
    }
    
    
}
