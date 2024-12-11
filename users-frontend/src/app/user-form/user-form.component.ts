import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
import { FormControl, FormGroup, Validators,  } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent {

  user: User;
  userForm: FormGroup;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private userService: UserService) {
    this.user = new User();
    this.userForm = new FormGroup({
      name: new FormControl(this.user.name, Validators.required),
      surname: new FormControl(this.user.surname, Validators.required),
      email: new FormControl(this.user.email, [
        Validators.required,
        Validators.email
      ])
    });
  }

  submitForm() {
    if(this.userForm.valid) {
      this.user.name = this.userForm.get('name')?.value;
      this.user.surname = this.userForm.get('surname')?.value;
      this.user.email = this.userForm.get('email')?.value;
      this.userService.save(this.user).subscribe(result => this.gotoUserList());
    } else {
      this.userForm.markAllAsTouched();
      this.userForm.updateValueAndValidity();
    }
  }

  isTouchedOrDirty(paramName: string): boolean {
    var isTouchedOrDirty = this.userForm.get(paramName)?.touched || this.userForm.get(paramName)?.dirty; 
    return isTouchedOrDirty === undefined ? false : isTouchedOrDirty;
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
