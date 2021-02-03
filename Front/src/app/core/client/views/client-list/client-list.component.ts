import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SelectionModel } from '@angular/cdk/collections';

import { ClientService } from 'src/app/core/client/services/client.service';
import { Client } from 'src/app/core/client/interfaces/client.vo';
import { Observable } from 'rxjs';

import { SearchClientFieldComponent } from '../../components/search-client-field/search-client-field.component';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.scss']
})
export class ClientListComponent implements OnInit {
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
  dataSource: MatTableDataSource<Client>;
  selection: SelectionModel<Client>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(SearchClientFieldComponent)
  searchClient: SearchClientFieldComponent;

  constructor(
    private personneService: ClientService,
    private router: Router
  ) {
    this.dataSource = new MatTableDataSource([]);
    this.selection = new SelectionModel<Client>(true, []);
  }

  ngOnInit(): void {
    this.retrieveClients();
  }

  ngAfterViewInit(): void {
    // Pagination et trie
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    // Filtre de recherche
    this.searchClient.search.subscribe((search) => {
      this.dataSource.filter = search;
      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    });
  }

  /**
   * Récupération des Clients.
   */
  retrieveClients(): void {
    this.personneService.getAll().subscribe(
      (data: Client[]) => {
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
