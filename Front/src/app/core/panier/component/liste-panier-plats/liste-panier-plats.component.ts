import { Component, OnInit } from '@angular/core';
import { PanierService } from 'src/app/core/panier/services/panier.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../../../../jwt/_services/token-storage.service';
import { Plat } from 'src/app/core/plat/interfaces/plat.vo';
import { HistoriqueCommandeService } from 'src/app/core/historique-commande/services/historique-commande.service';
import { Panier } from 'src/app/core/panier/interfaces/panier.vo';


@Component({
  selector: 'app-liste-panier-plats',
  templateUrl: './liste-panier-plats.component.html',
  styleUrls: ['./liste-panier-plats.component.scss']
})
export class ListePanierPlatsComponent implements OnInit {


  plats: Array<Plat>;
  plat: Plat;
  panier: Panier;
  currentUser: any;
  prixPlats: number;
  panierId: number;

  constructor(private panierService: PanierService,
    private route: ActivatedRoute,
    private historiqueService: HistoriqueCommandeService, private token: TokenStorageService) { this.plats = Array<Plat>() }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.findPlatFromPanier(this.currentUser.id);
    //this.findUserPanier(this.currentUser.id);
  }


  /**
   * Récupération des Plats d'un panier en fonction de l'id d'un user
   */
  findPlatFromPanier(idCurrentUser: number): void{
    this.panierService.findPlatFromPanier(idCurrentUser).subscribe(
      (data: Plat[]) => {
        this.plats = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

  getPrixTotal() {
    this.prixPlats = 0;
    this.plats.forEach((element) => {
      this.prixPlats += element.prix;
    });
    return this.prixPlats;
  }

  deletePlatFromActivePanier(idUser:number, idPlat:number) {
    this.panierService.deletePlatFromActivePanier(idUser, idPlat).subscribe(
      (data: Plat) => {
        this.plat = data;
        this.findPlatFromPanier(this.currentUser.id);
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

  addPanierToHistorique(idUser:number) {
    this.historiqueService.addPanierToHistorique(idUser).subscribe(
      (data: Panier) => {
        this.panier = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

  // findUserPanier(idUser:number) {
    
  //   console.dir(this.panierService.findUserPanier(idUser));
  //   this.panierService.findUserPanier(idUser).subscribe(
  //     (data: Panier) => {
  //       this.panier = data;
  //       console.log("mes datas" + data);
  //     },
  //     (error: Observable<never>) => {
  //       console.log(error);
  //     },
  //   );
  // }

}
