import { Component, OnInit } from '@angular/core';
import { PanierService } from 'src/app/core/panier/services/panier.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Panier } from '../../interfaces/panier.vo';


@Component({
  selector: 'app-liste-panier-plats',
  templateUrl: './liste-panier-plats.component.html',
  styleUrls: ['./liste-panier-plats.component.scss']
})
export class ListePanierPlatsComponent implements OnInit {


  paniers: Array<Panier>;
  idUser: number;

  constructor(private panierService: PanierService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.idUser = Number(this.route.snapshot.paramMap.get('id'));
    this.findPlatFromPanier(this.idUser);
  }


  /**
   * Récupération des Plats d'un panier en fonction de l'id d'un user
   */
  findPlatFromPanier(idUser: number): void{
    this.panierService.findPlatFromPanier(idUser).subscribe(
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
