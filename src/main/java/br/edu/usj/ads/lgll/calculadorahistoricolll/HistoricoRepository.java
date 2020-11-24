package br.edu.usj.ads.lgll.calculadorahistoricolll;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface HistoricoRepository extends CrudRepository<Historico, Long>{
    
List<Historico> findAll();

}
    

