import { Component } from '@angular/core';
import { faChevronLeft, faChevronRight } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-acogida',
  templateUrl: './acogida.component.html',
  styleUrls: ['./acogida.component.css']
})
export class AcogidaComponent {
  faChevronLeft = faChevronLeft;
  faChevronRight = faChevronRight;
}
