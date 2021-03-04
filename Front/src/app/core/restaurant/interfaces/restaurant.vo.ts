import { Photo } from '../../photo/interfaces/photo.vo';
import { Plat } from '../../plat/interfaces/plat.vo';

export interface Restaurant {
    id?: number;
    nom: string;
    description: string;
    photo: Photo;
    plat?: Array<Plat>;
}
