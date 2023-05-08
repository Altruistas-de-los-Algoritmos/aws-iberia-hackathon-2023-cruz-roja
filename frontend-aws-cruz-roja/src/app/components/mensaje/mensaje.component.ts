import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-mensaje',
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.css']
})
export class MensajeComponent {
  @Input() selection: string = '';
  message: string = '';

  ngOnInit() {
    console.log(this.selection);
    if (this.selection) {
      switch (this.selection) {
        case 'tarjeta1':
          this.message = 'Porque quiero ayudar a los niños';
          break;
        case 'tarjeta2':
          this.message = 'Porque asi me siento mejor';
          break;
        case 'tarjeta3':
          this.message = 'Quiero ayudar';
          break;
        case 'tarjeta4':
          this.message = 'Porque ellos son el futuro';
          break;
        case 'tarjeta5':
          this.message = 'No estoy seguro';
          break;
        case 'tarjeta6':
          this.message = 'Porque asi me siento mejor';
          break;
        case 'tarjeta7':
          this.message = 'Quiero brindar oportunidades';
          break;
        case 'tarjeta8':
          this.message = 'Quiero dar un hogar';
          break;
        case 'tarjeta9':
          this.message = 'Quiero alimentar';
          break;
        case 'tarjeta10':
          this.message = 'No estoy seguro';
          break;
        case 'tarjeta11':
          this.message = 'Urgente';
          break;
        case 'tarjeta12':
          this.message = 'Temporal';
          break;
        case 'tarjeta13':
          this.message = 'Permanente';
          break;
        case 'tarjeta14':
          this.message = 'Especializado';
          break;
        case 'tarjeta15':
          this.message = 'Profesional';
          break;

        default:
          this.message = 'No hay opciones';
      }
    }
  }
}
