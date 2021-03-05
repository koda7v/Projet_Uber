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

  historiqueCommande: HistoriqueCommande;
  paniers: Array<Panier>;
  currentUser: any;

  formatsDateTest = 'dd/MM/yyyy';

  constructor(
    private historiqueCommandeService: HistoriqueCommandeService,  private route: ActivatedRoute, private token: TokenStorageService
    ) { this.paniers = Array<Panier>(); }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.retrievePaniersFromHistorique(this.currentUser.id);
  }

  /**
   * Récupération de l'historique
   */
  retrieveHistorique(id: number): void{
    this.historiqueCommandeService.get(id).subscribe(
      (data: HistoriqueCommande) => {
        this.historiqueCommande = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }


  /**
   * Récupération les paniers dans l'historique
   */
  retrievePaniersFromHistorique(idPanier: number): void{
    this.historiqueCommandeService.retrievePaniersFromUsers(idPanier).subscribe(
      (data: Panier[]) => {
        this.paniers = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

}
