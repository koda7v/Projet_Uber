import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SelectionModel } from '@angular/cdk/collections';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';
import { Restaurant } from 'src/app/core/restaurant/interfaces/restaurant.vo';

import { Observable } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

import { SearchRestaurantFieldComponent } from '../../components/search-restaurant-field/search-restaurant-field.component';


@Component({
  selector: 'app-gestion-restaurants',
  templateUrl: './gestion-restaurants.component.html',
  styleUrls: ['./gestion-restaurants.component.scss']
})
export class GestionRestaurantsComponent implements OnInit {

  breadcrumb = false;
  show = false;
  listShow: Array<boolean>;
  displayedColumns: string[] = [
    'nom',
    'description',
    'photo',
    'actions'
  ];
  dataSource: MatTableDataSource<Restaurant>;
  selection: SelectionModel<Restaurant>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(SearchRestaurantFieldComponent)
  searchRestaurant: SearchRestaurantFieldComponent;

  constructor(
    private restaurantService: RestaurantService,
    private router: Router,
    private sanitizer: DomSanitizer,
  ) {
    this.dataSource = new MatTableDataSource([]);
    this.listShow = new Array<boolean>();
  }

  ngOnInit(): void {
    this.retrieveRestaurant();
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngAfterViewInit(): void {
    // Pagination et trie
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    // Filtre de recherche
    this.searchRestaurant.search.subscribe((search) => {
      this.dataSource.filter = search;
      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    });

  }

  /**
   * Récupération des Restaurants.
   */
  retrieveRestaurant(): void {
    this.restaurantService.getAll().subscribe(
      (data: Restaurant[]) => {
        this.dataSource = new MatTableDataSource(data);
        this.initShow(data.length);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

  initShow(length: number): void{
    for (let index = 0; index < length; index++) {
      const b = false;
      this.listShow.push(b);
    }
  }

  getShowWithId(id: number): any{
    return this.listShow[id - 1];
  }

  /**
   * Retourne true si tous les éléments du tableau ont étés sélectionnés.
   */
  isAllSelected(): boolean {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /**
   * Sélectionne tous les éléments s'ils ne sont pas tous cochés, déselectionne tout sinon.
   */
  masterToggle(): void {
    this.isAllSelected()
      ? this.selection.clear()
      : this.dataSource.data.forEach((row) => this.selection.select(row));
  }

  getImage(image: string): any{
    const objectURL = 'data:image/jpeg;base64,' + image;
    return this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }

  showPhoto(id: number): void{
    this.listShow[id - 1] = !this.listShow[id - 1];
  }

}
