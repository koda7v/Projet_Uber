import { Photo } from '../../photo/interfaces/photo.vo';

export interface Restaurant {
    id?: number;
    nom: string;
    description: string;
    photo: Photo;
}
