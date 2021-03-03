package uber.repository.historique;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import uber.model.HistoriqueCommande;

@Repository
public interface HistoriqueRepository extends PagingAndSortingRepository<HistoriqueCommande, Long>
{
  @Override
  public List<HistoriqueCommande> findAll();
}
