import { Component, OnInit, ViewChild, Optional, Inject } from '@angular/core';

import { PlatService } from 'src/app/core/plat/services/plat.service';
import { Plat } from 'src/app/core/plat/interfaces/plat.vo';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/core/restaurant/interfaces/restaurant.vo';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-plat',
  templateUrl: './list-plat.component.html',
  styleUrls: ['./list-plat.component.scss']
})
export class ListPlatComponent implements OnInit {

  breadcrumb = false;
  plats: Array<Plat>;

  constructor(
    private platService: PlatService,    
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
  }

  /**
   * Récupération des Plats.
   */
  /*retrievePlats(): void {
    this.platService.getAll().subscribe(
      (data: Plat[]) => {
        this.plats = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }*/



}
