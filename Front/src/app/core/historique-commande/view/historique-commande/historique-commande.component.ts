import { Component, OnInit } from '@angular/core';
import { Panier } from 'src/app/core/panier/interfaces/panier.vo';
import { HistoriqueCommandeService } from '../../services/historique-commande.service';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/jwt/_services/token-storage.service';
import { HistoriqueCommande } from '../../interface/historique.vo';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-historique-commande',
  templateUrl: './historique-commande.component.html',
  styleUrls: ['./historique-commande.component.scss']
})
export class HistoriqueCommandeComponent implements OnInit {

  constructor(private historiqueCommandeService: HistoriqueCommandeService,  private route: ActivatedRoute,) { }

  historiqueCommande: HistoriqueCommande;

  ngOnInit(): void {
    this.retrievePaniersFromHistorique(Number(this.route.snapshot.paramMap.get('id')));
  }

    /**
   * Récupération des Plats d'un restaurant
   */
  retrievePaniersFromHistorique(idHistoriqueCommande: number): void{
    this.historiqueCommandeService.get(idHistoriqueCommande).subscribe(
      (data: HistoriqueCommande) => {
        this.historiqueCommande = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

}
