export enum Civilite {
  M = 'M',
  MME = 'Mme'
}

export interface Client {
  id?: number;
  civilite: Civilite;
  nom: string;
  prenom: string;
  agence: string;
  entreprise: string;
  dateDeNaissance: Date;
}
