import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AnimalsServiceService {
  animalList = ['Cachorro', 'Gato'];

  constructor() { }

  add(animal :string){
    this.animalList.push(animal);
  }

  show(){
    return this.animalList;
  }
}
