import { Component, OnInit } from '@angular/core';
import { AttributService } from 'src/app/services/attribut.service';
import { ModuleService } from 'src/app/services/module.service';
import { Attribut } from 'src/app/models/Attribut';
import { Module } from 'src/app/models/Module';
@Component({
  selector: 'app-attribut',
  templateUrl: './attribut.component.html',
  styleUrls: ['./attribut.component.css']
})
export class AttributComponent implements OnInit {
  attributs: Attribut[] = [];
  newAttribut: Attribut = {} as Attribut;
  selectedModuleId: number | undefined;
  modules: Module[] = [];
  attributToUpdate: Attribut = {} as Attribut;
  isEditMode: boolean = false;

  constructor(
    private attributsService: AttributService,
    private moduleService: ModuleService
  ) {}

  ngOnInit(): void {
    this.getAllAttributs();
    this.loadModules();
  }

  getAllAttributs() {
    this.attributsService.getAllAttributs().subscribe(data => {
      this.attributs = data;
    });
  }

  loadModules() {
    this.moduleService.getAllModules().subscribe(data => {
      this.modules = data;
    });
  }

  addAttribut() {
    if (this.selectedModuleId) {
      this.attributsService.addAttributsToModule(this.newAttribut, this.selectedModuleId)
        .subscribe(() => {
          this.getAllAttributs();
          this.newAttribut = {} as Attribut;
        });
    }
  }

  updateAttribut(): void {
    this.attributsService.updateAttribut(this.attributToUpdate)
      .subscribe(() => {
        this.getAllAttributs();
        this.clearAttributToUpdate();
        this.isEditMode = false; // Exit edit mode after update
      });
  }

  deleteAttribut(id: number): void {
    this.attributsService.deleteAttribut(id)
      .subscribe(() => this.getAllAttributs());
  }

  editAttribut(attribut: Attribut): void {
    this.attributToUpdate = { ...attribut };
    this.isEditMode = true;
  }

  cancelEdit(): void {
    this.clearAttributToUpdate();
    this.isEditMode = false;
  }

  private clearAttributToUpdate(): void {
    this.attributToUpdate = {} as Attribut;
  }
}