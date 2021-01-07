import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SelectionModel } from '@angular/cdk/collections';

import { PersonneService } from 'src/app/core/personne/services/personne.service';
import { Personne } from 'src/app/core/personne/interfaces/personne.vo';
import { Observable } from 'rxjs';

import { ActivePersonsTabsComponent } from '../../components/active-persons-tabs/active-persons-tabs.component';
import { SearchPersonneFieldComponent } from '../../components/search-personne-field/search-personne-field.component';

@Component({
  selector: 'app-personne-list',
  templateUrl: './personne-list.component.html',
  styleUrls: ['./personne-list.component.scss']
})
export class PersonneListComponent implements OnInit {
  breadcrumb = false;
  displayedColumns: string[] = [
    'select',
    'civilite',
    'nom',
    'prenom',
    'dateDeNaissance',
    'agence',
    'entreprise',
    'actions'
  ];
  dataSource: MatTableDataSource<Personne>;
  selection: SelectionModel<Personne>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(ActivePersonsTabsComponent)
  activePersonnesTab: ActivePersonsTabsComponent;
  @ViewChild(SearchPersonneFieldComponent)
  searchPersonne: SearchPersonneFieldComponent;

  constructor(
    private personneService: PersonneService,
    private router: Router
  ) {
    this.dataSource = new MatTableDataSource([]);
    this.selection = new SelectionModel<Personne>(true, []);
  }

  ngOnInit(): void {
    this.retrievePersonnes();
  }

  ngAfterViewInit(): void {
    // Pagination et trie
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    // Filtre de recherche
    this.searchPersonne.search.subscribe((search) => {
      this.dataSource.filter = search;
      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    });

    // TODO : Chargement données en fonction personnes actives / supprimées.
    this.activePersonnesTab.active.subscribe((active) => console.log(active));
  }

  /**
   * Récupération des Personnes.
   */
  retrievePersonnes(): void {
    this.personneService.getAll().subscribe(
      (data: Personne[]) => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
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
}
