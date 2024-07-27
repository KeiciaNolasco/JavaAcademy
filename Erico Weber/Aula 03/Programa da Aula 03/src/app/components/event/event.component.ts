import { NgIf } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [NgIf],
  templateUrl: './event.component.html',
  styleUrl: './event.component.css'
})
export class EventComponent {
  showMessage = true;

  toogleMessage(): void{ 
    this.showMessage = !this.showMessage;
  }
}
