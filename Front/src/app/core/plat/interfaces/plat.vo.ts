import { Photo } from '../../photo/interfaces/photo.vo';

export interface Plat {
    id?: number;
    nom: string;
    description: string;
    prix: number;
    photo: Photo;
    restaurantId: number;
}