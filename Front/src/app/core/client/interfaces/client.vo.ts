export enum Civilite {
  M = 'M',
  MME = 'Mme'
}

export interface Client {
  cli_id?: number;
  cli_nom: string;
  cli_prenom: string;
  cli_numero_tel: number;
  cli_email: string;
  cli_adresse: string;
}
