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

  mensajesMap: Map<string, string> = new Map();
  getCardInformation(identificator: string) {
    switch (identificator) {
      case 'tarjeta1':
        this.mensajesMap.set('tarjeta1', 'Porque quiero ayudar a los niños');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta2':
        this.mensajesMap.set('tarjeta2', 'Porque asi me siento mejor');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta3':
        this.mensajesMap.set('tarjeta3', 'Quiero ayudar');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta4':
        this.mensajesMap.set('tarjeta4', 'Son ellos el futuro');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta5':
        this.mensajesMap.set('tarjeta5', 'No estoy seguro');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta6':
        this.mensajesMap.set('tarjeta6', 'Quiero hacerme responsable');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta7':
        this.mensajesMap.set('tarjeta7', 'Quiero brindar oportunidades');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta8':
        this.mensajesMap.set('tarjeta8', 'Quiero dar un hogar');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta9':
        this.mensajesMap.set('tarjeta9', 'Puedo dar apoyo alimenticio');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta10':
        this.mensajesMap.set('tarjeta10', 'No estoy seguro');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjet11':
        this.mensajesMap.set('tarjeta11', 'Acogimiento familiar de urgencia');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta12':
        this.mensajesMap.set('tarjeta12', 'Temporal');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta13':
        this.mensajesMap.set('tarjeta13', 'Permanente');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta14':
        this.mensajesMap.set('tarjeta14', 'Especializado');
        // Realizar acciones adicionales si es necesario
        break;
      case 'tarjeta15':
        this.mensajesMap.set('tarjeta15', 'Profesional');
        // Realizar acciones adicionales si es necesario
        break;

    }

    console.log(this.mensajesMap);
  }
}
