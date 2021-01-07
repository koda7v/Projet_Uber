import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadcrumbService } from 'xng-breadcrumb';

import { PersonneService } from 'src/app/core/personne/services/personne.service';
import { Personne } from 'src/app/core/personne/interfaces/personne.vo';

@Component({
  selector: 'app-personne-details',
  templateUrl: './personne-details.component.html',
  styleUrls: ['./personne-details.component.scss']
})
export class PersonneDetailsComponent implements OnInit {
  pageTitle = 'Profil';
  personne: Personne;

  constructor(
    private breadcrumbService: BreadcrumbService,
    private personneService: PersonneService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.retrievePersonne(+this.route.snapshot.paramMap.get('id'));
  }

  retrievePersonne(id: number): void {
    this.personneService.get(id).subscribe(
      (data) => {
        this.personne = data;
        this.setBreadcrumbAlias();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setBreadcrumbAlias(): void {
    this.breadcrumbService.set(
      '@personneName',
      `${this.personne.prenom} ${this.personne.nom}`
    );
  }
}
