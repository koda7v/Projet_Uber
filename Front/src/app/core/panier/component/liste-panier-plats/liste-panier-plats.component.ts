import { Component, OnInit } from '@angular/core';
import { PanierService } from 'src/app/core/panier/services/panier.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Panier } from '../../interfaces/panier.vo';
import { TokenStorageService } from '../../../../jwt/_services/token-storage.service';
import { Plat } from 'src/app/core/plat/interfaces/plat.vo';
import { element } from 'protractor';


@Component({
  selector: 'app-liste-panier-plats',
  templateUrl: './liste-panier-plats.component.html',
  styleUrls: ['./liste-panier-plats.component.scss']
})
export class ListePanierPlatsComponent implements OnInit {


  plats: Array<Plat>;
  plat: Plat;
  currentUser: any;
  prixPlats: number;

  constructor(private panierService: PanierService,
    private route: ActivatedRoute,
    private token: TokenStorageService) { this.plats = Array<Plat>() }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.findPlatFromPanier(this.currentUser.id);
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
    console.log(this.prixPlats);
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

}
