import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { Vender } from '../vender';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  vender=new Vender();
  venders:Vender[];
  message:string;

  constructor(private router:Router,private loginService : LoginService) { }

  ngOnInit() {
  }

 validLogin(form:NgForm){

   this.loginService.LoginCheck(form.value).subscribe(data=>{
   console.log(data);
   this.vender=data;
  
   console.log(this.vender);
     
     if(this.vender.userid == 1)
     {
       console.log(data.username);
       this.router.navigate(['viewVender']);
     }
     else if(this.vender.userid == 2)
     {
      console.log(data.username);
      this.router.navigate(['viewVender']);
     }
     else{
       this.message="Incorrect username or password";
     }
   },
   (error) =>{
     console.log(error);
   });
   }


}
