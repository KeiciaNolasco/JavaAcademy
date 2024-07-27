import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FirstComponentComponent } from './components/first-component/first-component.component';
import { ParentDataComponent } from './components/parent-data/parent-data.component';
import { DirectiveComponent } from './components/directive/directive.component';
import { IfRenderComponent } from './components/if-render/if-render.component';
import { EventComponent } from './components/event/event.component';
import { EmitterComponent } from './components/emitter/emitter.component';
import { ChangeNumberComponent } from './components/change-number/change-number.component';
import { ListRenderComponent } from './components/list-render/list-render.component';
import { PipeOperatorComponent } from './components/pipe-operator/pipe-operator.component';
import { TwoWayBindingComponent } from './components/two-way-binding/two-way-binding.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    FirstComponentComponent,
    ParentDataComponent,
    DirectiveComponent,
    IfRenderComponent,
    EventComponent,
    EmitterComponent,
    ListRenderComponent,
    PipeOperatorComponent,
    TwoWayBindingComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'O titulo que estou passando é esseadsadadad';
}
