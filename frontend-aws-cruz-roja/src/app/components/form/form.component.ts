import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { faChevronLeft, faChevronRight } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  faChevronLeft = faChevronLeft;
  faChevronRight = faChevronRight;

  ocultarFrom1: boolean = false;
  ocultarFrom2: boolean = true;
  ocultarFrom3: boolean = true;
  ocultarFrom4: boolean = true;
  ocultarFromFinal: boolean = true;

  formularioCruz!: FormGroup;

  validForm: boolean = false;

  constructor(private fb: FormBuilder) {
    this.iniciaFormulario();

  }

  iniciaFormulario() {
    this.formularioCruz = this.fb.group({
      nombre: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]*$')]],
      apellidos: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]*$')]],
      sexo: ['', [Validators.required, Validators.pattern('^(hombre|mujer|otro)$')]],
      fechaNac: ['', [Validators.required, Validators.required]],
      estCivil: ['', [Validators.required, Validators.required]],
      numHijos: ['', [Validators.required, Validators.required]],
      tipoFam: ['', [Validators.required, Validators.required]]
    });
  }

  preForm(idForm: string) {
    if (idForm == 'form2') {
      this.ocultarFrom1 = false;
      this.ocultarFrom2 = true;
    }
    if (idForm == 'form3') {
      this.ocultarFrom2 = false;
      this.ocultarFrom3 = true;
    }
    if (idForm == 'form4') {
      this.ocultarFrom3 = false;
      this.ocultarFrom4 = true;
    }
  }
  nextForm(idForm: string) {
    if (idForm == 'form1' && this.formularioCruz.get('nombre')?.valid && this.formularioCruz.get('apellidos')?.valid) {
      this.ocultarFrom1 = true;
      this.ocultarFrom2 = false;
    }
    if (idForm == 'form2' && this.formularioCruz.get('sexo')?.valid && this.formularioCruz.get('fechaNac')?.valid) {
      this.ocultarFrom2 = true;
      this.ocultarFrom3 = false;
    }
    if (idForm == 'form3' && this.formularioCruz.get('estCivil')?.valid && this.formularioCruz.get('numHijos')?.valid) {
      this.ocultarFrom3 = true;
      this.ocultarFrom4 = false;
    }
    if (idForm == 'form4' && this.formularioCruz.get('nombre')?.valid && this.formularioCruz.get('apellidos')?.valid) {
      this.ocultarFrom4 = true;
      this.ocultarFromFinal = false;
    }
  }
  enviar() {
    if (this.formularioCruz.get('tipoFam')?.valid) {
      this.validForm = true;
    }
  }
  volver(){
    localStorage.removeItem('carouselSelections');
  }
}
