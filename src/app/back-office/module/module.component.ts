import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModuleService } from 'src/app/services/module.service';
import { Module } from 'src/app/models/Module';

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {
  modules!: Module[];
  moduleForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private moduleService: ModuleService) { }

  ngOnInit(): void {
    this.loadModules();
    this.initializeForm();
  }

  loadModules() {
    this.moduleService.getAllModules().subscribe(
      modules => this.modules = modules,
      error => console.log(error)
    );
  }

  initializeForm() {
    this.moduleForm = this.formBuilder.group({
      libModule: ['', Validators.required],
      nameTabModule: ['', Validators.required],
    });
  }

  onSubmit() {
    const formData = this.moduleForm.value;

    this.moduleService.createModule(formData).subscribe(
      () => {
        console.log('Module created successfully');
        this.resetForm();
        this.loadModules();
      },
      error => console.log(error)
    );
  }

  deleteModule(id: number) {
    this.moduleService.deleteModule(id).subscribe(
      () => {
        console.log('Module deleted successfully');
        this.loadModules();
      },
      error => console.log(error)
    );
  }

  resetForm() {
    this.moduleForm.reset();
  }
}