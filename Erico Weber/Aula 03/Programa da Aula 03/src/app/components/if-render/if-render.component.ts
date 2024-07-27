import { NgIf } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-if-render',
  standalone: true,
  imports: [NgIf],
  templateUrl: './if-render.component.html',
  styleUrl: './if-render.component.css'
})
export class IfRenderComponent {
  name: string = 'Erico';
  canShow: boolean = false;
}
