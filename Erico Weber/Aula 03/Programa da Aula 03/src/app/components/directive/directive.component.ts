import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directive',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './directive.component.html',
  styleUrl: './directive.component.css'
})
export class DirectiveComponent {
  styleClass=['small-title', 'green-title'];
  showAccessibility = true;
  currentStyle: Record<string, string>  ={
    'font-size': this.showAccessibility ? '24px': '14px'
  }

}
