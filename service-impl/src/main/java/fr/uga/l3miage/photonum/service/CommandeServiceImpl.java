package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Calendrier;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.CalendrierRepository;
import fr.uga.l3miage.photonum.data.repo.CommandeRepositoy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class CommandeServiceImpl implements CommandeService{
    private CommandeRepositoy commandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepositoy commandeRepositoy) {
        this.commandeRepository = commandeRepositoy;
    }


    @Override
    public Commande save(Commande commande) {

        return commandeRepository.save(commande);
    }

    @Override
    public Commande get(String id) throws EntityNotFoundException {
        return commandeRepository.get(id);
    }

    @Override
    public List<Commande> list() {
        return commandeRepository.all();
    }
    @Override
    public void delete(String id) throws EntityNotFoundException {
        Commande imp = get(id);
        if(imp==null){
            throw new EntityNotFoundException("Commande with id=%d not found".formatted(id));
        }else {
            commandeRepository.delete(imp);
        }

    }
    @Override
    public Commande update(Commande commande) throws EntityNotFoundException {
        return commandeRepository.updateCommande(commande.getId(),commande.getStatus()) ;
    }

    @Override
    public void addArticle(String id, Article article) throws EntityNotFoundException {
        Commande commande = get(id);
        if(commande==null){
            throw new EntityNotFoundException("Commande with id=%d not found".formatted(id));
        }else {
            commandeRepository.addArticle(id,article);
        }
    }

}
