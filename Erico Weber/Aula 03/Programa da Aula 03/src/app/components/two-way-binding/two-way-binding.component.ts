import { NgClass, NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AnimalsServiceService } from '../../services/animals-service.service';

@Component({
  selector: 'app-two-way-binding',
  standalone: true,
  imports: [FormsModule, NgIf, NgFor],
  templateUrl: './two-way-binding.component.html',
  styleUrl: './two-way-binding.component.css'
})
export class TwoWayBindingComponent {
  listAnimals: string[] = []
  constructor(private animalService: AnimalsServiceService) { }

  animal: string = ''

  addAnimal() {
    this.animalService.add(this.animal);
  }

  showAnimals() {
    this.listAnimals = this.animalService.show();
  }
}
