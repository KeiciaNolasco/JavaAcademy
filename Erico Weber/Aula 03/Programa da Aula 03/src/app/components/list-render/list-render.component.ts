import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Car } from '../../interfaces/Car';

@Component({
  selector: 'app-list-render',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-render.component.html',
  styleUrl: './list-render.component.css'
})
export class ListRenderComponent {
  // carList = [
  //   "208",
  //   "Fusca",
  //   "Chevette",
  //   "Corsa"
  // ];
  carList: Car[] = [
    { name: '208', brand: 'Peugeot' },
    { name: 'Fusca', brand: 'Volks' },
    { name: 'Chevette', brand: 'Chevrolet' },
    { name: 'Corsa', brand: 'Chevrolet'},
  ]
}

