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

  ocultaCarousel1: boolean = false;
  ocultaCarousel2: boolean = true;
  ocultaCarousel3: boolean = true;

  mensajesMap: Map<string, string> = new Map();
  
  ngAfterViewInit(){
    let messageJson: string | null = localStorage.getItem('carouselSelections');
    if(messageJson !== null){
      this.mensajesMap = new Map(JSON.parse(messageJson));
      this.mensajesMap.forEach((tarjeta)=> {
        console.log(tarjeta);
          let element = document.getElementById(tarjeta);
          console.log(element);
          element?.classList.add('card-container-selected');
      });
    }
  }

  paintCard(){
    const selectedElements = document.querySelectorAll('.card-container-selected');
      selectedElements.forEach ((elem) => {
        elem.classList.remove('card-container-selected');
      });
    this.mensajesMap.forEach((tarjeta)=> {
      if (tarjeta) {
        let element = document.getElementById(tarjeta);
        element?.classList.add('card-container-selected');
      }
    });
  }
  getCardInformation( carousel:string, tarjeta: string) {
    this.mensajesMap.set(carousel, tarjeta);
    this.paintCard();
  }

  prevCarousel(carousel:string){
    if(carousel=='carousel2'){
      this.ocultaCarousel1 = false;
      this.ocultaCarousel2 = true;
    }
    if(carousel=='carousel3'){
      this.ocultaCarousel2 = false;
      this.ocultaCarousel3 = true;
    }
  }

  nextCarousel(carousel:string){
    if(carousel=='carousel1'){
      this.ocultaCarousel1 = true;
      this.ocultaCarousel2 = false;
    }
    if(carousel=='carousel2'){
      this.ocultaCarousel2 = true;
      this.ocultaCarousel3 = false;
    }
  }
  saveFirstData(){
    const saveJson = JSON.stringify(Array.from(this.mensajesMap.entries()));
    localStorage.setItem('carouselSelections',saveJson);
  }
}
