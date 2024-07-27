import { UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe-operator',
  standalone: true,
  imports: [UpperCasePipe],
  templateUrl: './pipe-operator.component.html',
  styleUrl: './pipe-operator.component.css'
})
export class PipeOperatorComponent {
  subtitle= 'Teste do texto';
}
