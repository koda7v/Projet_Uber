import { Component, OnInit } from '@angular/core';

import { PlatService } from 'src/app/core/plat/services/plat.service';
import { Plat } from 'src/app/core/plat/interfaces/plat.vo';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-plat',
  templateUrl: './list-plat.component.html',
  styleUrls: ['./list-plat.component.scss']
})
export class ListPlatComponent implements OnInit {

  breadcrumb = false;
  plats: Array<Plat>;

  constructor(
    private platService: PlatService
  ) { }

  ngOnInit(): void {
    this.retrievePlats();
  }

  /**
   * Récupération des Plats.
   */
  retrievePlats(): void {
    this.platService.getAll().subscribe(
      (data: Plat[]) => {
        this.plats = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

}
