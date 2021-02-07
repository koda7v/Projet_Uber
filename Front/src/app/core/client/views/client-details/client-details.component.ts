import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadcrumbService } from 'xng-breadcrumb';

import { ClientService } from 'src/app/core/client/services/client.service';
import { Client } from 'src/app/core/client/interfaces/client.vo';

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.scss']
})
export class ClientDetailsComponent implements OnInit {
  pageTitle = 'Profil';
  client: Client;

  constructor(
    private breadcrumbService: BreadcrumbService,
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.retrieveClient(+this.route.snapshot.paramMap.get('id'));
  }

  retrieveClient(id: number): void {
    this.clientService.get(id).subscribe(
      (data) => {
        this.client = data;
        this.setBreadcrumbAlias();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  setBreadcrumbAlias(): void {
    this.breadcrumbService.set(
      '@clientName',
      `${this.client.cli_prenom} ${this.client.cli_nom}`
    );
  }
}
