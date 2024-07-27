import { Component } from '@angular/core';
import { ChangeNumberComponent } from '../change-number/change-number.component';
import { ParentDataComponent } from '../parent-data/parent-data.component';

@Component({
  selector: 'app-emitter',
  standalone: true,
  imports: [ChangeNumberComponent, ParentDataComponent],
  templateUrl: './emitter.component.html',
  styleUrl: './emitter.component.css'
})
export class EmitterComponent {
  myNumber = 10;

  randomNumber(): void{
    this.myNumber = Math.floor(Math.random()*10);
  }
}
