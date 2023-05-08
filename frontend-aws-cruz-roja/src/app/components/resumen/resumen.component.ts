import { Component } from '@angular/core';

@Component({
  selector: 'app-resumen',
  templateUrl: './resumen.component.html',
  styleUrls: ['./resumen.component.css']
})
export class ResumenComponent {
  carouselSelection: any[] = [];
  ngOnInit(): void {
    const carouselSelections = localStorage.getItem('carouselSelections');
    if (carouselSelections !== null) {
      this.carouselSelection = JSON.parse(carouselSelections);
    } else {
      // Si no hay datos en el almacenamiento local, se podría inicializar el array a un valor predeterminado
      this.carouselSelection = [];
    }
  }
  
  
}
